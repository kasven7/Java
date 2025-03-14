package list2_2;


public class Test {
    public static void main(String[] args){
        Watek1 w1 = new Watek1();
        Watek2 w2 = new Watek2();

        w1.setName("Watek1");
        w2.setName("Watek2");

        w1.start();
        w2.start();

        System.out.println("KONIEC PROGRAMU");

        /* 1. Gdzie się wyświetla napis? - na początku programu, a to dlatego, że main też jest wątkiem, który wykonuje się przed tymi wytworzonymi wątkami
        2. Czy efekt jest zawsze taki sam po uruchomieniu programu (przed dodaniem sleep'a)? Nie, za każdym razem wywołanie programu jest inne, dlatego, że te wątki pracują w sposób losowy (zależy kto jest większym gentle man'em i przepuści danego "pana" aby mógł pracować i wymieniają się między sobą)
        */
    }
}
