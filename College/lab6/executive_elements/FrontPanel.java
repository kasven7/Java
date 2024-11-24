package executive_elements;
import ui.Display;


public class FrontPanel {
    private Display display;
    private boolean isOn;


    // constructor
    FrontPanel(){
        isOn = false;
    }


    // methods
    public void turnOn(){
        if(isOn)
            System.out.println("The front panel is already turned on.");

        else{
            isOn = true;
            System.out.println("Front panel is turning on...");
            display.showGeneralInfo();
        }
    }

    public void turnOff(){
        if(!isOn)
            System.out.println("The front panel is already turned off.");

        else{
            isOn = false;
            System.out.println("Front panel is turning off...");
            display.clearDisplay();
        }
    }

}
