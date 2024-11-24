package Sensors;

public class FloodProtectionSensor {
    private double currentWaterLevel;
    private final double maxAllowedWaterLevel;
    private boolean isFloodDetected;


    // constructor
    public FloodProtectionSensor(double maxAllowedWaterLevel) {
        this.maxAllowedWaterLevel = maxAllowedWaterLevel;
        this.currentWaterLevel = 0.0;
        this.isFloodDetected = false;
    }


    // methods
    private void checkFloodRisk() {
        if (currentWaterLevel > maxAllowedWaterLevel) {
            isFloodDetected = true;
            System.out.println("Alert: Flood detected! Current water level: " + currentWaterLevel + "ml.");
            triggerFloodProtection();
        }

        else {
            isFloodDetected = false;
            System.out.println("No flood detected. Current water level: " + currentWaterLevel + "ml.");
        }
    }

    private void triggerFloodProtection() {
        System.out.println("Activating flood protection... Initiating water drainage and shutting down the washing machine.");
    }


    // setter
    public void setCurrentWaterLevel(double level) {
        this.currentWaterLevel = level;
        checkFloodRisk();
    }


    // getters
    public double getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public boolean isFloodDetected() {
        return isFloodDetected;
    }

    public double getMaxAllowedWaterLevel() {
        return maxAllowedWaterLevel;
    }
}
