package lab8_p;
import java.util.ArrayList;
import java.util.List;


public class Student {
    private String firstName;
    private String lastName;
    private int indexNumber;


    public Student(String firstName, String lastName, int indexNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNumber = indexNumber;
    }

    public String toString(){
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", indexNumber=" + indexNumber +
                '}';
    }


    public static void main(String[] args){
        int studentCount = 0;
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Kacper", "Kowalski", 11990);
        Student s2 = new Student("Bartek", "Urban", 10055);
        Student s3 = new Student("Oskar", "Nowak", 115190);

        System.out.println("Here is the number of students: " + students.size());
        System.out.println("Here is the third student in the list: " + students.get(2));
    }
}
