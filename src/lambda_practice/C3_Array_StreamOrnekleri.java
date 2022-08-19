package lambda_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C3_Array_StreamOrnekleri {
    public static void main(String[] args) {

        // Arraylerde Stream kullanabilmek icin 2 yol vardir
        // 1) Stream <Integer> isim=StreamOf(cevrilecek olan) -> Stream objesi
        // 2) Arrays.stream(arr).  ->  Array sinifindan yararlanarak
        //Array ler collection sinifinda degillerdir..set ve MAp ler gibi degildir..
        // kullanabilmek icin donusum yapilmalidir

        Integer arr1[] = {1, 5, -5, 6, 12, -8, 9, 3, 4};
        int arr2[] = {1, 5, -5, 6, 12, -8, 9, 3, 4};
        System.out.println(Arraylistele(arr1));
        System.out.println(ArrayTopla(arr1));
        ArrayTopla2(arr2);
        ArrayOrtalamaBul(arr2);

    }

    //S1: arrayin elemanlarini bir liste yazdiralim
    public static List<Integer> Arraylistele(Integer[] arr) {
        return Arrays.stream(arr).collect(Collectors.toList());
    }


    //S2: Arrayin elemanlarini toplamini bulalim
    public static int ArrayTopla(Integer[] arr) {

        Stream<Integer> yeniArr = Stream.of(arr);

        return yeniArr.reduce(0, (x, y) -> x + y);

    }

    //2.yol
    public static void ArrayTopla2(int[] arr) {
        System.out.println(Arrays.stream(arr).sum());

    }

    // S3: Array in elemanlarinin ortalamasini bulalim yazdir
    public static void ArrayOrtalamaBul(int[] arr) {

        Arrays.stream(arr).average().ifPresent(t -> System.out.println(t));


    }


}
