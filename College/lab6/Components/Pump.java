package Components;

public class Pump {
    public boolean isRunning;
    private final int pumpCapacity;
    private int waterLevel;


    // constructor
    public Pump(int pumpCapacity){
        this.pumpCapacity = pumpCapacity;
        waterLevel = 0;
        isRunning = false;
    }


    // methods
    public void addWater(int amount){
        waterLevel += amount;
    }


    // getters
    public int getWaterLevel() { return waterLevel; }
}
