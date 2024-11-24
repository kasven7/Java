package Sensors;

public class DrumWeightSensor {
    private double currentWeight;
    private final double maxWeightLimit;
    private boolean isOverloaded;

    // constructor
    public DrumWeightSensor(double maxWeightLimit) {
        this.maxWeightLimit = maxWeightLimit;
        this.currentWeight = 0.0;
        this.isOverloaded = false;
    }


    // methods
    private void checkWeight() {
        if (currentWeight > maxWeightLimit) {
            isOverloaded = true;
            System.out.println("Alert: Drum overloaded! Current weight: " + currentWeight + " kg.");
            triggerOverloadProtection();
        } else {
            isOverloaded = false;
            System.out.println("Current weight is within the limit. Weight: " + currentWeight + " kg.");
        }
    }

    private void triggerOverloadProtection() {
        System.out.println("Activating overload protection... Reducing drum speed or stopping the washing machine.");
    }


    // setter
    public void setCurrentWeight(double weight) {
        this.currentWeight = weight;
        checkWeight();
    }


    // getters
    public double getCurrentWeight() {
        return currentWeight;
    }

    public boolean isOverloaded() {
        return isOverloaded;
    }

    public double getMaxWeightLimit() {
        return maxWeightLimit;
    }
}
