package task2;

import task2.factories.VehiclesFactory;
import task2.factories.StandardVehicleFactory;
import task2.utils.Menu;
import task2.vehicles.CVehicle;


import java.util.Random;
import java.util.Scanner;

/**
 * Создать абстрактный класс CVerhicle. На его основе реализовать классы CPlane,
 * CCar, CShip. Классы должны иметь возможность задавать и получать координаты,
 * параметры средства передвижения (цена, скорость, год выпуска). Для самолета
 * должна быть определена высота, для самолета и корабля - количество пассажиров.
 * Для корабля - порт приписки.
 *
 * Написать программу, создающую список объектов этих классов и динамической памяти.
 * Программа должна содержать меню, позволяющее осуществить проверку всех методов классов:
 *
 * 1. механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет
 * 2. найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000
 * 3. найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
 * 4. добавить к данной иерархии машину-амфибию, и БетМобиль, создать 3 масива сгупированых
 * по Интерфейсам Flyable, MoveAble, SwimAble
 *
 * @author Sbitneva Maria
 *
 */
public class Main {

    public static void main(String...args){
        final int vehicleAmount = 100;
        CVehicle standardVehicles[] = new CVehicle[vehicleAmount];
        CVehicle vehicles[] = new CVehicle[vehicleAmount];

        for(int i = 0; i < vehicleAmount; i++){
            Random r = new Random();
            standardVehicles[i] = StandardVehicleFactory.create(r.nextInt(3));
            vehicles[i] = VehiclesFactory.create(r.nextInt(5));
        }

        Scanner in = new Scanner(System.in);

        int result = 0;

        while (true) {
            Menu.showMenu();

            result = in.nextInt();

            switch (result) {
                case 1:
                    new Task2_1(standardVehicles);
                    break;
                case 2:
                    new Task2_2(standardVehicles);
                    break;
                case 3:
                    new Task2_3(standardVehicles);
                    break;
                case 4:
                    new Task2_4(vehicles);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Введите цифру от 1 до 5");
            }
        }
    }
}
