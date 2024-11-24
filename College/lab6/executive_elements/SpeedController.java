package executive_elements;

public class SpeedController {
    private double currentSpeed;
    private final double maxSpeed;
    private boolean isActive;


    // constructor
    public SpeedController(double maxSpeed) {
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0.0;
        this.isActive = false;
    }


    // methods
    public void activate() {
        if (!isActive) {
            isActive = true;
            System.out.println("Speed controller activated.");
        }

        else
            System.out.println("Speed controller is already active.");

    }

    public void deactivate() {
        if (isActive) {
            isActive = false;
            currentSpeed = 0.0;
            System.out.println("Speed controller deactivated. Speed set to 0 RPM.");
        } else {
            System.out.println("Speed controller is already inactive.");
        }
    }

    public void increaseSpeedGradually(double targetSpeed, double step, long delay) {
        if (!isActive) {
            System.out.println("Speed controller is inactive. Activate it before adjusting speed.");
            return;
        }

        if (targetSpeed > maxSpeed) {
            System.out.println("Target speed exceeds the maximum limit of " + maxSpeed + " RPM.");
            return;
        }

        while (currentSpeed < targetSpeed) {
            currentSpeed = Math.min(currentSpeed + step, targetSpeed);
            System.out.println("Current speed: " + currentSpeed + " RPM.");

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Speed adjustment interrupted.");
            }
        }
        System.out.println("Target speed of " + targetSpeed + " RPM reached.");
    }

    public void decreaseSpeedGradually(double targetSpeed, double step, long delay) {
        if (!isActive) {
            System.out.println("Speed controller is inactive. Activate it before adjusting speed.");
            return;
        }

        if (targetSpeed < 0) {
            System.out.println("Target speed cannot be negative.");
            return;
        }

        while (currentSpeed > targetSpeed) {
            currentSpeed = Math.max(currentSpeed - step, targetSpeed);
            System.out.println("Current speed: " + currentSpeed + " RPM.");

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Speed adjustment interrupted.");
            }
        }
        System.out.println("Target speed of " + targetSpeed + " RPM reached.");
    }


    // setter
    public void setSpeed(double speed) {
        if (!isActive) {
            System.out.println("Speed controller is inactive. Activate it before setting speed.");
            return;
        }

        if (speed < 0)
            System.out.println("Invalid speed. Speed cannot be negative.");
        else if (speed > maxSpeed)
            System.out.println("Invalid speed. Maximum allowed speed is " + maxSpeed + " RPM.");

        else {
            currentSpeed = speed;
            System.out.println("Speed set to: " + currentSpeed + " RPM.");
        }
    }


    // getters
    public double getCurrentSpeed() {
        return currentSpeed;
    }


    public boolean isActive() {
        return isActive;
    }
}
