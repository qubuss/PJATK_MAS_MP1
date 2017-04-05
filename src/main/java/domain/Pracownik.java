package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pracownik extends MyObject implements Serializable{ //Serializable zapewnia trwałość

    //Atrybuty proste
    private String imie;
    private String nazwisko;
    private double pensja;

    //Atrybut złożony, opcjonalny
    private Date dataUrodzenia;

    private static double sredniaPensja = 0;

    private static int iloscPracownikow = 0;

    private static List<Pracownik> ekstensja = new ArrayList<Pracownik>();

    public Pracownik() {
        super();
        dodajPracownika(this);
        iloscPracownikow++;
    }

    //Przeciązony konstruktor
    public Pracownik(String imie, String nazwisko, double pensja, Date dataUrodzenia) {
        super();
        this.imie = imie;
        if(nazwisko == null){
            throw new NullPointerException("Pracownik musi mieć nazwisko");
        }
        this.nazwisko = nazwisko;
        this.pensja = pensja;
        this.dataUrodzenia = dataUrodzenia;
        dodajPracownika(this);

        iloscPracownikow++;
        sredniaPensja += (this.pensja - sredniaPensja)/iloscPracownikow;
    }

    private void dodajPracownika(Pracownik pracownik){
        ekstensja.add(pracownik);
    }

    public void usunPracownika(Pracownik pracownik){
        ekstensja.remove(pracownik);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        if(nazwisko == null){
            throw new NullPointerException("Pracownik musi mieć nazwisko");
        }
        this.nazwisko = nazwisko;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
        sredniaPensja += (this.pensja = sredniaPensja)/iloscPracownikow;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }


    public static void pokazEkstensje() throws Exception {
        MyObject.pokazEkstensje(Pracownik.class);
    }



    public static double getSredniaPensja() {
        return sredniaPensja;
    }

    //Przesłonięcie moetody

    @Override
    public String toString() {
        nazwisko = (nazwisko != null) ? nazwisko:"nie ma nazwiska";
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pensja=" + pensja +
                ", dataUrodzenia=" + dataUrodzenia +
                '}';
    }

}
