package lab8_p;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;


public class Zad5 {
    public static void main(String[] args){
        List<Samochod> cars = new ArrayList<>();
        cars.add(new Samochod("Toyota", "Camri", 2.0, "Sedan", "Gas", LocalDate.of(2020, 2, 5), LocalDate.of(2021, 5, 5), 200000));
        cars.add(new Samochod("Ford", "Fiesta", 1.7, "Hatchback", "Gas", LocalDate.of(2018, 3, 4), LocalDate.of(2022, 3, 2), 100000));
        cars.add(new Samochod("Dacia", "Duster", 1.0, "Sedan", "Gas", LocalDate.of(2024, 8, 5), LocalDate.of(2024, 9, 1), 255000));
        cars.add(new Samochod("Honda", "Civic", 1.2, "Hatchback", "Gas", LocalDate.of(2023, 2, 5), LocalDate.of(2023, 3, 5), 250000));


        cars.forEach((car) -> System.out.println(car));


        List<Double> sortedEngineCap =  cars.stream()   // transforms a list of cars into a stream which allows to use oder methods
                .map((car) -> car.getPojemnoscSilnika())    // transforms the stream into car objects and gets the engine capacity of a car object
                .sorted()   // sorts these capacities in ascending order
                .collect(Collectors.toList());  // converts the stream back into the list and creates a new list containing the elements in the stream

        System.out.println( "Here are the engine capacities of every car in the list sorted in ascending order: " + sortedEngineCap);
    }
}
