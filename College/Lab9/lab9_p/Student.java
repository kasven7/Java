package lab9_p;

public class Student {
    private String firstName;
    private String secondName;
    private int indexNumber;


    public void setFName(String firstName){this.firstName = firstName;}
    public void setSName(String secondName){this.secondName = secondName;}
    public void setIndexNumber(int indexNumber) {this.indexNumber = indexNumber;}

    public String getFirstName(){return firstName;}
    public String getSecondName(){return secondName;}
    public int getIndexNumber(){return indexNumber;}
}
