package sbitneva.homeworks;

import org.apache.log4j.Logger;
import sbitneva.homeworks.entities.Accountant;
import sbitneva.homeworks.entities.Loader;
import sbitneva.homeworks.entities.Thief;
import sbitneva.homeworks.factories.RandomBigQFactory;
import sbitneva.homeworks.queue.BigQ;

/**
 * @author Sbitneva Maria
 *
 *  Первая военная задача.
 *  Темной-темной ночью прапорщики Иванов, Петров и Нечепорчук занимаются хищением военного имущества со склада
 *  родной военной части. Будучи умными людьми и отличниками боевой и строевой подготовки,
 *  прапорщики ввели разделение труда: Иванов выносит имущество со склада,
 *  Петров грузит его в грузовик, а Нечепорчук подсчитывает рыночную стоимость добычи.
 *  Требуется составить многопоточное приложение, моделирующее деятельность прапорщиков.
 *  При решении использовать парадигму «производитель-потребитель» с активным ожиданием.
 *
 */

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());
    public static boolean end_calc = false;
    public static int result = 0;

    public static void main(String... args) {
        BigQ inputQueue = RandomBigQFactory.create();
        Loader loader = new Loader(); // Pertov

        Thief thief = new Thief(inputQueue, loader); // Ivanov
        Accountant accountant = new Accountant(loader, inputQueue.size()); // Necheporchyk
        try {
            thief.join();
            loader.join();
            accountant.join();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        while (!end_calc) {
            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                log.error(e.getMessage());
            }
        }

        log.debug("RESULT = " + result);
    }
}
