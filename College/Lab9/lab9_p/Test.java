package lab9_p;
import java.util.Scanner;


public class Test {
    public static void main(String[] args){
        StudentInstitute si = new StudentInstitute();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the student's data\n\n");
        System.out.print("Enter the name of the institute: ");
        String inInstitute = in.nextLine();
        si.setInstitute(inInstitute);

        System.out.print("Enter the department's name: ");
        String inDepartment = in.nextLine();
        si.setDepartment(inDepartment);

        System.out.print("Enter the student's first name: ");
        String inFName = in.nextLine();
        si.setFName(inFName);

        System.out.print("Enter the student's second name: ");
        String inSName = in.nextLine();
        si.setSName(inSName);

        System.out.print("Enter the student's index number: ");
        int inINumber = in.nextInt();
        si.setIndexNumber(inINumber);
        System.out.println();

        in.close();
        System.out.println(si);
    }
}
