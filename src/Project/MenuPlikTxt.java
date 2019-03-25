package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuPlikTxt {
    public MenuPlikTxt() {
    }

    public void zapiszPlik(List<Pracownik> lista) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("files/exportFile.txt");
        for (Pracownik p : lista) {
            zapis.print(p.getImie());
            zapis.print(", ");
            zapis.print(p.getNazwisko());
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
    }

// Metoda pracujaca na obiekcie pracownik
    public void longestName() throws FileNotFoundException {
        Scanner odczyt = new Scanner(new File("files/exportFile.txt"));
        List<Pracownik> pracownikList = new ArrayList<>();
        while (odczyt.hasNextLine()) {
            String text = odczyt.nextLine();
            List<String> list = Arrays.asList(text.split(",\\s"));
            Pracownik pracownik = new Pracownik(list.get(0), list.get(1), list.get(2).charAt(0), Integer.parseInt(list.get(3)),
                    Float.parseFloat(list.get(4)), Integer.parseInt(list.get(5)), Integer.parseInt(list.get(6)), Boolean.parseBoolean(list.get(7)));
            pracownikList.add(pracownik);
        }
        Pracownik withLongestName = null;
        int lenght = 0;
        for (Pracownik p : pracownikList) {
            if (p.getNazwisko().length() > lenght) {
                lenght = p.getNazwisko().length();
                withLongestName = p;
            }
        }
        System.out.println(withLongestName);
    }


//Metoda pracująca na lini tekstu
    public void longestName2() throws FileNotFoundException {
        Scanner odczyt = new Scanner(new File("files/exportFile.txt"));
        int lenght = 0;
        String longestNameLine = null;
        while (odczyt.hasNextLine()) {
            String line = odczyt.nextLine();
            List<String> list = Arrays.asList(line.split(",\\s"));
            if (list.get(1).length() > lenght) {
                lenght = list.get(1).length();
                longestNameLine = line;
            }
        }
        System.out.println(longestNameLine);
    }

    public void sredniWiek() throws FileNotFoundException {
        Scanner odczyt = new Scanner(new File("files/exportFile.txt"));
        int srednia;
        int wiek;
        int suma = 0;
        int licznik = 0;

        while (odczyt.hasNextLine()) {
            String line = odczyt.nextLine();
            List<String> list = Arrays.asList(line.split(",\\s"));
            if (Integer.parseInt(list.get(6)) > 0) {
                wiek = Integer.parseInt(list.get(5));
                suma = suma + wiek;
                licznik++;
            }
        }
        srednia = suma / licznik;
        System.out.println("Średni wiek osób posiadających dzieci to: " + srednia);
    }

    public void nameCode(List<Pracownik> lista) throws FileNotFoundException {
        Scanner odczyt = new Scanner(new File("files/exportFile.txt"));
        int counter = 0;
        int suma = 0;

        List<String> listLine = new ArrayList<>();
        while (odczyt.hasNextLine()) {
            String line = odczyt.nextLine();
            listLine.add(line);
            List<String> list = Arrays.asList(line.split(",\\s"));
            suma = suma + Integer.parseInt(list.get(5));
            counter++;
        }
        int srednia = suma / counter;
        PrintWriter zapis = new PrintWriter("files/exportFile.txt");
        for (String s : listLine) {
            List<String> list = Arrays.asList(s.split(",\\s"));
            if (Integer.parseInt(list.get(5)) < srednia) {
                zapis.print(list.get(0));
                zapis.print(", ");
                zapis.print(list.get(1).substring(0, 1) + list.get(1).substring(1).replaceAll(".", "*"));
                zapis.print(", ");
                zapis.print(list.get(2));
                zapis.print(", ");
                zapis.print(list.get(3));
                zapis.print(", ");
                zapis.print(list.get(4));
                zapis.print(", ");
                zapis.print(list.get(5));
                zapis.print(", ");
                zapis.print(list.get(6));
                zapis.print(", ");
                zapis.print(list.get(7));
                zapis.println();
            } else {
                zapis.println(s);
            }
        }
        zapis.close();
    }

    public void pracownicyHtlm() throws IOException {
        Scanner odczyt = new Scanner(new File("files/exportFile.txt"));
        PrintWriter zapis = new PrintWriter("files/pracownicy.html");
        List<String> listLine = new ArrayList<>();
        zapis.print("<meta charset=\"UTF-8\">\n" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Imie</th>\n" +
                "    <th>Nazwisko</th>\n" +
                "    <th>Płeć</th>\n" +
                "    <th>Numer działu</th>\n" +
                "    <th>Płaca</th>\n" +
                "    <th>Wiek</th>\n" +
                "  </tr>\n");
        while (odczyt.hasNextLine()) {
            String line = odczyt.nextLine();
            listLine.add(line);
            List<String> list = Arrays.asList(line.split(",\\s"));
            zapis.print("<tr>\n" +
                    "<td>" + list.get(0) + "</td>\n" +
                    "<td>" + list.get(1) + "</td>\n" +
                    "<td>" + list.get(2) + "</td>\n" +
                    "<td>" + list.get(3) + "</td>\n" +
                    "<td>" + list.get(4) + "</td>\n" +
                    "<td>" + list.get(5) + "</td>\n" +
                    "</tr>\n");
        }
        zapis.print("</table>");
        zapis.close();
    }

}
