import java.util.Scanner;

abstract class Shape {
    abstract double area();
    abstract double volume();
}

class Cylinder extends Shape {
    double radius;
    double height;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    double area() {
        return 2 * Math.PI * radius * (radius + height);
    }

    double volume() {
        return Math.PI * radius * radius * height;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of cylinder: ");
        double r = sc.nextDouble();
        System.out.print("Enter height of cylinder: ");
        double h = sc.nextDouble();
        Cylinder cyl = new Cylinder(r, h);
        System.out.println("Surface Area of Cylinder: " + cyl.area());
        System.out.println("Volume of Cylinder: " + cyl.volume());
        sc.close();
    }
}
