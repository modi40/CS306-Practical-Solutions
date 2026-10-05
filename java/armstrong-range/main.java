import java.util.Scanner;

class Main {
    static boolean isArmstrong(int num) {
        int temp = num;
        int digits = 0;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        temp = num;
        int sum = 0;
        while (temp > 0) {
            int rem = temp % 10;
            int power = 1;
            for (int i = 0; i < digits; i++) {
                power *= rem;
            }
            sum += power;
            temp /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter start of range: ");
        int start = sc.nextInt();
        System.out.print("Enter end of range: ");
        int end = sc.nextInt();
        System.out.println("Armstrong numbers between " + start + " and " + end + ":");
        for (int i = start; i <= end; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        sc.close();
    }
}
