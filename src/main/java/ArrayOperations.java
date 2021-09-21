
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ArrayOperations {
//    1. Написать метод, которому в качестве аргумента передается
//    не пустой одномерный целочисленный массив. Метод должен вернуть
//    новый массив, который получен путем вытаскивания из исходного массива
//        элементов, идущих после последней четверки. Входной массив должен
//    содержать хотя бы одну четверку, иначе в методе необходимо выбросить
//    RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    public Integer[] returnAnotherArray(int[] firstArr) {
       ArrayList<Integer> secondArr = new ArrayList<Integer>();
        for (int i = firstArr.length - 1; i >= 0 && firstArr[i] != 4; i--) {
            secondArr.add(firstArr[i]);
        }
        if(secondArr.size() == firstArr.length) { throw new RuntimeException("Исходный массив не содержит 4!"); }
        Collections.reverse(secondArr);
        Integer[] resultArray = secondArr.toArray(new Integer[secondArr.size()]);
        return resultArray;
            }

//    2. Написать метод, который проверяет состав массива из чисел 1 и 4.
//    Если в нем нет хоть одной четверки или единицы, то метод вернет false; Написать
//    набор тестов для этого метода (по 3-4 варианта входных данных).
   public static boolean checkArray(int[] arr) {
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 1) { count++; }
            if(arr[i] != 4) { count1++; }
            if(count == arr.length | count1 == arr.length) return false;
        }
        count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 4 | arr[i] == 1) { count++; }
            if(count == arr.length) return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        Random random = new Random();
//        int a[] = new int[10];
//        for (int i = 0; i < 10; i++) {
//           a[i] = random.nextInt(7);
//        }
        ArrayOperations arrayOperations = new ArrayOperations();

        int array1[] = {1, 2, 3, 6, 7, 8, 12, 5, 4, 6, 9, 2};
        int array2[] = {4, 21, 5, 8, 9, 16, 9, 7, 2, 0, 8};
        int array3[] = {1, 6, 7, 8, 9, 0, 21, 6, 8, 90, 33, 18};
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(array1));
        System.out.println("Результирующий массив: " + Arrays.toString(arrayOperations.returnAnotherArray(array1)));
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(array2));
        System.out.println("Результирующий массив: " + Arrays.toString(arrayOperations.returnAnotherArray(array2)));
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(array3));
        System.out.println("Результирующий массив: " + Arrays.toString(arrayOperations.returnAnotherArray(array3)));

        int[] arr1 = {1, 4, 1, 4, 4, 4, 1, 1, 4, 1, 1, 4, 4};
        int[] arr2 = {4, 4, 1, 1, 1, 4, 2, 1, 4, 4, 1, 1, 4};
        int[] arr3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] arr4 = {4, 4, 4 ,4 ,4 ,4, 4, 4, 4, 4, 4, 4, 4};
        System.out.println(checkArray(arr1));
        System.out.println(checkArray(arr2));
        System.out.println(checkArray(arr3));
        System.out.println(checkArray(arr4));
    }
}
