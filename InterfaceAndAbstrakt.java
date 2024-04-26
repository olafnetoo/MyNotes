public class InterfaceAndAbstrakt {
    Klasa abstrakcyjna
    Jest to klasa, z której nie można utworzyć obiektu (w tradycyjny sposób), można po niej jedynie dziedziczyć. Klasa taka może mieć metody, które posiadają implementację, ale także metody abstrakcyjne czyli takie, które są jedynie deklaracją metody, która powinna zostać zaimplementowana w klasie potomnej.

    Klasa ta może być podstawą dla innych klas.  Potomne klasy dziedziczą wszystkie zachowania klasy abstrakcyjnej (zachowania w kodzie reprezentowane są przez metody, abstrakcyjne i nie abstrakcyjne).

    W Javie jest ograniczenie dziedziczenia do jednej klasy, więc każda klasa potomna może dziedziczyć tylko raz. Jeżeli chcemy obejść to ograniczenie, musimy ułożyć klasy w postaci hierarchii, co zwykle nie jest za bardzo wygodne. I praca z taką hierarchią jest coraz trudniejsza wraz ze wzrostem ilości klas, które umieścimy w takiej hierarchii.

    public abstract class AbstractCompany {

        public boolean canHire() {
            return true;
        }
        public abstract String getMonthlyReport();
    }
    Podklasa, która dziedziczy po klasie abstrakcyjnej, może w dowolny sposób implementować metody abstrakcyjne:

    public class SubCompany extends AbstractCompany {
        @Override
        public String getMonthlyReport() {
            return "empty";
        }
    }
    Każda podklasa może nadpisywać zachowania, czyli nadpisywać publiczne i chronione (public i protected)  metody odziedziczone z klasy bazowej:

    public class SubCompany extends AbstractCompany{

        @Override
        public String getMonthlyReport() {
            return "empty";
        }
        @Override
        public boolean canHire() {
            return false;
        }
    }
    Klasa abstrakcyjna, podobnie jak normalna klasa, może przechowywać stan (może mieć pola), który może być dowolnie modyfikowany.



    Interfejs
    Interfejsy to typy, które są bardzo podobne do klas, ale mogą zawierać jedynie stałe i deklaracje metod. Od Javy 8 mogą zawierać także metody default i metody statyczne (które mogą zawierać implementację). A od Javy 9 też metody prywatne. Interfejsy nie mogą mieć stanu.

    Służą one do definiowania zachowania dla obiektów. Ale inaczej niż w przypadku klasy abstrakcyjnej nie definiują tego zachowania (metody nie mają implementacji). Każda klasa implementująca interfejs musi mieć implementację metod zawartych w interfejsie.

            Metody default i statyczne zostały wprowadzone w Javie 8 w celu poprawienia kompatybilności wstecznej. Wprowadzenie ich pozwala zmieniać interfejsy, które zostały już zaimplementowane przez różne klasy, ale nie wymusza automatycznie zmian implementacji tych klas. Dzięki temu, twórcy Javy mogli zmieniać interfejsy takie jak List, czy Map bez zmiany wszystkich implementacji list i map w bibliotece standardowej.



    Jeśli w swoim interfejsach implementujesz metody default i statyczne, to zastanów się, czy faktycznie używasz ich zgodnie z przeznaczeniem!



    Dodatkowo jeżeli interfejs posiada tylko jedną metodę abstrakcyjną, to możemy uznać go za interfejs funkcyjny. Interfejsy funkcyjne służą do implementowania wyrażeń lambda od Javy 8.

    public interface MyPrinter {
        void print();
    }
    Użycie interfejsu funkcyjnego:

    public class Main {
        private static MyPrinter printer = () -> System.out.println("Print something");
        public static void main(String[] args) {
            System.out.println("====");
            printer.print();
            System.out.println("====");
        }
    }
    Wynik takiego programu:

            ====
    Print something
====
    Interfejs funkcyjny możemy oznaczyć adnotacją @FunctionalInterface, ale jest to adnotacja informacyjna (i bez niej taki interfejs też może być używany jako lambda).

    Kolejną cechą interfejsów jest to, że klasy mogą implementować wiele interfejsów (jest to niekiedy nazywane wielo-dziedziczeniem w Javie, ale nie jest to klasyczne wielo-dziedziczenie, tak jak np. w C++, gdzie klasa może dziedziczyć z wielu klas). Dodatkowo interfejsy mogą także dziedziczyć z innych interfejsów (inaczej niż klasy, moga dziedziczyć z wielu interfejsów).

    Implementacja wielu interfejsów w klasie daje nam bardzo duże możliwości. Jeśli mamy jakąś klasę, to zawsze możemy do nie dodać jakieś zachowanie, poprzez zaimplementowanie kolejnego interfejsu. Dzięki interfejsom nie musimy dziedziczyć implementacji, a także interfejsy nie wymuszają na programiście konkretnej implementacji danego zachowania. Interfejs daje tylko szkielet tego, co programista powinien zaimplementować, ale nie narzuca, jak ma być to zrobione.


}
