package Sensors;


public class WaterLevelSensor {
    private double currentWaterLevel;
    private final double minWaterLevel;
    private final double maxWaterLevel;
    private boolean isAlert;


    // constructor
    public WaterLevelSensor(double minWaterLevel, double maxWaterLevel) {
        this.minWaterLevel = minWaterLevel;
        this.maxWaterLevel = maxWaterLevel;
        this.currentWaterLevel = 0.0;
        this.isAlert = false;
    }


    // method
    private void checkWaterLevel() {
        if (currentWaterLevel < minWaterLevel) {
            isAlert = true;
            System.out.println("Alert: Water level is too low! Current water level: " + currentWaterLevel + "ml.");
        } else if (currentWaterLevel > maxWaterLevel) {
            isAlert = true;
            System.out.println("Alert: Water level is too high! Current water level: " + currentWaterLevel + "ml.");
        } else {
            isAlert = false;
            System.out.println("Water level is normal. Current water level: " + currentWaterLevel + "ml.");
        }
    }


    // setter
    public void setWaterLevel(double level) {
        this.currentWaterLevel = level;
        checkWaterLevel();
    }


    // getters
    public double getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public boolean isAlert() {
        return isAlert;
    }

    public double getMinWaterLevel() {
        return minWaterLevel;
    }

    public double getMaxWaterLevel() {
        return maxWaterLevel;
    }
}

