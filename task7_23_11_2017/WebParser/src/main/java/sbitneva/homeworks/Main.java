package sbitneva.homeworks;

import sbitneva.homeworks.entities.URLPage;
import sbitneva.homeworks.tasks.Task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.unian.ua");
        URLPage urlPage = new URLPage(url);
        URL urls[] = urlPage.getURLs();
        Task task = new Task(url);
        /* statistics by 20 URLs */
        Map<String, TreeMap<Integer, LinkedList<String>>> result1 = task.getWordsSortedByFrequency();
        Map<String, Integer> urlMap = task.getUrlsByWords("Україна");// finds URL by word
        System.out.println("Слово \"Україна\" содержится по таким адресам:");
        System.out.print(urlMap);
    }
}
