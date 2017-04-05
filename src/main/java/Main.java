import domain.MyObject;
import domain.Pracownik;

import java.io.*;
import java.util.Date;


public class Main {



    public static void main(String[] args) {
        final String ekstensjaPlik = "Ekstensja.bin";

        if(new File(ekstensjaPlik).isFile()){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ekstensjaPlik));
                MyObject.odczytajEkstensje(objectInputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }

        }

        Pracownik pracownik1 = new Pracownik();
        Pracownik pracownik2 = new Pracownik();
        Pracownik pracownik3 = new Pracownik("Jan", "Jake", 123.2, new Date());
        Pracownik pracownik4 = new Pracownik("kuba", "kibbb", 123.2, new Date());

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ekstensjaPlik));
            Pracownik.zapiszEkstensje(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Pracownik.getSredniaPensja());

        try {
            Pracownik.pokazEkstensje();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
