package list2_1;

public class Space3D extends Space2D {
    private double z;


    // constructors
    public Space3D(){
        super();
        z = 0;
    }

    public Space3D(double x, double y, double z){
        super(x, y);
        this.z = z;
    }


    // getter
    public double getZ() {
        return z;
    }


    // setter
    public void setZ(double z) {
        this.z = z;
    }


    // methods
    public void displayPoint(){
        System.out.print("P( ");
        super.displayX();

        System.out.print(", ");

        super.displayY();
        System.out.print(", ");

        System.out.println("Z: " + z + " )");
    }

    public double calcDistanceBetweenPoints3D(Space3D A, Space3D B){
        return (Math.sqrt(Math.pow(B.getX() - A.getX(), 2) + Math.pow((B.getY() - A.getY()), 2) + Math.pow(B.getZ() - A.getZ(), 2)));
    }

    public double calcDistanceFromStart3D(Space3D P){
        return (Math.sqrt(Math.pow(P.getX(), 2) + Math.pow(P.getY(), 2) + Math.pow(P.getZ(), 2)));
    }

    public double calcTriangleCircuit3D(Space3D A, Space3D B, Space3D C){
        double a = calcDistanceBetweenPoints3D(A, B);
        double b = calcDistanceBetweenPoints3D(A, C);
        double c = calcDistanceBetweenPoints3D(B, C);

        return (a + b + c);
    }

    public double calcAreaOfTriangleHeronP3D(Space3D A, Space3D B, Space3D C){
        double s = calcTriangleCircuit(A, B, C);
        double a = calcDistanceBetweenPoints(A, B);
        double b = calcDistanceBetweenPoints(A, C);
        double c = calcDistanceBetweenPoints(B, C);


        return (Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }

    @Override
    public String toString() {
        return super.toString() +
                " z=" + z +
                '}';
    }
}
