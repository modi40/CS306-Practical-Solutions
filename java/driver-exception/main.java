class AgeBelow18Exception extends Exception {
    AgeBelow18Exception(String message) {
        super(message);
    }
}

class Driver {
    int license_no;
    String name;
    String address;
    int age;

    Driver(int license_no, String name, String address, int age) throws AgeBelow18Exception {
        if (age < 18) {
            throw new AgeBelow18Exception("Age is below 18 years");
        }
        this.license_no = license_no;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    void display() {
        System.out.println("Driver Details:");
        System.out.println("License No: " + license_no);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Driver validDriver = new Driver(501, "Rajesh Kumar", "Pune, India", 25);
            validDriver.display();
        } catch (AgeBelow18Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        try {
            Driver invalidDriver = new Driver(502, "Nikhil Rao", "Mumbai, India", 16);
            invalidDriver.display();
        } catch (AgeBelow18Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
