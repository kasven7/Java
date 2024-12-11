package lab5_p;
import java.util.ArrayList;
import java.time.LocalDate;


public class Autokomis {
    private ArrayList<Samochod> komis = new ArrayList<>();


    public Autokomis(){
        komis.add(new Samochod("Toyota", "Corolla", 1.8, "Sedan", "Benzyna", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 5, 10), 75000));
        komis.add(new Samochod("Honda", "Civic", 2.0, "Hatchback", "Benzyna", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 6, 5), 80000));
        komis.add(new Samochod("Ford", "Focus", 1.6, "Sedan", "Diesel", LocalDate.of(2019, 7, 20), LocalDate.of(2019, 9, 10), 70000));
        komis.add(new Samochod("BMW", "320i", 2.0, "Sedan", "Benzyna", LocalDate.of(2022, 6, 10), LocalDate.of(2022, 8, 1), 120000));
        komis.add(new Samochod("Mercedes", "A-Class", 1.5, "Hatchback", "Diesel", LocalDate.of(2020, 9, 1), LocalDate.of(2021, 2, 12), 95000));
        komis.add(new Samochod("Audi", "A4", 2.0, "Sedan", "Benzyna", LocalDate.of(2023, 4, 5), LocalDate.of(2023, 5, 15), 115000));
        komis.add(new Samochod("Volkswagen", "Golf", 1.4, "Hatchback", "Benzyna", LocalDate.of(2018, 12, 17), LocalDate.of(2019, 3, 10), 65000));
        komis.add(new Samochod("Skoda", "Octavia", 2.0, "Sedan", "Diesel", LocalDate.of(2021, 11, 22), LocalDate.of(2022, 1, 15), 78000));
        komis.add(new Samochod("Peugeot", "208", 1.2, "Hatchback", "Benzyna", LocalDate.of(2020, 5, 18), LocalDate.of(2020, 6, 30), 49000));
        komis.add(new Samochod("Opel", "Astra", 1.6, "Sedan", "Diesel", LocalDate.of(2017, 10, 25), LocalDate.of(2018, 2, 18), 55000));

    }

    public void addVehicle(Samochod s){
        komis.add(s);
    }

    public void removeVehicle(Samochod s){
        komis.remove(s);
    }

    public static void main(String[] args){
        Autokomis autokomis = new Autokomis();


        for(Samochod pojazd : autokomis.komis){
            System.out.println(pojazd);
        }
    }
}