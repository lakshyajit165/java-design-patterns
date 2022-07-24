package factory;

abstract class Vehicle {
    public abstract int getWheel();

    public String toString() {
        return "No of wheels: " + this.getWheel();
    }
}

class Car extends Vehicle {
    int wheel;
    Car(int wheel){
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends Vehicle {
    int wheel;
    Bike(int wheel){
        this.wheel = wheel;
    }
    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel){
        switch (type){
            case "car":
                return new Car(wheel);
            case "bike":
                return new Bike(wheel);
            default:
                return null;
        }
    }
}
public class FactoryExample {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(car);
        System.out.println(bike);
    }
}
