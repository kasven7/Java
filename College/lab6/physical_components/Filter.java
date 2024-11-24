package physical_components;


public class Filter {
    private int debrisLevel;
    private final int maxDebrisLevel;
    private boolean isBlocked;


    // constructor
    public Filter(int maxDebrisLevel){
        this.maxDebrisLevel = maxDebrisLevel;
        debrisLevel = 0;
        isBlocked = false;

    }


    // methods
    public void accumulateDebris(int amount) {
        if(isBlocked){
            System.out.println("The filter is already blocked! Clean it before another use.");
            return;
        }

        if(amount <= 0){
            if(amount == 0)
                System.out.println("The filter hasn't gathered any debris. Current debris level: " + debrisLevel);
            else
                System.out.println("The filter could not have gathered a negative amount of debris");
            return;
        }

        if(debrisLevel >= maxDebrisLevel){
            isBlocked = true;
            System.out.println("The filter has been blocked. Current debris level: " + debrisLevel);
        }

        else {
            debrisLevel += amount;
            System.out.println("The filter has gathered more debris. Current debris level: " + debrisLevel);
        }
    }

    public void cleanFilter() {
        if(isBlocked || debrisLevel > 0){
            debrisLevel = 0;
            isBlocked = false;
            System.out.println("The filter has been cleaned. Current debris level: " + debrisLevel);
        }

        else
            System.out.println("The filter is already cleaned.");

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
