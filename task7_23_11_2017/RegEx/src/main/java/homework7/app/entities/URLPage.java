package homework7.app.entities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.annotation.Resource;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class URLPage {
    @Resource
    private URL url;
    private String dataFromURL;
    private URL urls[] = null;

    public URLPage(URL url){
        try{
            this.url = url;
            this.dataFromURL = URLReader.readUrl(this.url);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public URL[] getURLs(){
        Set<URL> finds = new HashSet<>();
        if(urls == null) {
            try {
                String strLink = this.dataFromURL;
                Document doc = Jsoup.parse(strLink);
                Elements elements = doc.select("a[href]");
                for(Element element:elements) {
                    Pattern pattern = Pattern.compile(
                            "(href|HREF)\\s*=\\s*\\\"(((http[s]?:\\/\\/)?(\\w[\\w.]+\\w)|(\\w[\\w.]+\\w))?(\\/([?#\\w_%=\\/.-]+)?)?)\\\"");
                    Matcher m = pattern.matcher(element.toString());
                    //System.out.println("Element:" + element.toString());
                    if (m.find()) {
                        String link = m.group(2);
                        try{
                            URL linkUrl = new URL(link);
                            finds.add(linkUrl);
                        }catch (Exception e){
                            if(link.length() >= 2) {
                                String substring = link.substring(0, 2);
                                if (substring.equals("//")) {
                                    try {
                                        substring = link.substring(2, link.length() - 1);
                                        URL subUrl = new URL("https://" + substring);
                                        finds.add(subUrl);
                                    } catch (Exception t) {
                                    }
                                } else {
                                    try {
                                        URL subUrl = new URL(this.url + link);
                                        finds.add(subUrl);
                                    } catch (Exception t) {
                                    }
                                }
                            }
                        }
                    }
                    if(finds.size() == 20){
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            urls = new URL[finds.size()];
            finds.toArray(urls);
        }
        return this.urls;
    }

}
