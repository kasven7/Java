package lab9_p;

public class StudentInstitute extends StudentUZ {
    private String institute;


    public void setInstitute(String institute) {this.institute = institute;}
    public String getInstitute(){return institute;}

    public String toString(){
        return "Student's data: {name: " + this.getFirstName() + ", second name: " + this.getSecondName() + '\n'
                + ", index number: " + this.getIndexNumber() + ", department: " + this.getDepartment() + ", institute: " + this.getInstitute() + '}';
    }
}
