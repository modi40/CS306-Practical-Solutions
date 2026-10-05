import java.util.Scanner;

interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
}

class SimpleCalc implements Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double n1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double n2 = sc.nextDouble();
        SimpleCalc calc = new SimpleCalc();
        System.out.println("Addition: " + calc.add(n1, n2));
        System.out.println("Subtraction: " + calc.subtract(n1, n2));
        sc.close();
    }
}
