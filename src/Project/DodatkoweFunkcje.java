package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class DodatkoweFunkcje {

    public DodatkoweFunkcje() {
    }

    public void pracownicyZNizaPensja(List<Pracownik> lista) {
        System.out.println("Podaj wysokość pensji: ");
        Scanner scan = new Scanner((System.in));
        float placa = scan.nextFloat();
        int licznik = 0;
        for (Pracownik a : lista) {
            if (a.getPlaca() <= placa) {
                licznik++;
            }
        }
        System.out.println("Liczba pracowników z niższą pensją niż " + placa + " to: " + licznik);
    }

    public void sredniaPlacaWDziale(List<Pracownik> lista) {
        System.out.println("Podaj nr działu: ");
        Scanner scan = new Scanner((System.in));
        int nr_dzialu = scan.nextInt();
        float srednia = 0;
        int counter = 0;
        float suma = 0;
        for (Pracownik a : lista) {
            if (a.getNr_dzialu() == nr_dzialu) {
                counter++;
                suma = suma + a.getPlaca();
                srednia = suma / counter;
            }
        }
        System.out.println("Płaca średnia w dziale nr " + nr_dzialu + " to: " + srednia);
    }

    public void najwyzszaPensja(List<Pracownik> lista) {
        float pensjaKobiet = 0;
        float pensjaMezczyzn = 0;
        for (Pracownik a : lista) {
            if (a.getPlec() == 'k' || a.getPlec() == 'K') {
                if (pensjaKobiet < a.getPlaca()) {
                    pensjaKobiet = a.getPlaca();
                }
            }
            if (a.getPlec() == 'm' || a.getPlec() == 'M') {
                if (pensjaMezczyzn < a.getPlaca()) {
                    pensjaMezczyzn = a.getPlaca();
                }
            }
        }
        System.out.println("Najwyższa pensja mężczyzn to: " + pensjaMezczyzn);
        System.out.println("Najwyższa pensja kobiet to: " + pensjaKobiet);
    }

    public void rise10(List<Pracownik> lista) {
        for (Pracownik a : lista) {
            a.rise(10);
        }
    }

    public void sortName(boolean sort) {
        try {
            Scanner odczyt = new Scanner(new File("files/exportFile.txt"));
            List<Pracownik> pracownikList = new ArrayList<>();
            while (odczyt.hasNextLine()) {
                String text = odczyt.nextLine();
                List<String> list = Arrays.asList(text.split(",\\s"));
                Pracownik pracownik = new Pracownik(list.get(1), list.get(0), list.get(2).charAt(0), Integer.parseInt(list.get(3)),
                        Float.parseFloat(list.get(4)), Integer.parseInt(list.get(5)), Integer.parseInt(list.get(6)), Boolean.parseBoolean(list.get(7)));
                pracownikList.add(pracownik);
            }
            if (sort == true) {
                pracownikList.sort(Comparator.comparing(Pracownik::getNazwisko));
                System.out.println("Posortowano po nazwisku - rosnąco");
            }
            if (sort == false) {
                pracownikList.sort(Comparator.comparing(Pracownik::getNazwisko).reversed());
                System.out.println("Posortowano po nazwisku - malejąco");
            }
            PrintWriter zapis = new PrintWriter("files/exportFile.txt");
            for (Pracownik p : pracownikList) {
                zapis.print(p.getNazwisko());
                zapis.print(", ");
                zapis.print(p.getImie());
                zapis.print(", ");
                zapis.print(p.getPlec());
                zapis.print(", ");
                zapis.print(p.getNr_dzialu());
                zapis.print(", ");
                zapis.print(p.getPlaca());
                zapis.print(", ");
                zapis.print(p.getWiek());
                zapis.print(", ");
                zapis.print(p.getDzieci());
                zapis.print(", ");
                zapis.print(p.isStan_cywilny());
                zapis.println();
            }
            zapis.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void sortSalary(boolean sort) {

        try {
            Scanner odczyt = new Scanner(new File("files/exportFile.txt"));
            List<Pracownik> pracownikList = new ArrayList<>();
            while (odczyt.hasNextLine()) {
                String text = odczyt.nextLine();
                List<String> list = Arrays.asList(text.split(",\\s"));
                Pracownik pracownik = new Pracownik(list.get(1),
                        list.get(0),
                        list.get(2).charAt(0),
                        Integer.parseInt(list.get(3)),
                        Float.parseFloat(list.get(4)),
                        Integer.parseInt(list.get(5)),
                        Integer.parseInt(list.get(6)),
                        Boolean.parseBoolean(list.get(7)));
                pracownikList.add(pracownik);
            }
            if (sort == true) {
                pracownikList.sort(Comparator.comparing(Pracownik::getPlaca));
                System.out.println("Posortowano po płacy - rosnąco");
            }
            if (sort == false) {
                pracownikList.sort(Comparator.comparing(Pracownik::getPlaca).reversed());
                System.out.println("Posortowano po płacy - malejąco");
            }
            PrintWriter zapis = new PrintWriter("files/exportFile.txt");
            for (Pracownik p : pracownikList) {
                zapis.print(p.getNazwisko());
                zapis.print(", ");
                zapis.print(p.getImie());
                zapis.print(", ");
                zapis.print(p.getPlec());
                zapis.print(", ");
                zapis.print(p.getNr_dzialu());
                zapis.print(", ");
                zapis.print(p.getPlaca());
                zapis.print(", ");
                zapis.print(p.getWiek());
                zapis.print(", ");
                zapis.print(p.getDzieci());
                zapis.print(", ");
                zapis.print(p.isStan_cywilny());
                zapis.println();
            }
            zapis.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}



