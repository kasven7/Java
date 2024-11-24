package executive_elements;

public class WaterPump {
    private boolean isRunning;
    private boolean isBlocked;  // filter blockage
    private int waterLevel;


    // constructor
    public WaterPump(int pumpCapacity){
        waterLevel = 0;
        isRunning = false;
        isBlocked = false;
    }


    // methods
    public void pumpWater(){
        if(isBlocked){
            System.out.println("The pump is Blocked the water cannot be pumped. ");
            return;
        }

        isRunning = true;
        while(waterLevel != 0){
            System.out.println("Current water level: " + waterLevel);
            waterLevel -= 0.5;

            try{
                Thread.sleep(500);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("The water has been pumped out of the washing machine. Current water level: " + waterLevel);
        isRunning = false;
    }


    // getters
    public int getWaterLevel() { return waterLevel; }
}
