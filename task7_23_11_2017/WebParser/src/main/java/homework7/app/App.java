package homework7.app;

import homework7.app.entities.StatisticsPage;
import homework7.app.entities.URLPage;
import homework7.app.tasks.Task7_1;

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
        Task7_1 task7_1 = new Task7_1(url);
        //ститистика по 20 найденным страницам
        Map<String, TreeMap<Integer, LinkedList<String>>> result1 = task7_1.getWordsSortedByFrequency();

        //поиск URL по слову
        Map<String, Integer> urlMap = task7_1.getUrlsByWords("Україна");

        System.out.println("Слово \"Україна\" содержится по таким адресам:");
        System.out.print(urlMap);
    }
}
