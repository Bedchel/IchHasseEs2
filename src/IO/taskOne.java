package IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class taskOne {
    static void main() {
        String path1 = "src/main/java/org/example/IO/taskOne.txt";
        String path2 = "src/main/java/org/example/IO/taskOneB.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path1, StandardCharsets.UTF_8));
             BufferedWriter bw = new BufferedWriter(new FileWriter(path2, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("ERROR")) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
