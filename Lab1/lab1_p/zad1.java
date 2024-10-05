package lab1_p;
import java.util.Scanner;


class zad1{

    static void drawATree(int height){
        for(int i = 0; i < height; i++){
            for(int k = height - i - 1; k >= 0; k--){
                System.out.print(" ");
            }

            System.out.print("*");
            for(int j=0; j<i; j++){
                System.out.print("**");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the height of your tree: ");
        int height = sc.nextInt();

        drawATree(height);

    }
}