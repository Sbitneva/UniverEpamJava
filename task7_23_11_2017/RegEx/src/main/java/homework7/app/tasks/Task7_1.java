package homework7.app.tasks;

import homework7.app.entities.StatisticsPage;
import homework7.app.entities.URLPage;

import java.net.URL;
import java.util.*;

public class Task7_1 {
    URL url;
    URLPage page;
    URL urls[];
    Map<String, TreeMap<Integer, LinkedList<String>>> wordsSortedByFrequency;
    ArrayList<StatisticsPage> statisticsPages;


    public Task7_1(URL url){

        this.url = url;
        this.page = new URLPage(this.url);
        this.urls = page.getURLs();
        this.wordsSortedByFrequency = new TreeMap<>();
        this.statisticsPages = new ArrayList<>();
        for (URL u:urls) {
            System.out.println(u);
            StatisticsPage statisticsPage = new StatisticsPage(u);
            wordsSortedByFrequency.put(statisticsPage.getUrl().toString(), statisticsPage.getStatisticsByUrl());
            statisticsPages.add(statisticsPage);
        }
    }

    public Map<String, TreeMap<Integer, LinkedList<String>>> getWordsSortedByFrequency() {
        return wordsSortedByFrequency;
    }

    public Map<String, Integer> getUrlsByWords(String word){
        Map<String, Integer> urlsContainWord = new TreeMap<>();
        for (StatisticsPage statisticsPage:statisticsPages) {
            if(statisticsPage.hasUrlsByWord(word)){
                urlsContainWord.put(statisticsPage.getUrl().toString(), statisticsPage.getWordsMap().get(word));
            }
        }
        return urlsContainWord;
    }
}
