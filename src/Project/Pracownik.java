package Project;

import java.io.Serializable;
import java.util.List;

public class Pracownik implements Serializable {
    private String imie;
    private String nazwisko;
    private char plec;
    private int nr_dzialu;
    private float placa;
    private int wiek;
    private int dzieci;
    private boolean stan_cywilny;

    public Pracownik(String imie, String nazwisko, char plec, int nr_dzialu, float placa, int wiek, int dzieci, boolean stan_cywilny) {
        this.imie = imie.substring(0, 1).toUpperCase() + imie.substring(1).toLowerCase();
        this.nazwisko = nazwisko.substring(0, 1).toUpperCase() + nazwisko.substring(1).toLowerCase();
        this.plec = plec;
        this.nr_dzialu = nr_dzialu;
        this.placa = placa;
        this.wiek = wiek;
        this.dzieci = dzieci;
        this.stan_cywilny = stan_cywilny;
    }

    public Pracownik(String nazwisko, String imie, char plec, int nr_dzialu, float placa, int wiek,int dzieci) {
        this.nazwisko = nazwisko.substring(0, 1).toUpperCase() + nazwisko.substring(1).toLowerCase();
        this.imie = imie.substring(0, 1).toUpperCase() + imie.substring(1).toLowerCase();
        this.plec = plec;
        this.nr_dzialu = nr_dzialu;
        this.placa = placa;
        this.wiek = wiek;
        this.dzieci = dzieci;
    }

    public Pracownik() {
    }

    public void wyswietlListe(List lista) {
        System.out.println(lista);
    }

    public void wyswietlWszystko() {
        System.out.println(imie + ", " + nazwisko + ", " + plec + ", " + nr_dzialu + ", " + placa + ", " + wiek + ", " + dzieci + ", " + stan_cywilny);
    }

    public void wyswietlOkrojone() {
        System.out.println(imie + " " + nazwisko + " " + placa);
    }

    public void wyswietlSpecjalne() {
        System.out.println(imie.toUpperCase() + " " + nazwisko.toUpperCase());
    }

    public boolean pensjaPowyzej(float pensja) {
        if (pensja <= placa) {
            return false;
        } else return true;
    }

    public void rise(int procent) {
        float procentKwota = (placa * procent) / 100;
        float podwyzkaDzieci = (placa * (dzieci * 2)) / 100;
        if (stan_cywilny == true) {
            float podwyzkaMalzenska = (placa * 3) / 100;
            placa = placa + procentKwota + podwyzkaDzieci + podwyzkaMalzenska;
        } else placa = placa + procentKwota + podwyzkaDzieci;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public char getPlec() {
        return plec;
    }

    public int getNr_dzialu() {
        return nr_dzialu;
    }

    public void setNr_dzialu(int nr_dzialu) {
        this.nr_dzialu = nr_dzialu;
    }

    public float getPlaca() {
        return placa;
    }

    public void setPlaca(float placa) {
        this.placa = placa;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getDzieci() {
        return dzieci;
    }

    public void setDzieci(int dzieci) {
        this.dzieci = dzieci;
    }

    public boolean isStan_cywilny() {
        return stan_cywilny;
    }

    public void setStan_cywilny(boolean stan_cywilny) {
        this.stan_cywilny = stan_cywilny;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pracownik{");
        sb.append("imie = ").append(imie);
        sb.append(", nazwisko = ").append(nazwisko);
        sb.append(", plec = ").append(plec);
        sb.append(", nr_dzialu = ").append(nr_dzialu);
        sb.append(", placa = ").append(placa);
        sb.append(", wiek = ").append(wiek);
        sb.append(", dzieci = ").append(dzieci);
        sb.append(", stan_cywilny = ").append(stan_cywilny);
        sb.append('}');
        return sb.toString();
    }

}
