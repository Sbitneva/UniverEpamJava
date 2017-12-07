import parsers.dom.DomXmlParser;
import parsers.sax.SaxXmlParser;
import entities.AircraftWithAmmunition;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import parsers.stax.StaxXmlParser;

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
public class Main
{
    static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args)
    {
        BasicConfigurator.configure();

        DomXmlParser domXmlParser = new DomXmlParser();
        ArrayList<AircraftWithAmmunition> aircraftsFromDom = domXmlParser.read("xml/aircraft_set.xml");
        log.debug("Aircraft objects are extracted from DOM parser:" + Arrays.deepToString(aircraftsFromDom.toArray()));

        SaxXmlParser saxXmlParser = new SaxXmlParser();
        ArrayList<AircraftWithAmmunition> aircraftsFromSax = saxXmlParser.getObjects("xml/aircraft_set.xml");
        log.debug("Aircraft objects are extracted from SAX parser:" + Arrays.deepToString(aircraftsFromSax.toArray()));

        StaxXmlParser staxXmlParser = new StaxXmlParser();
        ArrayList<AircraftWithAmmunition> aircraftsFromStax = staxXmlParser.getAircrafts("xml/aircraft_set.xml");
        log.debug("Aircraft objects are extracted from SAX parser:" + Arrays.deepToString(aircraftsFromStax.toArray()));

    }
}
