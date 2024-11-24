package executive_elements;


public class WaterPump {
    private boolean isRunning;
    private double waterLevel;
    private final double pumpCapacity;


    // constructor
    public WaterPump(double pumpCapacity){
        waterLevel = 0.0;
        isRunning = false;
        this.pumpCapacity = pumpCapacity;
    }


    // methods
    public void pumpWater(){
        if (waterLevel == 0.0) {
            System.out.println("No water to pump out. Current water level: " + waterLevel + " ml.");
            return;
        }

        if(isRunning){
            System.out.println("Starting to pump out water...");

            if(waterLevel < 0.0)
                waterLevel = 0.0;

            while(waterLevel != 0){
                System.out.println("Current water level: " + waterLevel);
                waterLevel -= 0.5;

                try{
                    Thread.sleep(500);
                } catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println("Pumping interrupted.");
                    break;

                }
            }
            System.out.println("The water has been pumped out of the washing machine. Current water level: " + waterLevel);
            stopPump();
        }

        else
            System.out.println("The pump has to be turned on in order to pump the water out.");

    }

    public void addWater(double amount){
        if (isRunning) {
            System.out.println("Cannot add water while the pump is running.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount of water to add: " + amount + " ml.");
            return;
        }

        if (waterLevel + amount > pumpCapacity) {
            System.out.println("Cannot add " + amount + " liters of water. Exceeds capacity of " + pumpCapacity + " ml.");
            return;
        }

        waterLevel += amount;
        System.out.println("Added " + amount + " liters of water. Current water level: " + waterLevel + " ml.");
    }

    public void startPump(){
        if(isRunning)
            System.out.println("The pump is already running. Water level: " + waterLevel + "ml");
        else{
            isRunning = true;
            System.out.println("The pump has been turned on. Water level " + waterLevel + "ml");
        }
    }

    public void stopPump(){
        if(isRunning){
            System.out.println("The pump is being turned off.");
            isRunning = false;
        }

        else
            System.out.println("The pump is not running");

    }


    // getters
    public double getWaterLevel() { return waterLevel; }
}