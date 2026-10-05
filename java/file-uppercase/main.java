import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

class Main {
    public static void main(String[] args) {
        File file = new File("abc.txt");
        if (!file.exists()) {
            try {
                FileWriter fw = new FileWriter(file);
                fw.write("Java practical examination slips solution abc file");
                fw.close();
            } catch (Exception e) {
                System.out.println("Could not create initial abc.txt: " + e.getMessage());
            }
        }

        try {
            FileReader fr = new FileReader("abc.txt");
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = fr.read()) != -1) {
                sb.append((char) ch);
            }
            fr.close();
            String upper = sb.toString().toUpperCase();
            System.out.println("Contents of abc.txt in uppercase:");
            System.out.println(upper);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
