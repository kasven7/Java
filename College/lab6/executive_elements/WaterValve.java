package executive_elements;


public class WaterValve {
    private boolean isOpen;
    private double waterFlowRate;
    private double totalWaterFlow;  // total amount of water that has been passed through the valve


    public WaterValve(double waterFlowRate){
        if (waterFlowRate <= 0) {
            throw new IllegalArgumentException("Water flow rate must be greater than 0.");
        }

        this.waterFlowRate = waterFlowRate;
        totalWaterFlow = 0.0;
        isOpen = false;
    }


    // methods
    public void openValve(){
        if(!isOpen){
            isOpen = true;
            System.out.println("The valve has been opened.");
        }

        else
            System.out.println("The valve is already open. No need to open it again.");
    }

    public void closeValve(){
        if(isOpen){
            isOpen = false;
            System.out.println("The valve has been closed.");
        }

        else
            System.out.println("The valve is already open. No need to open it again.");
    }

    public void resetWaterFlow(){
        totalWaterFlow = 0.0;
        System.out.println("Total water flow measurement has been reset");
    }

    public void simulateWaterFlow(double seconds){
        if (seconds <= 0) {
            System.out.println("Simulation time must be greater than 0 seconds.");
            return;
        }

        if(!isOpen){
            System.out.println("Valve is closed. No water can flow through it.");
            return;
        }

        double waterPassed = seconds * waterFlowRate;
        totalWaterFlow += waterPassed;

        System.out.println("Amount of water passed through the valve: " + waterPassed + " in time: " + seconds + 's');
    }


    // getters
    public boolean isOpen() { return isOpen; }
    public double getWaterFlowRate() { return waterFlowRate; }
    public double getTotalWaterFlow() {return totalWaterFlow; }


    // setter
    public void setWaterFlowRate(double waterFlowRate){
        if(waterFlowRate <= 0){
            System.out.println("Invalid water flow rate. Has to be grater than 0.");
            return;
        }

        this.waterFlowRate = waterFlowRate;
        System.out.println("Water flow rate has been successfully set. Water flow rate: " + waterFlowRate + "ml");
    }
}
