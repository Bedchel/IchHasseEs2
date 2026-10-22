import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Theory {
    public static void main(String[] args) throws IOException {
        // Input output
        // робота з файлами

        // 1. Прочитати файл
        // 2. Зміна даних (якщо потрібно)
        // 3. Записати (вивести, зберегти) інформаційно

        String path = "src/main/java/com/example/IO/input.txt";

        // 1. без try-with-resources
        // 2. З try-with-resources (Autoclosable)

        // BufferedReader, FileReader open() ....... close()
        try (BufferedReader br = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String path1 = "src/main/java/com/example/IO/text1.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path1, StandardCharsets.UTF_8))) {

            bw.write("hello");
            bw.newLine();
            bw.write("world");

        } catch (IOException e) {
            e.printStackTrace();
        }


        Path path2 = Paths.get("src/main/java/com/example/IO/text1.txt");
        // NIO
        Files.write(path2, List.of("hello123", "world12"), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println(Files.readString(Paths.get("src/main/java/com/example/IO/text1.txt"), StandardCharsets.UTF_8));
    }
}
