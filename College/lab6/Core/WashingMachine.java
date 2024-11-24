package core;
import executive_elements.*;
import physical_components.*;
import sensors.*;
import ui.Display;

import java.util.Scanner;



public class WashingMachine {

    // physical components
    private final Filter filter;
    private final Drum drum;
    private final DetergentContainer detergentContainer;
    private final WaterHeater heater;

    // executive components
    private final FrontPanel frontPanel;
    private final InverterMotor inverterMotor;
    private final SpeedController speedController;
    private final WaterPump waterPump;
    private final WaterValve waterValve;

    // sensors
    private final DrumWeightSensor drumWeightSensor;
    private final FloodProtectionSensor floodProtectionSensor;
    private final FlowSensor flowSensor;
    private final WaterLevelSensor waterLevelSensor;
    private final WaterPressureSensor waterPressureSensor;
    private final WaterTemperatureSensor waterTemperatureSensor;

    // scanner for user input
    private final Scanner touchInterface;


    //constructor
    public WashingMachine(){

        // initialization of physical elements
        filter = new Filter(100);
        drum = new Drum(10);
        detergentContainer = new DetergentContainer(2000);
        heater = new WaterHeater(90);

        // initialization of executive elements
        Display display = new Display();
        frontPanel = new FrontPanel(display);
        inverterMotor = new InverterMotor();
        speedController = new SpeedController(inverterMotor);
        waterPump = new WaterPump();
        waterValve = new WaterValve(0.7);

        // initialize sensors
        drumWeightSensor = new DrumWeightSensor(17.7);
        floodProtectionSensor = new FloodProtectionSensor(10);
        flowSensor = new FlowSensor(10);
        waterLevelSensor = new WaterLevelSensor(10);
        waterPressureSensor = new WaterPressureSensor(1.0, 5.0);
        waterTemperatureSensor = new WaterTemperatureSensor(0, 90);

        // touch interface
        touchInterface = new Scanner(System.in);
    }


    // methods
    public void pumpWater() {
        System.out.println("Pumping water out...");
        waterPump.startPump();
        waterPump.pumpWater();
        filter.accumulateDebris(1);
    }

    public void heatWater(double targetTemperature) {
        System.out.println("Heating water to " + targetTemperature + "°C...");
        heater.heatWater(targetTemperature);
        waterTemperatureSensor.setTemperature(targetTemperature);
    }

    public void balanceDrum() {
        System.out.println("Balancing drum...");
        if (!drum.isBalanced())
            drum.balance();

        else
            System.out.println("Drum is already balanced.");
    }

    public void checkFilter() {
        System.out.println("Checking filter for clogs...");
        if (flowSensor.isClogged()) {
            System.out.println("Filter is clogged! Cleaning required.");
            flowSensor.cleanFilter();
        } else {
            System.out.println("Filter is clear.");
        }
    }

    public void start() {
        System.out.println("Welcome to the washing machine!");
        frontPanel.turnOn();

        boolean running = true;

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Select a program");
            System.out.println("2. Set a custom program");
            System.out.println("3. Check system status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = touchInterface.nextInt();
            touchInterface.nextLine();

            switch (choice) {
                case 1:
                    selectProgram();
                    break;

                case 2:
                    setCustomProgram();
                    break;

                case 3:
                    checkSystemStatus();
                    break;

                case 4:
                    running = false;
                    System.out.println("Shutting down the washing machine...");
                    frontPanel.turnOff();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void selectProgram() {
        System.out.println("\nSelect a program:");
        System.out.println("1. Cotton");
        System.out.println("2. Synthetics");
        System.out.println("3. Wool");
        System.out.println("4. Delicates");
        System.out.println("5. Quick Wash");
        System.out.print("Enter your choice: ");

        int program = touchInterface.nextInt();
        touchInterface.nextLine();

        switch (program) {
            case 1:
                runProgram("Cotton", 60, 15, 45, true, 1200);
                break;
            case 2:
                runProgram("Synthetics", 40, 10, 30, false, 800);
                break;
            case 3:
                runProgram("Wool", 30, 5, 20, false, 600);
                break;
            case 4:
                runProgram("Delicates", 30, 5, 15, false, 400);
                break;
            case 5:
                runProgram("Quick Wash", 30, 5, 15, false, 1000);
                break;
            default:
                System.out.println("Invalid program choice.");
        }
    }

    private void runProgram(String programName, double temperature, int preWashTime, int mainWashTime, boolean extraRinse, int spinSpeed) {
        System.out.println("\nStarting program: " + programName);
        waterValve.openValve();
        waterLevelSensor.setLevel(5);
        detergentContainer.addPowder(100);

        heatWater(temperature);
        System.out.println("Pre-wash for " + preWashTime + " minutes...");
        System.out.println("Main wash for " + mainWashTime + " minutes...");

        if (extraRinse) {
            System.out.println("Performing extra rinse...");
        }

        System.out.println("Spinning at " + spinSpeed + " RPM...");
        speedController.setSpeed(spinSpeed);
        inverterMotor.start();

        pumpWater();
        inverterMotor.stop();
        System.out.println("Program complete.");
    }

    private void setCustomProgram() {
        System.out.println("\nSet your custom program:");

        System.out.print("Enter water temperature (°C): ");
        double temperature = touchInterface.nextDouble();

        System.out.print("Enter pre-wash time (minutes): ");
        int preWashTime = touchInterface.nextInt();

        System.out.print("Enter main wash time (minutes): ");
        int mainWashTime = touchInterface.nextInt();

        System.out.print("Enable extra rinse (true/false): ");
        boolean extraRinse = touchInterface.nextBoolean();

        System.out.print("Enter spin speed (RPM): ");
        int spinSpeed = touchInterface.nextInt();

        runProgram("Custom", temperature, preWashTime, mainWashTime, extraRinse, spinSpeed);
    }

    private void checkSystemStatus() {
        System.out.println("\nSystem Status:");
        System.out.println("Water pressure: " + waterPressureSensor.getPressure() + " bar");
        System.out.println("Water temperature: " + waterTemperatureSensor.getTemperature() + " °C");
        System.out.println("Drum weight: " + drumWeightSensor.getWeight() + " kg");
        System.out.println("Flood protection active: " + floodProtectionSensor.isFloodDetected());
    }
}
