package Project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuMain {
    private String objectFileName;

    public String getObjectFileName() {
        return objectFileName;
    }

    public void setObjectFileName(String objectFileName) {
        this.objectFileName = objectFileName;
    }

    public MenuMain() {
    }

    public void wyswietlListe(List<Pracownik> lista) {
        for (Pracownik a : lista) {
            a.wyswietlOkrojone();
        }
    }

    public void dodajPracownika(List<Pracownik> lista) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Wprowadz imię: ");
        String imie = scan.next();
        System.out.print("Wprowadz nazwisko: ");
        String nazwisko = scan.next();
        System.out.print("Wprowadz płeć ('K' – kobieta, 'M' – mężczyzna): ");
        char plec = scan.next().charAt(0);
        System.out.print("Wprowadz nr działu: ");
        int dzial = scan.nextInt();
        System.out.print("Wprowadz wysokość wynagrodzenia: ");
        float placa = scan.nextFloat();
        System.out.print("Wprowadz wiek: ");
        int wiek = scan.nextInt();
        System.out.print("Wprowadz liczbe dzieci: ");
        int dzieci = scan.nextInt();
        System.out.print("Stan cywilny: mężatka / żonaty - TAK | NIE ");
        String malzenstwo = scan.next();
        boolean stan_cywilny = true;
        if (malzenstwo.equalsIgnoreCase("TAK")) {
            stan_cywilny = false;
        }
        if (malzenstwo.equalsIgnoreCase("NIE")) {
            stan_cywilny = true;
        }
        Pracownik pracownik = new Pracownik(imie, nazwisko, plec, dzial, placa, wiek, dzieci, stan_cywilny);
        lista.add(pracownik);
    }

    public void saveObjectToFile(List<Pracownik> lista) {
        try {
            FileOutputStream outputFile = new FileOutputStream("files/" + objectFileName);
            ObjectOutputStream objectOutput = new ObjectOutputStream(outputFile);
            for (Pracownik p : lista) {
                objectOutput.writeObject(new Pracownik(p.getNazwisko(), p.getImie(), p.getPlec(), p.getNr_dzialu(), p.getPlaca(), p.getWiek(), p.getDzieci()));
            }
        } catch (IOException e) {
        }
    }

    public void readObjectFile() throws ClassNotFoundException {
        List<Pracownik> pracownikList = null;
        try {
            FileInputStream inputFile = new FileInputStream("files/" + objectFileName);
            ObjectInputStream inputObject = new ObjectInputStream(inputFile);
            while (inputObject != null) {
                Pracownik pracownik = (Pracownik) inputObject.readObject();
                System.out.println(pracownik.getImie() + " " + pracownik.getNazwisko());
            }
        } catch (IOException e) {

        }
    }

    public void usunPracownika(List<Pracownik> lista) {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        for (Pracownik a : lista) {
            counter++;
            System.out.print(counter + ". - ");
            a.wyswietlWszystko();
        }
        System.out.println("Podaj nr pracownika do usunięcia ");
        int nrPracownika = scan.nextInt();
        try {
            lista.remove(nrPracownika - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nie ma takiej pozycji");
        }
    }

    public Pracownik pracownikDoEdycji(List<Pracownik> lista) throws NullPointerException {
        int licznik = 0;
        for (Pracownik a : lista) {
            licznik++;
            System.out.print(licznik + ". - ");
            a.wyswietlWszystko();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nr pracownika do edytowania danych ");
        boolean exit = false;
        while (!exit) {
            try {
                int nrPrac = scan.nextInt();
                return lista.get(nrPrac - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Podaj poprawną pozycję: ");
                exit = false;
            }
        }
        return null;
    }

    public void edycjaPracownika(Pracownik pracownik) {
        boolean exit = false;
        while (!exit) {
            Scanner scan = new Scanner(System.in);
            String x = String.valueOf(pracownik.getPlec());
            if (x.equalsIgnoreCase("K")) {
                System.out.println("Pozycje: \n" +
                        "Nazwisko\n" +
                        "Dział\n" +
                        "Płaca\n" +
                        "Wiek\n" +
                        "Dzieci\n" +
                        "Mężatka\n");
            } else
                System.out.println("Edytuj: \n" +
                        "Dział\n" +
                        "Płaca\n" +
                        "Wiek\n" +
                        "Dzieci\n" +
                        "Żonaty\n");
            System.out.println("Wpisz pozycję do edycji lub koniec aby wyjść: ");
            String edpoz = scan.next().toLowerCase();

            switch (edpoz) {
                case "nazwisko":
                    System.out.print("Podaj nowe nazwisko: ");
                    String nawisko = scan.next();
                    pracownik.setNazwisko(nawisko);
                    break;
                case "dział":
                    System.out.print("Podaj nowy nr działu: ");
                    int nr_dzialu = scan.nextInt();
                    pracownik.setNr_dzialu(nr_dzialu);
                    break;
                case "płaca":
                    System.out.print("Podaj nową stawkę wynagrodzenia: ");
                    float placa = scan.nextFloat();
                    pracownik.setPlaca(placa);
                    break;
                case "wiek":
                    System.out.print("Podaj wiek: ");
                    int wiek = scan.nextInt();
                    pracownik.setWiek(wiek);
                    break;
                case "dzieci":
                    System.out.print("Podaj liczbę dzieci: ");
                    int dzieci = scan.nextInt();
                    pracownik.setDzieci(dzieci);
                    break;
                case "mężatka":
                    System.out.println("Mężatka: TAK/NIE: ");
                    String mezatka = scan.next();
                    if (mezatka.equalsIgnoreCase("tak")) {
                        pracownik.setStan_cywilny(true);
                    }
                    if (mezatka.equalsIgnoreCase("nie")) {
                        pracownik.setStan_cywilny(false);
                    }
                    break;
                case "Żonaty":
                    System.out.println("Mężatka: TAK/NIE: ");
                    String zonaty = scan.next();
                    if (zonaty.equalsIgnoreCase("tak")) {
                        pracownik.setStan_cywilny(true);
                    }
                    if (zonaty.equalsIgnoreCase("nie")) {
                        pracownik.setStan_cywilny(false);
                    }
                    break;
                case "koniec":
                    exit = true;
                    break;
            }

        }
    }


}
