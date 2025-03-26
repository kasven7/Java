public class ex4 {

    public static void main(String[] args){
        int[] tab1 = new int[15];
        int[] tab2 = new int[7];
        int[] tab3 = new int[3];


        ex3.fillTable(tab1);
        ex3.fillTable(tab2);
        ex3.fillTable(tab3);

        ex3.displayTable(tab1);
        ex3.displayTable(tab2);
        ex3.displayTable(tab3);

        int tab1Max = ex3.findLargestEl(tab1);
        int tab2Max = ex3.findLargestEl(tab2);
        int tab3Max = ex3.findLargestEl(tab3);

        System.out.println( "Largest element in tab1: " + tab1Max);
        System.out.println( "Largest element in tab2: " + tab2Max);
        System.out.println( "Largest element in tab3: " + tab3Max);

        int[] tab = new int[3];
        tab[0] = tab1Max;
        tab[1] = tab2Max;
        tab[2] = tab3Max;

        System.out.println( "Largest element in tab: " + ex3.findLargestEl(tab));
    }
}
