package lab8_p;
import java.time.LocalDate;
import java.time.Period;


public class Samochod {
    String marka;
    String model;
    double pojemnoscSilnika;
    String typNadwozia;
    String typSilnika;
    LocalDate rokProdukcji;
    LocalDate dataPierwszejRejestracji;
    double cena;


    // konstruktor
    public Samochod(String _marka, String _model, double _pojemnoscSilnika, String _typNadwozia, String _typSilnika, LocalDate _rokProdukcji, LocalDate _dataPierwszejRejestracji, double _cena){
        marka = _marka;
        model = _model;
        pojemnoscSilnika = _pojemnoscSilnika;
        typNadwozia = _typNadwozia;
        typSilnika = _typSilnika;
        rokProdukcji = _rokProdukcji;
        dataPierwszejRejestracji = _dataPierwszejRejestracji;
        cena = _cena;

    }



    // getter'y
    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public double getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    public String getTypNadwozia() {
        return typNadwozia;
    }

    public String getTypSilnika() {
        return typSilnika;
    }

    public LocalDate getRokProdukcji() {
        return rokProdukcji;
    }

    public LocalDate getDataPierwszejRejestracji() {
        return dataPierwszejRejestracji;
    }

    public double getCena() {
        return cena;
    }


    // setter'y
    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPojemnoscSilnika(double pojemnoscSilnika) {
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public void setTypNadwozia(String typNadwozia) {
        this.typNadwozia = typNadwozia;
    }

    public void setTypSilnika(String typSilnika) {
        this.typSilnika = typSilnika;
    }

    public void setRokProdukcji(LocalDate rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public void setDataPierwszejRejestracji(LocalDate dataPierwszejRejestracji) {
        this.dataPierwszejRejestracji = dataPierwszejRejestracji;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }


    // inne
    public void sprawdzGwarancje(){
        if(dataPierwszejRejestracji == null){
            System.out.println("Brak danych o pierwszej rejestracji samochodu.");
        }


        LocalDate dzis = LocalDate.now();
        Period okres = Period.between(dataPierwszejRejestracji, dzis);


        if(okres.getYears() <= 2){
            System.out.println("Samochod ma ważną gwarancję.");
        }

        else{
            System.out.println("Gwarancja samochodu wygasła");
        }
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", pojemnoscSilnika=" + pojemnoscSilnika +
                ", typNadwozia='" + typNadwozia + '\'' +
                ", typSilnika='" + typSilnika + '\'' +
                ", rokProdukcji=" + rokProdukcji +
                ", dataPierwszejRejestracji=" + dataPierwszejRejestracji +
                ", cena=" + cena +
                '}';
    }
}