public class NotesData {
    Parsowanie daty
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    public class DateUtils {
        private static final String DATE_FORMAT = "M/d/yy"; // np. 4/6/20

        public static LocalDate toDate(String dateStr) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            return LocalDate.parse(dateStr, formatter);
        }

        public static String toStringDate(LocalDate date) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            return formatter.format(date);
        }
    }
    Operacje na datach
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate otherDate = LocalDate.parse("10-07-2010", formatter);
    LocalDate today = LocalDate.now(); // 2024-04-26 (pobranie dzisiejszej daty)

// porównywanie dat:
today.isAfter(otherDate); // true
today.isBefore(otherDate); // false

    // naiwne obliczenie różnicy lat
    int diff = today.getYear() - otherDate.getYear();
System.out.printf("Jest %d lat różnicy\n", diff); // "Jest 14 lat różnicy"

    // dokładniejsze obliczenie różnicy lat
    int diff2 =  Period.between(otherDate, today).getYears();
System.out.printf("Jest %d lat różnicy\n", diff2); // "Jest 13 lat różnicy"

}
