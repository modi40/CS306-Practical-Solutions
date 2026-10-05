import java.util.Scanner;

class Person {
    String Personname;
    String Aadharno;
    String Panno;

    Person(String Personname, String Aadharno, String Panno) {
        this.Personname = Personname;
        this.Aadharno = Aadharno;
        this.Panno = Panno;
    }

    void display() {
        System.out.println("Name: " + this.Personname + " | Aadhaar: " + this.Aadharno + " | PAN: " + this.Panno);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person[] persons = new Person[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter information for person " + (i + 1) + ":");
            System.out.print("Person Name: ");
            String name = sc.nextLine();
            System.out.print("Aadhaar Number: ");
            String aadhar = sc.nextLine();
            System.out.print("PAN Number: ");
            String pan = sc.nextLine();
            persons[i] = new Person(name, aadhar, pan);
        }

        System.out.println("--- Displaying 5 Person Records ---");
        for (int i = 0; i < 5; i++) {
            persons[i].display();
        }
        sc.close();
    }
}
