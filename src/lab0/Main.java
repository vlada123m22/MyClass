public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setSpeed(0);
        car.accelerate(20);
        car.printIsMoving();
        if (car.getSpeed()>0) {
            Float speed = car.getSpeed();
            System.out.println("The car is moving with the speed of " + speed.toString() + " km/h");
        }

    }
}
