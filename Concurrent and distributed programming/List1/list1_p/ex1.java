package list1;
import java.util.Scanner;


public class ex1 {

    public static boolean drawATree(int height){
        for(int i = 0; i < height; i++){

            for(int k = height - i - 1; k >= 0; k--){
                System.out.print(" ");
            }

            System.out.print("*");
            for(int j=0; j<i; j++){
                System.out.print("**");
            }
            System.out.println();

            if(i == height - 1){
                int starCount = 0;
                while(starCount != 3){
                    for(int p = height - 1; p >= 0; p--){
                        System.out.print(" ");
                    }
                    System.out.println("*");
                    starCount++;
                }
            }
        }

        return true;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the height of your arrow: ");
        int height = in.nextInt();

        boolean isTreeDrawn = drawATree(height);
    }
}
