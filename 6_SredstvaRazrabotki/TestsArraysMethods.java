/*
2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
иначе в методе необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

3. Написать метод, который проверяет состав массива из чисел 1 и 4.
Если в нем нет хоть одной четверки или единицы, то метод вернет false;
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
*/


import java.util.stream.IntStream;

public class TestsArraysMethods {

    public static void main(String[] args) {

        int[] arr = {1, 1, 4};
        System.out.println(arrHaveOnly1and4(arr));

//        print(separateArrBeforeLast4(arr));
    }

    public static int[] separateArrBeforeLast4(int[] arr) {
        if (!arrHave4(arr)) {
            throw new RuntimeException("have not number 4");
        }

        int separate = -1;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 4) {
                separate = i;
            }
            if (separate == arr.length - 1)
                throw new RuntimeException
                        ("Number \"4\" the last element of the array. The new array will not be created");

        }
        int[] newarr = new int[arr.length - (separate + 1)];
        System.arraycopy(arr, separate + 1, newarr, 0, (arr.length - (separate + 1)));

        return newarr;
    }

    public static boolean arrHave4(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean arrHave1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static boolean arrHaveOnly1and4(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 1) {
                if (arr[i] != 4) {
                    return false;
                }
            }
        }
        return arrHave4(arr) && arrHave1(arr);
    }
}
