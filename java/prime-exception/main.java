import java.util.Scanner;

class ZeroNumberException extends Exception {
    ZeroNumberException(String message) {
        super(message);
    }
}

class Main {
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int n = sc.nextInt();
        try {
            if (n == 0) {
                throw new ZeroNumberException("Number is 0");
            }
            if (isPrime(n)) {
                System.out.println(n + " is a Prime Number.");
            } else {
                System.out.println(n + " is Not a Prime Number.");
            }
        } catch (ZeroNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        sc.close();
    }
}
