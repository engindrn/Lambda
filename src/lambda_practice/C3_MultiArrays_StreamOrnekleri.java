package lambda_practice;
//multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };
        listele(arr);
        doubleYazdir(arr);
        eIleBaslaList(arr);
        kIleBiten(arr);


    }
    // S1 : tum elemanlari list yapayim
    public static void listele (String [][] arr) {
        System.out.println(Arrays.stream(arr).
                flatMap(Arrays::stream).
                collect(Collectors.toList()));
    };



    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static void doubleYazdir (String [][] arr) {
        Arrays.stream(arr).
                flatMap(Arrays::stream).
                filter(t->t.toLowerCase().
                        //map(t->t+t) --> sout(t) diyerekte yazdirabiliriz.
                        startsWith("e")).
                forEach(t->System.out.println(t+t));
    };



    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static void eIleBaslaList (String [][] arr) {
        System.out.println(Arrays.stream(arr).
                flatMap(Arrays::stream).
                filter(t -> t.toLowerCase().startsWith("e")).
                collect(Collectors.toList()));
    };

    //S4 : k ile bitenlerin sonuna '*' ekleyelim
    public static void kIleBiten (String [][] arr) {
        Arrays.stream(arr).flatMap(t->Arrays.stream(t)).
                filter(t -> t.toLowerCase().endsWith("k")).
                forEach(t ->System.out.println(t+"*"));
    }

}
