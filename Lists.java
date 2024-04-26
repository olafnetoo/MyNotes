public class Lists {
    Sortowanie typów prostych w liście (np. integery)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class Sort {
        List<Integer> list;

        Sort() {
            list = new ArrayList<Integer>();
            list.add(6);
            list.add(2);
            list.add(100);
            list.add(4);
        }

        public void simpleSort() {
            // Collections.sort modyfikuje przekazaną listę
            Collections.sort(list); // [2, 4, 6, 100]
            System.out.println(list);

            // Collections.reverse NIE SORTUJE - po prostu odwraca nam listę
            Collections.reverse(list); // [100, 6, 4, 2]
            System.out.println(list);
        }
    }
    Sortowanie obiektów w liście
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

    public class Sort {
        List<DeathStat> list;

        Sort() {
            list = new ArrayList<DeathStat>();
            list.add(new DeathStat("Dęblin", 10));
            list.add(new DeathStat("Ryki", 5));
            list.add(new DeathStat("Lublin", 100));
            list.add(new DeathStat("Puławy", 20));
        }
        public void objectSort() {
            // Używamy komparatora - musimy przekazać lambdę/referencje do metody która zwraca inta (dla .comparingInt)
            // jeżeli chcemy posortować odwrotnie (najmniejszy -> największy)
            list.sort(Comparator.comparingInt(DeathStat::getCount));

            // jeżeli chcemy posortować odwrotnie (największy -> najmniejszy)
            list.sort(Comparator.comparingInt(DeathStat::getCount).reversed());
        }
    }
    public class DeathStat {
        private final int count;
        private final String city;

        DeathStat(String city, int count) {
            this.count = count;
            this.city = city;
        }

        int getCount() {
            return this.count;
        }
    }
    Lista (dynamiczna tablica)
        import java.util.ArrayList;
import java.util.List;

    public class TodoList {
        List<String> todo;

        TodoList() {
            todo = new ArrayList<>();

            // dodawanie elementów
            todo.add("Wyjście z psem");
            todo.add("Nauka na asyko");
            todo.add("Nauka na porawke z asyko");
            todo.add("Kąpiel z podłączonym tosterem");

            // usunięcie pierwszego elementu
            todo.remove(0); // [Nauka na asyko, Nauka na porawke z asyko, Kąpiel z podłączonym tosterem]

            // pobranie pierwszego elementu
            todo.get(0); // "Nauka na asyko"

            // sprawdzenie czy tablica zawiera element
            todo.contains("Nauka na asyko"); // true

            // usunięcie z filtrowaniem
            todo.removeIf((item) -> item.startsWith("Nauka")); // [Kąpiel z podłączonym tosterem]

            todo.clear(); // wyczyszczenie całej listy
        }
    }
    Iterowanie po liście obiektów (instancji klas)
    List<Country> countries = new ArrayList<>();

[...]

        for (Country country : countries) {
        System.out.println(country.name);
    }
}
