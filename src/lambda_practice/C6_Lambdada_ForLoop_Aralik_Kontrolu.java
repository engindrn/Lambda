package lambda_practice;

import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {
        ilkOtuz(30);
        System.out.println();
        ilkOtuzDahil(30);
        System.out.println();
        ikiDegerTopla(10, 20);
        System.out.println();
        averageBul(20, 30);
        System.out.println();
        sekizeBolunen(325, 468);
        System.out.println();
        sekizeBolunenSayilar(325, 468);
        System.out.println();
        System.out.println(sekizeBolunenSayilarTopla(325, 468));
        System.out.println();
        tekSayiCarp(7, 15);
        System.out.println();
        tekSayiIlkOn(20);
        System.out.println();
        Yirmibirden7ninKatlariTek(21);
        System.out.println();
        System.out.println(yedininKatlaritoplam1(20));


    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void ilkOtuz(int a) {
        IntStream.range(1, a).//ilki dahil ikincisi dahil degil
                forEach(t -> System.out.print(t + " "));
    }


    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void ilkOtuzDahil(int a) {
        IntStream.rangeClosed(1, a).//ilki dahil ikincisi de dahil
                forEach(t -> System.out.print(t + " "));
    }


    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim
    public static void ikiDegerTopla(int a, int b) {
        System.out.println(IntStream.rangeClosed(a, b).sum());

    }


    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static void averageBul(int a, int b) {
        System.out.println(IntStream.rangeClosed(a, b).average());

    }


    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static void sekizeBolunen(int a, int b) {
        System.out.println(IntStream.rangeClosed(325, 468).
                filter(t -> t % 8 == 0).
                count());

    }


    //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
    public static void sekizeBolunenSayilar(int a, int b) {
        IntStream.rangeClosed(325, 468).//325 ile 468 arasindaki sayilari yazdir
                filter(t -> t % 8 == 0).
                forEach(t -> System.out.print(t + " "));

    }


    // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
    public static int sekizeBolunenSayilarTopla(int a, int b) {
        return IntStream.rangeClosed(325, 468).//325 ile 468 arasindaki sayilari yazdir
                filter(t -> t % 8 == 0).
                sum();

    }


    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static void tekSayiCarp(int a, int b) {
        System.out.println(IntStream.rangeClosed(7, 15).
                filter(t -> t % 2 != 0).reduce(1, (x, y) -> x * y));//Math::multiplyeExact

    }


    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void tekSayiIlkOn(int a) {
        //IntStream.rangeClosed(1,a).limit(10).
        //filter(Methods::tekMi).forEach(Methods::yazInteger);//1 3 5 7 9  bize ilk 10'u vermez
        IntStream.
                iterate(1, t -> t + 2).
                limit(10).
                forEach(Methods::yazInteger);//1 3 5 7 9 11 13 15 17 19 ilk 10 sayi yazdirildi
        /*
        iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
        iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
        limit() ile belilioruz
         */

    }


    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void Yirmibirden7ninKatlariTek(int a) {
        IntStream.
                iterate(21, t -> t + 7).
                filter(t -> t % 2 != 0).
                limit(10).
                forEach(Methods::yazInteger);

    }


    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
    public static int yedininKatlaritoplam1(int a) {
        return IntStream.iterate(21, t -> t + 7).//iterate icin bir baslangic degeri girilmeli ve
                                                      // artisin nasil olacagi belirtilmeli nerede biteceginide
                limit(20).
                sum();

    }
}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz