package app;

import app.entities.StatisticsPage;
import app.entities.URLPage;
import app.entities.URLReader;
import app.tasks.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.URL;
import java.io.File;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;


@RunWith(PowerMockRunner.class)
@PrepareForTest({URLReader.class, URLPage.class, URL.class, StatisticsPage.class, Task.class})
public class TestTask {

    @Test
    public void testTask() throws Exception{
        final URL htmlUrl = new File("src/test/java/sbitneva/homeworks/app/source.html").toURI().toURL();
        final URL smallTextUrl = new File("src/test/java/sbitneva/homeworks/app/smallText").toURI().toURL();

        StatisticsPage statisticsPage = new StatisticsPage(smallTextUrl);
        mock(StatisticsPage.class);

        PowerMockito.spy(StatisticsPage.class);
        PowerMockito.whenNew(StatisticsPage.class).withArguments(any(URL.class)).thenReturn(statisticsPage);

        String smallText = URLReader.readUrl(smallTextUrl);
        String html = URLReader.readUrl(htmlUrl);

        PowerMockito.spy(URLReader.class);
        PowerMockito.mockStatic(URLReader.class);
        Mockito.when(URLReader.readUrl(any(URL.class))).thenReturn(html);

        Task task = new Task(htmlUrl);

        Map<String, Integer> urlsMap = task.getUrlsByWords("Монтекки");
        assertTrue(urlsMap.size() == 1);
    }
}
