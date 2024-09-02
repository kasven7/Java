import java.util.Scanner;


public class Tree{

    static void drawtree(int height, char symbol){
        for(int i = 1; i <= height; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(symbol);
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the height of your tree: ");
        int height = scanner.nextInt();

        System.out.println("Enter the symbol of your tree: ");
        char symbol = scanner.next().charAt(0);

        System.out.println("Here is your tree!: ");
        drawtree(height, symbol);
    }
}