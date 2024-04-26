public class Scanner {
    Na początek napiszmy program, który wczyta od użytkownika informację o jego imieniu, a następnie wyświetli powitanie.

            import java.util.Scanner;

    class Hello {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Jak masz na imię?");
            String firstName = scan.nextLine();

            System.out.println("Witaj " + firstName);
        }
    }
    Klasa Scanner znajduje się w pakiecie java.util. Oznacza to tyle, że jeżeli chcemy z niej skorzystać, to musimy ją na samym początku zaimportować.
}


SUPER

Zacznijmy od przykładu. Niech klasą bazową będzie Pracownik, a rozszerzać ją będą Lekarz oraz Pielęgniarka. Pielęgniarka oprócz podstawowych pól odziedziczonych z Pracownika, czyli imię, nazwisko i wypłata, posiada również informację o ilości nadgodzin, natomiast Lekarz o premii.

public class Pracownik {
    private String imie;
    private String nazwisko;
    private double wyplata;

    public Pracownik(String imie, String nazwisko, double wyplata){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wyplata = wyplata;
    }

    String getImie(){ return imie; }
    String getNazwisko(){ return nazwisko; }
    double getWyplata(){ return wyplata; }
}
public class Pielegniarka extends Pracownik{
    private int nadgodziny;

    public Pielegniarka(String imie, String nazwisko, double wyplata) {
        super(imie, nazwisko, wyplata);
        nadgodziny = 0;
    }

    public int getNadgodziny(){ return nadgodziny; }
    public void setNadgodziny(int n){
        nadgodziny += n;
    }
}
public class Lekarz extends Pracownik{
    private double premia;

    public Lekarz(String imie, String nazwisko, double wyplata) {
        super(imie, nazwisko, wyplata);
        premia = 0;
    }

    public double getPremia(){ return premia; }
    public void setPremia(double d){
        premia = d;
    }
}