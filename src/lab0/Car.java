package lab0;

public class Car {
    private float speed = 0;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void stop() {
        speed=0;
    }

    public void accelerate(float amount) {
        speed += amount;
    }

    public void printIsMoving() {
        if (speed!=0) {
            System.out.println("The car is moving");
        } else {
            System.out.println("The car is not moving");
        }
    }
}