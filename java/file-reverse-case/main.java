import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filepath = sc.nextLine();
        File file = new File(filepath);
        if (!file.exists()) {
            try {
                FileWriter fw = new FileWriter(file);
                fw.write("Core Java Slip Solution 2026");
                fw.close();
                System.out.println("Created demo file at " + filepath);
            } catch (Exception e) {
                System.out.println("Could not create demo file: " + e.getMessage());
            }
        }
        try {
            FileReader fr = new FileReader(file);
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = fr.read()) != -1) {
                sb.append((char) ch);
            }
            fr.close();
            String content = sb.toString();
            StringBuilder result = new StringBuilder();
            for (int i = content.length() - 1; i >= 0; i--) {
                char c = content.charAt(i);
                if (Character.isUpperCase(c)) {
                    result.append(Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(c);
                }
            }
            System.out.println("Reversed and Case Inverted Content:");
            System.out.println(result.toString());
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        sc.close();
    }
}
