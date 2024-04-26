public class Maps {
    Hashmap / haszmapa
    import java.util.HashMap;
import java.util.NoSuchElementException;

    public class DiseasesDescriptions {
        private final HashMap<String, String> descriptions;

        DiseasesDescriptions() {
            descriptions = new HashMap<>();
            descriptions.put("diarrhea", "condition characterized by frequent [...]");
            descriptions.put("ebola", "severe and often fatal illness caused by the Ebola virus");
            descriptions.put("coronavirus", "infectious respiratory illness caused by the severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2). ");
        }

        String getDescription(String diseaseName) {
            if (!this.descriptions.containsKey(diseaseName)) {
                throw new NoSuchElementException("Not found");
            }
            return this.descriptions.get(diseaseName);
}
import java.util.HashSet;

        public class Main {
            public static void main(String[] args) {
                HashSet<String> cars = new HashSet<String>();
                cars.add("Volvo");
                cars.add("BMW");
                cars.add("Ford");
                cars.add("BMW"); // dodajemy drugi raz "BMW", ale to nie wpływa na dane w hash secie
                cars.add("Mazda");

                System.out.println(cars); // [Volvo, Mazda, Ford, BMW]

                cars.contains("Mazda"); // true
                cars.remove("Volvo"); // [Mazda, Ford, BMW]

                cars.clear(); // czyści cały hash set

                // iteracja po elementach
                for (String car : cars) {
                    System.out.println(car);
                }
            }
        }
        Utworzenie listy na bazie hash setu
        HashSet może być przydatny gdy kolekcjonujemy dane które muszą być unikalne i nie zależy nam na kolejności. Możemy utworzyć tablicę na podstawie hash setu by potem już operować jak na zwykłej liście.

                Set<String> cars = new HashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW"); // dodajemy drugi raz "BMW", ale to nie wpływa na dane w hash secie
        cars.add("Mazda");
        List<String> carsList = new ArrayList<>(cars);

        for (String car : carsList) {
            System.out.printf("Car: %s\n", car);
            lista potzrebna aby móc iterować