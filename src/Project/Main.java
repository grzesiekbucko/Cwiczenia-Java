package Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Pracownik> list = new ArrayList<>(100);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MenuMain menuMain = new MenuMain();
        DodatkoweFunkcje dodatkoweFunkcje = new DodatkoweFunkcje();
        MenuPlikTxt menuPlikTxt = new MenuPlikTxt();
        menuMain.setObjectFileName("baza.dat");

        boolean exit = false;
        while (!exit) {
            Scanner scan = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("\t\t  MENU\n" +
                    "---------------------------- \n" +
                    "1. Lista pracowników \n" +
                    "2. Dodaj pracownika \n" +
                    "3. Zapisz plik \n" +
                    "4. Usuń pracownika \n" +
                    "5. Edytuj dane \n" +
                    "6. Dodatkowe funkcje \n" +
                    "7. Dodatkowe funkcje dla plików tekstowych \n" +
                    "8. Informacje o programie \n" +
                    "9. Zmien nazwę pliku do eksportu obiektów \n" +
                    "10. Wyjscie z programu \n" +
                    "\n" +
                    "11. Wczytaj obiekty z pliku\n" +
                    "12. Dodaj przykładowych pracownikow \n");
            int menu = scan.nextInt();
            switch (menu) {
                case 1:
                    menuMain.wyswietlListe(list);
                    break;
                case 2:
                    menuMain.dodajPracownika(list);
                    break;
                case 3:
                    menuMain.saveObjectToFile(list);
                    break;
                case 4:
                    menuMain.usunPracownika(list);
                    break;
                case 5:
                    Pracownik pracownik = menuMain.pracownikDoEdycji(list);
                    pracownik.wyswietlWszystko();
                    menuMain.edycjaPracownika(pracownik);
                    break;
                case 6:
                    boolean exit2 = false;
                    while (!exit2) {
                        System.out.println();
                        System.out.println("\tDodatkowe funkcje \n" +
                                "---------------------------- \n" +
                                "1. Liczba pracowników z pensją poniżej \n" +
                                "2. Oblicz średnią płacę w dziale \n" +
                                "3. Wyświetl najwyższe pensje \n" +
                                "4. Podwyżka o 10% + bonusy \n" +
                                "5. Sortowanie pracowników (w pliku) według nazwiska \n" +
                                "6. Sortowanie pracowników (w pliku) według płacy \n" +
                                "9. Powrót");
                        int menu2 = scan.nextInt();
                        switch (menu2) {
                            case 1:
                                dodatkoweFunkcje.pracownicyZNizaPensja(list);
                                break;
                            case 2:
                                dodatkoweFunkcje.sredniaPlacaWDziale(list);
                                break;
                            case 3:
                                dodatkoweFunkcje.najwyzszaPensja(list);
                                break;
                            case 4:
                                dodatkoweFunkcje.rise10(list);
                                break;
                            case 5:
                                dodatkoweFunkcje.sortName(true);
                                break;
                            case 6:
                                dodatkoweFunkcje.sortSalary(true);
                                break;
                            case 9:
                                exit2 = true;
                        }
                    }
                    break;
                case 7:
                    boolean exit3 = false;
                    menuPlikTxt.zapiszPlik(list);
                    while (!exit3) {
                        System.out.println();
                        System.out.println("\tDodatkowe funkcje dla plików tekstowych \n" +
                                "---------------------------------------------- \n" +
                                "1. Wyświetl osobę o najdłuższym nazwisku \n" +
                                "2. Średni wiek osob posiadających dzieci \n" +
                                "3. Zakodowanie danych \n" +
                                "4. Utworzenie pliku 'pracownicy.html' z tabelą\n" +
                                "5. Powrót");
                        int menu3 = scan.nextInt();
                        switch (menu3) {
                            case 1:
                                menuPlikTxt.longestName2();
                                break;
                            case 2:
                                menuPlikTxt.sredniWiek();
                                break;
                            case 3:
                                menuPlikTxt.nameCode(list);
                                break;
                            case 4:
                                menuPlikTxt.pracownicyHtlm();
                                break;
                            case 5:
                                exit3 = true;
                        }
                    }
                    break;
                case 8:
                    System.out.println("projekt ćwiczeniowy author Grzesiek B.");
                    break;
                case 9:
                    System.out.println("Podaj nową nazwę pliku");
                    String fileName = scan.next();
                    menuMain.setObjectFileName(fileName);
                    break;
                case 10:
                    exit = true;
                    break;
                case 11:
                    menuMain.readObjectFile();
                    break;
                case 12:
                    Pracownik pracownik1 = new Pracownik("Mikołaj", "Wierzbicki", 'M', 23, 100, 33, 3, true);
                    Pracownik pracownik2 = new Pracownik("Szymon", "Borkowski", 'M', 2, 1800, 22, 0, false);
                    Pracownik pracownik3 = new Pracownik("Katarzyna", "Nowak", 'K', 23, 1200, 26, 2, true);
                    Pracownik pracownik4 = new Pracownik("Emila", "Mróz", 'K', 18, 200, 28, 2, false);
                    Pracownik pracownik5 = new Pracownik("Oliwia", "Michałowska", 'K', 2, 1800, 31, 2, false);
                    list.add(pracownik1);
                    list.add(pracownik2);
                    list.add(pracownik3);
                    list.add(pracownik4);
                    list.add(pracownik5);
                    break;
            }

        }


    }
}
