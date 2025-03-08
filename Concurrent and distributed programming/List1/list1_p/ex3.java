package list1;
import java.util.Random;
import java.util.Scanner;


public class ex3 {
    static int largestIndex = -1;


    public static double countMean(int[] tab){
        int sum = 0;

        for(int i = 0; i < tab.length; i++){
            sum += tab[i];
        }

        return (double) sum / tab.length;
    }

    public static void displayTable(int[] tab){
        System.out.print("{");
        for(int i = 0; i < tab.length; i++){
            System.out.print(tab[i]);
            if(i != tab.length - 1)
                System.out.print(", ");
        }
        System.out.print("}");
        System.out.println();
    }

    public static void displayReversedTable(int[] tab){
        System.out.print("{");
        for(int i = tab.length - 1; i >= 0; i--) {
            System.out.print(tab[i]);
            if(i != 0)
            System.out.print(", ");
        }
        System.out.print("}");
        System.out.println();
    }

    public static void reverseTable(int[] tab){
        int left = 0;
        int right = tab.length - 1;

        while(right > left){
            int buff = tab[left];
            tab[left] = tab[right];
            tab[right] = buff;

            left++;
            right--;
        }
    }

    public static void fillTable(int[] tab){
        Random rand = new Random();

        for(int i = 0; i < tab.length; i++){
            tab[i] = rand.nextInt(100) + 1;
        }
    }

    public static int findLargestEl(int[] tab){
        int largestElement = tab[0];

        for(int i = 1; i < tab.length; i++){
            if(largestElement < tab[i] ) {
                largestElement = tab[i];
            }
        }

        return largestElement;
    }

    public static int findSmallestEl(int[] tab){
        int smallestElement = tab[0];

        for(int i = 1; i < tab.length; i++){
            if(smallestElement > tab[i])
                smallestElement = tab[i];
        }

        return smallestElement;
    }

    public static int[] findThreeLargestEls(int[] tab){
        int[] threeLargestElements = new int[3];
        int[] indexes = {-7, -7, -7};


        for(int i = 0; i < 3; i++) {
            int largestElement = Integer.MIN_VALUE;
            largestIndex = -7;

            for(int j = 0; j < tab.length; j++){
                boolean isAlreadyUsed = false;

                for(int k = 0; k < 2; k++){
                    if(indexes[k] == j){
                        isAlreadyUsed = true;
                        break;
                    }
                }

                if(!isAlreadyUsed && largestElement < tab[j]){
                    largestElement = tab[j];
                    largestIndex = j;
                }
            }

            if(indexes[i] == -7){
                threeLargestElements[i] = largestElement;
                indexes[i] = largestIndex;
            }
        }

        return threeLargestElements;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of your table: ");
        final int N = in.nextInt();
        int[] tab = new int[N];


        fillTable(tab);

        System.out.println("Table: ");
        displayTable(tab);

        System.out.println("The largest element in the table: " + findLargestEl(tab));
        System.out.println("The smallest element in the table: " + findSmallestEl(tab));

        System.out.println("The three largest elements in the table are: ");
        int[] threeLargestElements = findThreeLargestEls(tab);
        displayTable(threeLargestElements);

        System.out.println("Mean: " + countMean(tab));
        System.out.println("Reversed table: ");
        displayReversedTable(tab);

        reverseTable(tab);

        System.out.println("Reversed reference: ");
        displayTable(tab);
    }
}
