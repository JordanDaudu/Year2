public class Car {

    private String make = "Ford";
    private String model = "Mustang";
    private int year = 2025;
    private double price = 58000.99;
    boolean isRunning = false;

    Car() {}

    Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    String getMake() {
        return this.make;
    }
    String getModel() {
        return this.model;
    }
    int getYear() {
        return this.year;
    }
    double getPrice() {
        return this.price;
    }
    void setMake(String make) {
        this.make = make;
    }
    void setModel(String model) {
        this.model = model;
    }
    void setYear(int year) {
        this.year = year;
    }
    void setPrice(double price) {
        this.price = price;
    }



    @Override
    public String toString() {

        // .tostring() = Method inherited from the Object class.
        //               Used to return a string representation of an object
        //               By default, it returns a hash code as a unique identifier
        //               It can be overridden to provide meaningful details.

        return this.make + " " + this.model + " " + this.year + " Price: " + this.price;
    }


    void start() {
        System.out.println("You started the engine");
        isRunning = true;
    }
    void stop() {
        System.out.println("You stopped the engine");
        isRunning = false;
    }
    void drive() {
        System.out.println("You drive the car model " + model);
    }
    void brake() {
        System.out.println("You brake the car model " + model);
    }
}
