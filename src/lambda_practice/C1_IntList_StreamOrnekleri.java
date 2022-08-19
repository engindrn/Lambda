package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));
        boslukluYazdir(list);
        System.out.println();
        negatifYazdir(list);
        System.out.println();
        pozitifYazdir(list);
        System.out.println();
        kareleriYazdir(list);
        System.out.println();
        kareleriTekrarsizYazdir(list);
        System.out.println();
        kucuktenBuyugeYazdir(list);
        System.out.println();
        buyuktenKucugeYazdir(list);
        System.out.println();
        pozitifKupBirlerBsm5olanYazdir(list);
        System.out.println();
        pozitifKareBirlerBsm5olmayanListYazdir(list);
        System.out.println();
        toplamBul(list);
        System.out.println();
        negatiflerinKareleri(list);
        System.out.println();
        besdenBuyukSayilar(list);
        System.out.println();
        System.out.println(sifirdanKucukmu(list));
        System.out.println();
        System.out.println(yuzeEsitEleman(list));
        System.out.println();
        System.out.println(sifiraEsitEleman(list));
        System.out.println();
        ilkBesElemanTopla(list);
        System.out.println();
        sonBesElemanListele(list);


    }
    // S1:listi aralarinda bosluk birakarak yazdiriniz //
    public static void boslukluYazdir(List<Integer> list){

        list.stream().forEach(t->System.out.print(t+" "));

    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifYazdir(List<Integer> list){

        list.stream().filter(t->t<0).forEach(t->System.out.print(t+" "));

    }



    //S3: pozitif olanlardan yeni bir liste olustur
    public static void pozitifYazdir(List<Integer> list){

        System.out.println(list.stream().filter(t -> t > 0).collect(Collectors.toList()));

    }



    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static void kareleriYazdir(List<Integer> list){

        System.out.println(list.stream().map(t -> t * t).collect(Collectors.toList()));

    }

    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static void kareleriTekrarsizYazdir(List<Integer> list){

        System.out.println(list.stream().map(t -> t * t).distinct().collect(Collectors.toList()));

    }

    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static void kucuktenBuyugeYazdir(List<Integer> list){

        list.stream().sorted().forEach(t->System.out.print(t+" "));

    }

    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void buyuktenKucugeYazdir(List<Integer> list){

        list.stream().sorted(Comparator.reverseOrder()).forEach(t->System.out.print(t+" "));

    }



    // S8: list pozitif elemanlari icin kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static void pozitifKupBirlerBsm5olanYazdir(List<Integer> list){

        System.out.println(list.
                stream().
                filter(t -> t > 0).
                map(t -> t * t * t).
                filter(t -> t % 10 == 5).
                collect(Collectors.toList()));

    }



    //S9: list pozitif elemanlari icin karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static void pozitifKareBirlerBsm5olmayanListYazdir(List<Integer> list){

        System.out.println(list.
                stream().
                filter(t -> t > 0).
                map(t -> t * t).
                filter(t -> t % 10 != 5).
                collect(Collectors.toList()));

    }



    // S10 :list elemanlarini toplamini bulalim
    public static void toplamBul(List<Integer> list){

        //1.yol
        System.out.println(list.stream().reduce(Integer::sum));
        //2.yol
        System.out.println(list.stream().reduce(0, (x, y) -> x + y));
    }

    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static void negatiflerinKareleri(List<Integer> list){

        System.out.println("Negatiflerin Kareleri = "+list.
                stream().
                filter(t -> t < 0).
                peek(t-> System.out.println("Negatifler : "+t)).//denetlemek istediğimizin sonrasına ekliyoruz
                map(t -> t * t).
                collect(Collectors.toList()));

    }

    // S12 : listeden 5 den buyuk  sayi var mi?
    public static void besdenBuyukSayilar(List<Integer> list){

        System.out.println(list.stream().anyMatch(t -> t > 5));//true
        //list.stream().sorted().filter(t->t>5).forEach(t->System.out.print(t+" "));//5 den buyuk sayilari verir

    }

    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static boolean sifirdanKucukmu(List<Integer> list){

       return list.stream().allMatch(t -> t < 0);//false


    }



    // S14: listenin 100 e esit elemani yok mu ?
    public static boolean yuzeEsitEleman(List<Integer> list){

        return list.stream().noneMatch(t -> t ==100);


    }

    // S15: listenin sifira esit elemani yok mu?
    public static boolean sifiraEsitEleman(List<Integer> list){

        return list.stream().noneMatch(t -> t ==0);

    }

    // S16:  listenin ilk 5 elemanini topla?
    public static void ilkBesElemanTopla(List<Integer> list){

        //1.yol
        System.out.println(list.stream().limit(5).reduce(Integer::sum));
        //2.yol
        System.out.println(list.stream().limit(5).reduce(0, (x, y) -> x + y));
    }



    //S17: listenin son bes elemaninin  listele
    public static void sonBesElemanListele(List<Integer> list){

        //1.yol
        System.out.println(list.stream().skip(list.size()-5).collect(Collectors.toList()));//skip(7)

    }


}