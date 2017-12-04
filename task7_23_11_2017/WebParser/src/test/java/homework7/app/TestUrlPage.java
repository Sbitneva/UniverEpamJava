package homework7.app;

import homework7.app.entities.StatisticsPage;
import homework7.app.entities.URLPage;
import homework7.app.entities.URLReader;
import homework7.app.tasks.Task7_1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@RunWith(PowerMockRunner.class)
@PrepareForTest({URLReader.class, URLPage.class, URL.class, StatisticsPage.class, Task7_1.class})
public class TestUrlPage {

    public URL randUrl;

    public String html;

    public String text;
    @Test
    public void testURLPage() throws Exception{

        html = URLReader.readUrl(new URL("file:///home/mariia/Documents/MavenProjects/UniverEpamJava/UniverEpamJava/" +
                "task7_23_11_2017/RegEx/src/test/java/homework7/app/text.html"));

        text =  URLReader.readUrl(new URL("file:///home/mariia/Documents/MavenProjects/UniverEpamJava/" +
                "UniverEpamJava/task7_23_11_2017/RegEx/src/test/java/homework7/app/smallText"));

        randUrl = new URL("https://stackoverflow.com");

        PowerMockito.spy(URLReader.class);
        PowerMockito.mockStatic(URLReader.class);
        Mockito.when(URLReader.readUrl(any(URL.class))).thenReturn(html);

        String result = URLReader.readUrl(randUrl);
        URLPage mockUrlPage = new URLPage(randUrl);
        URL urls[] = mockUrlPage.getURLs();

        assertTrue(urls.length == 20);
        Mockito.when(URLReader.readUrl(any(URL.class))).thenReturn(text);
        Map<String, Integer> stringIntegerMap = new HashMap<>();

        StatisticsPage statisticsPage = new StatisticsPage(randUrl);
        stringIntegerMap = statisticsPage.getWordsMap();

        assertTrue(stringIntegerMap.containsKey("Монтекки"));
        Integer value = stringIntegerMap.get("Монтекки");
        assertTrue(value == 8);

        TreeMap<Integer, LinkedList<String>> treeMap = new TreeMap<>();
        treeMap = statisticsPage.getStatisticsByUrl();
        assertTrue(treeMap.get(8).size() == 2);
        assertTrue(statisticsPage.hasUrlsByWord("Монтекки"));
    }
}
