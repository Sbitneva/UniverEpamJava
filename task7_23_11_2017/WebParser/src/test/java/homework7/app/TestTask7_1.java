package homework7.app;

import homework7.app.entities.StatisticsPage;
import homework7.app.entities.URLPage;
import homework7.app.entities.URLReader;
import homework7.app.tasks.Task7_1;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.URL;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;


@RunWith(PowerMockRunner.class)
@PrepareForTest({URLReader.class, URLPage.class, URL.class, StatisticsPage.class, Task7_1.class})
public class TestTask7_1 {
    final String htmlLink = "file:///home/mariia/Documents/MavenProjects/UniverEpamJava/UniverEpamJava/" +
            "task7_23_11_2017/RegEx/src/test/java/homework7/app/source.html";

    final String smallTextLink = "file:///home/mariia/Documents/MavenProjects/UniverEpamJava/UniverEpamJava/" +
            "task7_23_11_2017/RegEx/src/test/java/homework7/app/smallText";

    @Test
    public void testTask7_1() throws Exception{

        StatisticsPage statisticsPage = new StatisticsPage(new URL(smallTextLink));
        mock(StatisticsPage.class);

        PowerMockito.spy(StatisticsPage.class);
        PowerMockito.whenNew(StatisticsPage.class).withArguments(any(URL.class)).thenReturn(statisticsPage);

        String smallText = URLReader.readUrl(new URL(smallTextLink));
        String html = URLReader.readUrl(new URL(htmlLink));

        PowerMockito.spy(URLReader.class);
        PowerMockito.mockStatic(URLReader.class);
        Mockito.when(URLReader.readUrl(any(URL.class))).thenReturn(html);

        Task7_1 task7_1 = new Task7_1(new URL(htmlLink));


        Map<String, Integer> urlsMap = task7_1.getUrlsByWords("Монтекки");
        assertTrue(urlsMap.size() == 1);
    }
}
