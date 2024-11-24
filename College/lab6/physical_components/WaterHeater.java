package physical_components;


public class WaterHeater {
    private double targetTemp;
    private double currentTemp;
    private boolean isActive;


    // constructor
    public WaterHeater(){
        isActive = false;
        currentTemp = 20.0;
        targetTemp = 0.0;

    }


    // methods
    public void heatWater(double targetTemp){
        if (targetTemp <= currentTemp) {
            System.out.println("Temperature is enough.");
            return;
        }

        this.targetTemp = targetTemp;
        isActive = true;
        System.out.println("The heater is turning on, heating up to " + targetTemp + "°C");

        while(currentTemp < targetTemp){
            currentTemp += 0.5;
            System.out.println("Current temperature: " + currentTemp + "°C");

            try{
                Thread.sleep(500);

            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("The temperature has been reached: " + currentTemp + "°C");
        isActive = false;
    }

    public void stopHeating() {
        if (isActive) {
            isActive = false;
            System.out.println("Heater turning off.");
        }

        else
            System.out.println("Heater is turned on.");
    }


    // getters
    public boolean isHeating(){ return isActive; }
    public double getCurrentTemp(){ return currentTemp; }


}
