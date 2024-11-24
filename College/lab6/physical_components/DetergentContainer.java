package physical_components;


public class DetergentContainer {
    private double powderLevel;
    private double liquidLevel;
    private final double maxPowderCapacity;
    private final double maxLiquidCapacity;


    // constructor
    public DetergentContainer(double maxPowderCapacity, double maxLiquidCapacity){
        this.maxPowderCapacity = maxPowderCapacity;
        this.maxLiquidCapacity = maxLiquidCapacity;
        powderLevel = 0.0;
        liquidLevel = 0.0;

    }


    // methods
    public boolean addPowder(double amount){
        if(powderLevel + amount > maxPowderCapacity){
            System.out.println("Too much powder! Max powder capacity: " + maxPowderCapacity);
            return false;
        }

        if(amount <= 0){
            if(amount == 0)
                System.out.println("No powder has been added. Current powder level " + powderLevel + 'g');
            else
                System.out.println("You can't add a negative amount of powder!");
            return false;
        }

        powderLevel += amount;
        System.out.println("Added " + amount + "g of powder. Current powder level: " + powderLevel + "g");

        return true;
    }

    public boolean addLiquid(double amount){
        if(liquidLevel + amount > maxLiquidCapacity){
            System.out.println("Too much liquid! Max liquid capacity: " + maxLiquidCapacity);
            return false;
        }

        if(amount <= 0){
            if(amount == 0)
                System.out.println("No powder has been added. Current powder level " + liquidLevel + "ml");
            else
                System.out.println("You can't add a negative amount of powder!");
            return false;
        }

        liquidLevel += amount;
        System.out.println("Added " + amount + "ml of liquid. Current liquid level: " + liquidLevel + "ml");

        return true;
    }

    public boolean dispensePowder(double amount){
        if(powderLevel < amount){
            System.out.println("Not enough powder to dispense. Remaining: " + powderLevel + "g of powder.");
            return false;
        }

        powderLevel -= amount;
        System.out.println("Dispensed " + amount + "g of powder. Remaining: " + powderLevel + "g of powder.");
        return true;
    }

    public boolean dispenseLiquid(double amount){
        if(liquidLevel < amount){
            System.out.println("Not enough liquid to dispense. Remaining: " + liquidLevel + "g of powder.");
            return false;
        }

        liquidLevel -= amount;
        System.out.println("Dispensed " + amount + "g of liquid. Remaining: " + liquidLevel + "g of liquid.");
        return true;
    }

    public void checkLevels(){
        System.out.println("Powder level: " + powderLevel);
        System.out.println("Liquid level: " + liquidLevel);
    }


    // getters
    public double getPowderLevel(){ return powderLevel; }
    public double getLiquidLevel(){ return liquidLevel; }
}
