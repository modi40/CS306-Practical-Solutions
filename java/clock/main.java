import java.util.Scanner;

class Clock {
    int hours;
    int minutes;
    int seconds;

    Clock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    Clock(int hours, int minutes, int seconds) {
        if (isValid(hours, minutes, seconds)) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        } else {
            System.out.println("Invalid numbers supplied. Setting 00:00:00");
            this.hours = 0;
            this.minutes = 0;
            this.seconds = 0;
        }
    }

    static boolean isValid(int h, int m, int s) {
        return (h >= 0 && h < 24) && (m >= 0 && m < 60) && (s >= 0 && s < 60);
    }

    void displayAMPM() {
        String period = (hours >= 12) ? "PM" : "AM";
        int h = hours % 12;
        if (h == 0) {
            h = 12;
        }
        System.out.println("Time in AM/PM Mode: " + String.format("%02d:%02d:%02d %s", h, minutes, seconds, period));
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Hours (0-23): ");
        int h = sc.nextInt();
        System.out.print("Enter Minutes (0-59): ");
        int m = sc.nextInt();
        System.out.print("Enter Seconds (0-59): ");
        int s = sc.nextInt();
        Clock clock = new Clock(h, m, s);
        clock.displayAMPM();
        sc.close();
    }
}
