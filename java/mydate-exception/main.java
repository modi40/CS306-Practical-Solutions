import java.util.Scanner;

class InvalidDateException extends Exception {
    InvalidDateException(String msg) {
        super(msg);
    }
}

class MyDate {
    int day;
    int month;
    int year;

    void accept(int d, int m, int y) throws InvalidDateException {
        if (y < 1) {
            throw new InvalidDateException("Invalid year");
        }
        if (m < 1 || m > 12) {
            throw new InvalidDateException("Invalid month");
        }
        int maxDays = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxDays = 30;
        } else if (m == 2) {
            boolean isLeap = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
            maxDays = isLeap ? 29 : 28;
        }
        if (d < 1 || d > maxDays) {
            throw new InvalidDateException("Invalid day for given month");
        }
        this.day = d;
        this.month = m;
        this.year = y;
    }

    void display() {
        System.out.println("MyDate: " + String.format("%02d/%02d/%04d", day, month, year));
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date as dd mm yyyy: ");
        int d = sc.nextInt();
        int m = sc.nextInt();
        int y = sc.nextInt();
        MyDate md = new MyDate();
        try {
            md.accept(d, m, y);
            md.display();
        } catch (InvalidDateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        sc.close();
    }
}
