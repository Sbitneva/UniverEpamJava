import app.DomXmlParser;
import app.SaxXmlParser;
import entities.AircraftWithAmmunition;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * 1. Создать файл XML и соответствующую ему схему XSD.
 *
 * 2. При разработке XSD использовать простые и комплексные типы,
 * перечисления, шаблоны и предельные значения, обязательно использование атрибутов и типа ID.
 * 3. Сгенерировать (создать) Java-класс, соответствующий данному описанию.
 * 4. Создать Java-приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла.
 * Для разбора использовать SAX, DOM и StAX парсеры. Для сортировки объектов использовать интерфейс Comparator.
 * 5. Произвести проверку XML-документа с привлечением XSD.
 * 6. Определить метод, производящий преобразование разработанного XML-документа в документ, указанный в каждом задании.
 *     8. Военные самолеты.
 *    Военные самолеты можно описать по следующей схеме:
 *    Model – название модели.
 *    Origin – страна производства.
 *    Chars (должно быть несколько) – характеристики, могут быть следующими: тип (самолет поддержки, сопровождения,
 *    истребитель, перехватчик, разведчик), кол-во мест (1 либо 2),
 *    боекомплект (есть либо нет [разведчик], если есть, то: ракеты [0 – 10]), наличие радара.
 *    Parameters – длина (в метрах), ширина (в метрах), высота (в метрах).
 *    Price – цена (в талерах).
 *    Корневой элемент назвать Plane.
 *
 */
public class App 
{
    static Logger log = Logger.getLogger(App.class.getName());
    public static void main(String[] args)
    {
        BasicConfigurator.configure();
        //String log4jConfPath = "app.log";
        //PropertyConfigurator.configure(log4jConfPath);
        DomXmlParser domXmlParser = new DomXmlParser();
        ArrayList<AircraftWithAmmunition> aircrafts = domXmlParser.read("xml/aircraft_set_new.xml");
        log.debug("Aircraft objects are extracted:" + Arrays.deepToString(aircrafts.toArray()));
        SaxXmlParser saxXmlParser = new SaxXmlParser();
        saxXmlParser.getObjects("xml/aircraft_set_new.xml");

    }
}
