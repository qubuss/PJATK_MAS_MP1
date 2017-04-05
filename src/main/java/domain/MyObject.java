package domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class MyObject implements Serializable {

    private static Hashtable<Class, ArrayList<MyObject>> ekstensje = new Hashtable<Class, ArrayList<MyObject>>();

    public MyObject(){
        ArrayList<MyObject> ekstensja;
        Class klasa = this.getClass();

        if(ekstensje.containsKey(klasa)){
            ekstensja = ekstensje.get(klasa);
        }else {
            ekstensja = new ArrayList<MyObject>();
            ekstensje.put(klasa, ekstensja);
        }

        ekstensja.add(this);
    }

    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensje);
    }

    public static void odczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensje = (Hashtable<Class, ArrayList<MyObject>>) stream.readObject();
    }

    public static void pokazEkstensje(Class klasa) throws Exception {
        ArrayList ekstensja;
        if(ekstensje.containsKey(klasa)){
            ekstensja = ekstensje.get(klasa);
        }else {
            throw  new Exception("Nieznana klasa "+klasa);
        }
        System.out.println("Ekstensje pracownika: ");
        for (Object obiekt: ekstensja) {
            System.out.println(obiekt);
        }
    }

}
