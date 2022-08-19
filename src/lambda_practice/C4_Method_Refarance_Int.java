package lambda_practice;

// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi touppercase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(-2,-8,-5,0,2,5,6,7,15,6,8);

        tekleriBoslukluYaz(list);
        System.out.println();
        ciftCarpimBul(list);
        negatifKareTopla(list);
        pozKuplerinMaxDegeri(list);

    }
    public static void BoslukBirak (int x){
        System.out.print(x+" ");

    }
    public static boolean ciftBul (int x){
       return x%2==0;

    }
    public static boolean negatif (int x){
        return x<0;

    }
    public static boolean pozitif (int x){
        return x>0;

    }

    public static int kareBul (int x){
        return x*x;
    }
    public static int kup (int x){
        return x*x*x;
    }

    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    public static void tekleriBoslukluYaz(List<Integer> list){
        list.stream().
                filter(Methods::tekMi).
                forEach(C4_Method_Refarance_Int::BoslukBirak);
    }

    // S2: ciftlein carpimini bulalim
    public static void ciftCarpimBul(List<Integer> list){
        System.out.println(list.stream().filter(t->t!=0).
                filter(Methods::ciftMi).
                reduce(Math::multiplyExact));
    }

    // S3: negatiflerin kare toplamlarini  bulalim
    public static void negatifKareTopla (List<Integer> list){
        System.out.println(list.stream().
                filter(C4_Method_Refarance_Int::negatif).
                map(C4_Method_Refarance_Int::kareBul).
                reduce(Math::addExact));
    }

    // S4: poziflerin kuplerinden max yazdiralim
    public static void pozKuplerinMaxDegeri (List<Integer> list){
        System.out.println(list.stream().
                filter(C4_Method_Refarance_Int::pozitif).
                //mapToInt(C4_Method_Refarance_Int::kup).max());
                map(C4_Method_Refarance_Int::kup).reduce(1,Math::max));//Optional dan kurtulmak icin identity 1 yap
    }

}
