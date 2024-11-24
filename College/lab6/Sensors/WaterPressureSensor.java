package Sensors;


public class WaterPressureSensor {
    private double pressure;
    private final double minPressure;
    private final double maxPressure;
    private boolean isAlert;


    // constructor
    public WaterPressureSensor(double minPressure, double maxPressure) {
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.pressure = 0.0;
        this.isAlert = false;
    }


    // method
    private void checkPressure() {
        if (pressure < minPressure) {
            isAlert = true;
            System.out.println("Alert: Water pressure is too low! Current pressure: " + pressure + " bar.");
        }

        else if (pressure > maxPressure) {
            isAlert = true;
            System.out.println("Alert: Water pressure is too high! Current pressure: " + pressure + " bar.");
        }

        else {
            isAlert = false;
            System.out.println("Water pressure is in the norm. Current pressure: " + pressure + " bar.");
        }
    }

   // getters
    public double getPressure() {
        return pressure;
    }

    public boolean isAlert() {
        return isAlert;
    }

    public double getMinPressure() {
        return minPressure;
    }


    // setters
    public void setPressure(double pressure) {
        this.pressure = pressure;
        checkPressure();
    }

    public double getMaxPressure() {
        return maxPressure;
    }

}

