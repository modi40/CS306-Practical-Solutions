package stringoperation;

import java.util.Scanner;

class Con {
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }
}

class Comp {
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        Con conObj = new Con();
        String concatenated = conObj.concatenate(str1, str2);
        System.out.println("Concatenated String: " + concatenated);
        Comp compObj = new Comp();
        int comparison = compObj.compare(str1, str2);
        if (comparison == 0) {
            System.out.println("Both strings are equal.");
        } else if (comparison > 0) {
            System.out.println("First string is greater than second string.");
        } else {
            System.out.println("First string is smaller than second string.");
        }
        sc.close();
    }
}
