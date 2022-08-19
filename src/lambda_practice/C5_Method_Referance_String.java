package lambda_practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C5_Method_Referance_String {
    public static void main(String[] args) {
        List<String> l= Arrays.asList("Elma", "Muz", "Portakal", "Cilek", "Limon");
        buyukHarfBosluk(l);
        System.out.println();
        uzunluklarinaGoreSirala(l);
        System.out.println();
        eIleBaslayanlarYaz(l);


    }
    public static void boslukBirak (String str){
        System.out.print(str + " ");
    }
    // S1: Tum harfleri buyuk harf ile aralarinda bosluk birakarak yazdiralim
    public static void buyukHarfBosluk (List<String> l){
        l.stream().map(t->t.split("")).flatMap(Arrays::stream).
                map(String::toUpperCase).//t->t.toUpperCase
                forEach(C5_Method_Referance_String::boslukBirak);
    }
    //S2: Stringleri uzunluklarina gore siralayip yaziniz
    public static void uzunluklarinaGoreSirala (List<String> l){
        l.stream().
                //map(String::length).//map(t->t.length())
                        sorted(Comparator.comparing(t->t.length())).//(String::length) kullanilir
                forEach(C5_Method_Referance_String::boslukBirak);

    }

    //S3: E ILE Baslayanlari yazdiralim
    public static void eIleBaslayanlarYaz (List<String> l){
        l.stream().
               filter(t->t.toLowerCase().startsWith("e")).
                forEach(C5_Method_Referance_String::boslukBirak);

    }



}
