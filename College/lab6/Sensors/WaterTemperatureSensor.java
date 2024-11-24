package Sensors;


public class WaterTemperatureSensor {
    private double temperature;
    private final double minTemperature;
    private final double maxTemperature;
    private boolean isAlert;


    // cnostructor
    public WaterTemperatureSensor(double minTemperature, double maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.temperature = 0.0;
        this.isAlert = false;
    }


    // method
    private void checkTemperature() {
        if (temperature < minTemperature) {
            isAlert = true;
            System.out.println("Alert: Temperature is too low! Current temperature: " + temperature + "°C.");
        }

        else if (temperature > maxTemperature) {
            isAlert = true;
            System.out.println("Alert: Temperature is too high! Current temperature: " + temperature + "°C.");
        }

        else {
            isAlert = false;
            System.out.println("Water temperature is in the norm. Current temperature: " + temperature + "°C.");
        }
    }


    // setter
    public void setTemperature(double temperature) {
        this.temperature = temperature;
        checkTemperature(); // Sprawdzenie, czy temperatura mieści się w dozwolonym zakresie
    }


    // getters
    public double getTemperature() {
        return temperature;
    }

    public boolean isAlert() {
        return isAlert;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }
}

