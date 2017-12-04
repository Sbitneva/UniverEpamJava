package app;

import app.entities.StatisticsPage;
import app.entities.URLPage;
import app.tasks.Task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class App
{


    public static void main( String[] args ) throws MalformedURLException
    {
        URL url = new URL("https://www.unian.ua");
        URLPage urlPage = new URLPage(url);
        URL urls[] = urlPage.getURLs();
        Task task = new Task(url);
        //статистика по 20 найденным страницам
        Map<String, TreeMap<Integer, LinkedList<String>>> result1 = task.getWordsSortedByFrequency();

        //поиск URL по слову
        Map<String, Integer> urlMap = task.getUrlsByWords("Україна");

        System.out.println("Слово \"Україна\" содержится по таким адресам:");
        System.out.print(urlMap);
    }
}
