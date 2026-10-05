import java.util.Scanner;

class Vehicle {
    String Company;
    double price;

    Vehicle(String Company, double price) {
        this.Company = Company;
        this.price = price;
    }
}

class LightMotorVehicle extends Vehicle {
    double mileage;

    LightMotorVehicle(String Company, double price, double mileage) {
        super(Company, price);
        this.mileage = mileage;
    }

    void display() {
        System.out.println("Light Motor Vehicle -> Company: " + Company + ", Price: " + price + ", Mileage: " + mileage + " km/l");
    }
}

class HeavyMotorVehicle extends Vehicle {
    double capacity_in_tons;

    HeavyMotorVehicle(String Company, double price, double capacity_in_tons) {
        super(Company, price);
        this.capacity_in_tons = capacity_in_tons;
    }

    void display() {
        System.out.println("Heavy Motor Vehicle -> Company: " + Company + ", Price: " + price + ", Capacity: " + capacity_in_tons + " tons");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        Vehicle[] list = new Vehicle[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Select Vehicle Type (1: Light Motor Vehicle, 2: Heavy Motor Vehicle): ");
            int type = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Company name: ");
            String comp = sc.nextLine();
            System.out.print("Enter Price: ");
            double pr = sc.nextDouble();
            if (type == 1) {
                System.out.print("Enter Mileage: ");
                double mil = sc.nextDouble();
                list[i] = new LightMotorVehicle(comp, pr, mil);
            } else {
                System.out.print("Enter Capacity in tons: ");
                double cap = sc.nextDouble();
                list[i] = new HeavyMotorVehicle(comp, pr, cap);
            }
        }

        System.out.println("--- Displaying All Vehicle Records ---");
        for (int i = 0; i < n; i++) {
            if (list[i] instanceof LightMotorVehicle) {
                ((LightMotorVehicle) list[i]).display();
            } else if (list[i] instanceof HeavyMotorVehicle) {
                ((HeavyMotorVehicle) list[i]).display();
            }
        }
        sc.close();
    }
}
