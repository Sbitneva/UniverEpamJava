package app;

import entities.carriages.PassengerCoach;
import entities.trains.PassengerTrain;
import exceptions.OutOfPassengersTrainRangeException;
import entities.*;
import factories.RailwayTransportFactory;
import utils.Utils;

import java.util.ArrayList;

/**
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 *
 * 1. Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
 * 2. Каждый класс должен иметь исчерпывающее смысл название и информативный состав.
 * 3. Наследование должно применяться только тогда, когда это имеет смысл.
 * 4. При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * 5. Классы должны быть грамотно разложены по пакетам.
 * 6. Работа с консолью или консольное меню должно быть минимальным.
 * 7. Для хранения параметров инициализации можно использовать файлы.
 *
 * 8. Транспорт. Определить иерархию подвижного состава железнодорожного транспорта. Создать пассажирский поезд.
 * Посчитать общую численность пассажиров и багажа. Провести сортировку вагонов поезда на основе уровня комфортности.
 * Найти вагоны в поезде, соответствующие заданному диапазону параметров числа пассажиров.
 *
 */
public class App
{
    public static ArrayList<PassengerTrain> extractPassengerTrains(RailwayTransport railwayTransport){
        ArrayList<PassengerTrain> passengerTrains = new ArrayList<>();
        for(int i = 0; i < railwayTransport.getSize(); i++){
            if(railwayTransport.getTrains().get(i) instanceof PassengerTrain){
                passengerTrains.add((PassengerTrain) railwayTransport.getTrains().get(i));
            }
        }
        return passengerTrains;
    }

    public static void sortCarriagesByComfort(PassengerTrain train){
        System.out.print("\nTrain's car before sorting by comfort\n\n");
        Utils.printCarriagesByLevels(train);
        train.sortCarriagesByComfort();
        System.out.print("\nTrain's car after sorting by comfort\n\n");
        Utils.printCarriagesByLevels(train);
    }

    public static void getCarriagesByPassengersAmountInRange(PassengerTrain train, int start, int end){
        System.out.print("\n Train cars by passengers amount \n");
        Utils.printCarriagesByPassengers(train);
        ArrayList<PassengerCoach> res = train.getCarriagesByPassengersInRange(start, end);
        System.out.print("\nTrain's cars in range " + start + "..." + end + " :\n\n");
        Utils.printCarriagesByPassengers(res);
    }

    public static void main( String[] args ) throws OutOfPassengersTrainRangeException
    {
        RailwayTransport railwayTransport = RailwayTransportFactory.createRandom();
        ArrayList<PassengerTrain> passengerTrains = extractPassengerTrains(railwayTransport);
        if(passengerTrains.size() != 0){
            PassengerTrain train = passengerTrains.get(0);
            sortCarriagesByComfort(train);
            getCarriagesByPassengersAmountInRange(train, 3, 20);
            System.out.println("\nTotal ammount of passengers:" + train.getPassengersAmount());
            System.out.println("\nTotal ammount of baggage:" + train.getBaggageAmount());
        }
    }

}
