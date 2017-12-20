package sbitneva.homeworks.entities;

import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.UNICODE_CHARACTER_CLASS;

public class StatisticsPage {

    URL url;
    String urlData;
    TreeMap<Integer, LinkedList<String>> sortedUrlsByWords;
    Map<String, Integer> statistics;

    public StatisticsPage(URL url){
        this.url = url;
        try{
            urlData = URLReader.readUrl(this.url);
            sortedUrlsByWords = getStatisticsByUrl();
            this.statistics = getWordsMap();
        }catch (Exception e){

        }
    }

    public Map<String, Integer> getWordsMap(){
        Map<String, Integer> statistics = new TreeMap<String, Integer>() {};
        String plain = this.urlData.replaceAll("<[^>]*>", " ");
        Pattern pattern = Pattern.compile("(?<!\\S)\\p{Alpha}+(?!\\S)", UNICODE_CHARACTER_CLASS);
        Matcher m = pattern.matcher(plain);
        String s;
        while (m.find()){
            s = m.group();
            Integer freq = statistics.get(s);
            statistics.put(s, (freq == null) ? 1 : freq + 1);
        }
        return statistics;
    }

    public TreeMap<Integer, LinkedList<String>> getStatisticsByUrl(){
        statistics = getWordsMap();
        TreeMap<Integer, LinkedList<String>> treeMap = new TreeMap<>();
        for(Map.Entry<String, Integer> entry : this.statistics.entrySet()){
            Integer freq = entry.getValue();
            if(treeMap.containsKey(freq)){
                treeMap.get(freq).add(entry.getKey());
            }else{
                LinkedList<String> ll = new LinkedList<>();
                ll.add(entry.getKey());
                treeMap.put(entry.getValue(), ll);
            }
        }

        return treeMap;
    }

    public boolean hasUrlsByWord(String word){
        return statistics.containsKey(word);
    }

    public URL getUrl() {
        return url;
    }
}
