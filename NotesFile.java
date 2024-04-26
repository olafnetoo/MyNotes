public class NotesFile {
    Czytanie pliku po liniach
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

    public class ReadFile {
        public static void readLines(String filename) throws IOException {
            Path path = Paths.get(filename);

            if (Files.notExists(path)) { // albo: !Files.exists(path)
                // sprawdzenie czy plik nie istnieje (czasem wymagane w zadaniach)
                System.out.println("Plik nie istnieje");
            }

            Stream<String> lines =  Files.lines(path);

            // Kilka sposobów na iteracje po liniach

            // 1. Lambda
            lines.forEach((line) -> {
                System.out.println(line);
            });

            // 2. Referencja do metody
            lines.forEach(System.out::println);

            // 3. Iterator
            Iterator<String> it = lines.iterator();

            while(it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }
    Czytanie kolumn lini / rozdzielanie stringa
import java.util.StringTokenizer;

    public class ReadColumns {
        private static final String DELIMITER = ";"; // przyjrzyjcie sie dokładnie jaki jest separator w pliku .csv (zazwyczaj "," ";" "|")

        public static void splitLine(String line) {
            StringTokenizer tokenizer = new StringTokenizer(line, DELIMITER);

            // tokenizer działa podobnie jak iterator
            while (tokenizer.hasMoreTokens()) {
                System.out.println(tokenizer.nextToken());
            }
        }
    }
    Zapisywanie do pliku / pisanie do pliku
    import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

    public class SaveFile {
        public static void save(String filename) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            writer.write("<body>\n");
            writer.write("<h1>Hello World</h1>\n");
            writer.write("</body>");

            writer.close(); // WAŻNE: jak zapomnimy zamknąć bufora to nie zobaczymy nic w pliku
        }
    }
}
