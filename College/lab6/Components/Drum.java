package Components;

public class Drum {
    private double capacity;
    private double currentLoad;
    private boolean isSpinning;


    // constructor
    public Drum(double capacity){
        this.capacity = capacity;
        currentLoad = 0.0;
        isSpinning = false;

    }


    //methods
    public boolean addLoad(double load){
        if(currentLoad + load > capacity){
            System.out.println("The drum is full of clothes!");
        }

        currentLoad += load;
        System.out.println("Added " + load + "kg of clothes. Current load: " + currentLoad);

        return true;
    }

    public void clearLoad(){
        System.out.println("Removing clothes from the drum");
        currentLoad = 0.0;
    }

    public void startSpinning(int speed){
        if (currentLoad == 0) {
            System.out.println("The drum is empty. Spinning cannot be initiated.");
            return;
        }

        isSpinning = true;
        System.out.println("Bęben wiruje z prędkością " + speed + " obrotów na minutę.");
    }

    public void stop(){
        if(isSpinning){
            System.out.println("Stopping the drum...");
            isSpinning = false;
        }

        else{
            System.out.println("The drum has already been stopped.");
        }
    }


    // getters
    public double getCurrentLoad(){ return currentLoad; }
    public boolean isSpinning() { return isSpinning; }
}
