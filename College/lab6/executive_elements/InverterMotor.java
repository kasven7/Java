package executive_elements;

public class InverterMotor {
    private boolean isClockwise;
    private boolean isRunning;
    private double speed;


    // constructor
    public InverterMotor(){
        speed = 0.0;
        isClockwise = true;
        isRunning = false;
    }


    // methods
    public void start(){
        if(!isRunning){
            System.out.println("Motor starts to run.");
            isRunning = true;
            speed = 7.0;
        }

        else
            System.out.println("Motor is already running.");
    }

    public void stop(){
        if(isRunning){
            System.out.println("Motor stops running.");
            isRunning = false;
            speed = 0;
        }

        else
            System.out.println("Motor has already stopped running.");
    }

    public void changeSpinDirection(){
        if(isRunning){
            isClockwise = !isClockwise;
            System.out.println("Direction changed to: " + (isClockwise ? "Clockwise" : "Counterclockwise"));
        }

        else
            System.out.println("Cannot change direction. The motor is not running.");
    }


    // getters
    public boolean isClockwise() {
        return isClockwise;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public double getSpeed() {
        return speed;
    }


    // setter
    public void setSpeed(double speed){
        if(speed <= 0){
            System.out.println("Invalid speed. Speed cannot be negative nor zero.");
            return;
        }

        else if(isRunning){
            this.speed = speed;
            System.out.println("Speed has been set to: " + this.speed + "RPM.");
        }

        else
            System.out.println("Cannot set speed. The motor is not running.");
    }
}
