package ui;


public class Display {
    private String status;
    private int remainingTime;
    private double waterLevel;
    private double waterTemperature;
    private String errorMessage;


    // constructor
    public Display() {
        this.status = "Ready";
        this.remainingTime = 0;
        this.waterLevel = 0.0;
        this.waterTemperature = 0.0;
        this.errorMessage = "";
    }


    // methods
    public void showGeneralInfo() {
        System.out.println("General information:");
        System.out.println("Washing machine status: " + status);
        System.out.println("Remaining time: " + remainingTime + " minutes");
        System.out.println("Water level: " + waterLevel + " l");
        System.out.println("Water temperature: " + waterTemperature + " °C");


        if (!errorMessage.isEmpty())
            System.out.println("Error: " + errorMessage);
        else
            System.out.println("No errors occured.");

    }

    public void clearDisplay() {
        System.out.println("Display is clearing itself...");
        this.status = "Ready";
        this.remainingTime = 0;
        this.waterLevel = 0.0;
        this.waterTemperature = 0.0;
        this.errorMessage = "";
    }


    // setters
    public void showStatus(String status) {
        this.status = status;
        System.out.println("Status: " + status);
    }

    public void showRemainingTime(int minutes) {
        this.remainingTime = minutes;
        System.out.println("Remaining time: " + remainingTime + " minutes");
    }

    public void showWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
        System.out.println("Water level: " + waterLevel + " ml");
    }

    public void showWaterTemperature(double temperature) {
        this.waterTemperature = temperature;
        System.out.println("Water temperature: " + temperature + " °C");
    }

    public void showErrorMessage(String error) {
        this.errorMessage = error;
        System.out.println("Error: " + error);
    }
}

