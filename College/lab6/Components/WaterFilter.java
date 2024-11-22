package Components;

public class WaterFilter {
    private int debrisLevel;
    private final int maxDebrisLevel;
    private boolean isBlocked;


    // constructor
    public WaterFilter(int maxDebrisLevel){
        this.maxDebrisLevel = maxDebrisLevel;
        debrisLevel = 0;
        isBlocked = false;
    }


    // methods
    public void accumulateDebris(int amount) {
        if(isBlocked){ System.out.println("The filter is already blocked! Clean it before another use."); return;}

        debrisLevel += amount;

        if(debrisLevel >= maxDebrisLevel){
            isBlocked = true;
            System.out.println("The filter has been blocked. Current debris level: " + debrisLevel);
        }

        else{
            System.out.println("The filter has gathered more debris. Current debris level: " + debrisLevel);
        }
    }

    public void cleanFilter() {
        if(isBlocked || debrisLevel > 0){
            debrisLevel = 0;
            isBlocked = false;
            System.out.println("The filter has been cleaned. Current debris level: " + debrisLevel);
        }

        else{
            System.out.println("The filter is already clean.");
        }
    }

    public boolean checkFilter(){
        if(isBlocked){
            System.out.println("The filter is blocked.");
            return true;
        }

        else{
            System.out.println("The filter is permeable.");
            return false;
        }
    }


    // getters
    public int getDebrisLevel(){ return debrisLevel; }
}
