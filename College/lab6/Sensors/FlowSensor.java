package Sensors;


public class FlowSensor {
    private double currentFlowRate;
    private final double minFlowRate;
    private boolean isClogged;


    // constructor
    public FlowSensor(double minFlowRate) {
        this.minFlowRate = minFlowRate;
        this.currentFlowRate = 0.0;
        this.isClogged = false;
    }


    // methods
    private void checkFlowRate() {
        if (currentFlowRate < minFlowRate) {
            isClogged = true;
            System.out.println("Alert: Water filter is clogged! Current flow rate: " + currentFlowRate + " L/min.");
            triggerCloggedFilterProtection();  // Aktywacja ochrony przed zablokowanym filtrem
        } else {
            isClogged = false;
            System.out.println("Water filter is functioning properly. Current flow rate: " + currentFlowRate + " L/min.");
        }
    }

    private void triggerCloggedFilterProtection() {
        System.out.println("Activating filter clog protection... Please clean the water filter.");
    }


    // setter
    public void setCurrentFlowRate(double flowRate) {
        this.currentFlowRate = flowRate;
        checkFlowRate();
    }


    // Getter dla bieżącego przepływu wody
    public double getCurrentFlowRate() {
        return currentFlowRate;
    }

    // Getter sprawdzający, czy filtr jest zablokowany
    public boolean isClogged() {
        return isClogged;
    }

    // Getter dla minimalnego dopuszczalnego przepływu wody
    public double getMinFlowRate() {
        return minFlowRate;
    }
}
