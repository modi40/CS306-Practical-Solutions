import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        File f = new File(fileName);
        if (!f.exists()) {
            try {
                FileWriter fw = new FileWriter(f);
                fw.write("Core Java Programming
Web Technology slips
Word character and line count demo");
                fw.close();
                System.out.println("Created sample file: " + fileName);
            } catch (Exception e) {
                System.out.println("Could not create sample file: " + e.getMessage());
            }
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            int lines = 0;
            int words = 0;
            int chars = 0;
            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length();
                String trimmed = line.trim();
                if (trimmed.length() > 0) {
                    words += trimmed.split("\s+").length;
                }
            }
            br.close();
            System.out.println("File: " + fileName);
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        sc.close();
    }
}
