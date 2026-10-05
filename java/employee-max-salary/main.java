import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            employees[i] = new Employee(id, name, salary);
        }

        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (employees[i].salary > employees[maxIdx].salary) {
                maxIdx = i;
            }
        }

        System.out.println("--- Employee with Maximum Salary ---");
        System.out.println("Name: " + employees[maxIdx].name);
        System.out.println("ID: " + employees[maxIdx].id);
        System.out.println("Salary: " + employees[maxIdx].salary);
        sc.close();
    }
}
