package list2_1_p;

public class Space2D {
    private double x;
    private double y;


    // constructors
    public Space2D(){
        x = 0;
        y = 0;
    }

    public Space2D(double x, double y){
        this.x = x;
        this.y = y;
    }


    // getters

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    // setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    // display values
    public void displayX(){
        System.out.print("X = " + x);
    }

    public void displayY(){
        System.out.print("Y = " + y);
    }


    // methods
    public double calcDistanceBetweenPoints(Space2D A, Space2D B){
        return (Math.sqrt(Math.pow(B.getX() - A.getX(), 2) + Math.pow((B.getY() - A.getY()), 2)));
    }

    public double calcDistanceFromStart(Space2D P){
        return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }

    public double calcTriangleCircuit(Space2D A, Space2D B, Space2D C){
        double a = calcDistanceBetweenPoints(A, B);
        double b = calcDistanceBetweenPoints(A, C);
        double c = calcDistanceBetweenPoints(B, C);


        return (a + b + c);
    }

    public double calcAreaOfTriangleHeronP(Space2D A, Space2D B, Space2D C){
        double s = calcTriangleCircuit(A, B, C);
        double a = calcDistanceBetweenPoints(A, B);
        double b = calcDistanceBetweenPoints(A, C);
        double c = calcDistanceBetweenPoints(B, C);


        return (Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }

    @Override
    public String toString() {
        return "Space2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
