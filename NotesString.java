public class Notes {
    Operacje na stringach
    // 1. trim
    String text = "   Hello World   ";
text.trim(); // "   Hello World  " -> "Hello World"

    // 2. toLowerCase
    String text = "HELLO WORLD";
text.toLowerCase(); // "hello world"

    // 3. toUpperCase
    String text = "hello world";
text.toUpperCase() // "HELLO WORLD"
    Uwaga - powyższe metody zwracają NOWEGO stringa bez modyfikacji oryginalnego.

    Długość stringa
"123".length() // 3
    Porównanie stringów
    Lepiej używać .equals() niż == do porównywania stringów

    String name = "John";

if (name.equals("John")) {
        System.out.println("Lepiej używać .equals niż == do porównywania stringów");
    }

    // inne przydatne metody zwracające wartość logiczną:
    String text = "Hello World";

text.startsWith("Hello"); // true
text.endsWith("World"); // true
text.contains("llo"); // true
    Formatowanie stringów
    String name = "John Doe";
String.format("My name is: %s", name) // My name is: John Doe

    // formatowanie ułamków - %.1f oznacza jedno miejsce po przecinku, %.2f oznaczałoby 2 miejsca itd...
// Locale.ENGLISH jest używane by ułamek był oddzielany przez kropkę zamiast przecinek (domyślnie)
    double x = 21.37;
String.format(Locale.ENGLISH, "x=%.1f", x); // x=21.4

    int x = 21;
String.format(Locale.ENGLISH, "x=%d", x); // x=21

// Łączenie stringów
"Hello, my name is: " + name // Hello, my name is John Doe
            Substring
    String text = "Test: 233";
text.substring(6) // "233"
        text.substring(0, 4) // "Test"
    Zamiana Stringa na liczbę
Integer.parseInt("500") // 500 ale jako int
        Double.parseDouble("500.244") // 500.244 jako double

}
