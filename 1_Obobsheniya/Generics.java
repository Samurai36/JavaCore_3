/*
1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
(вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра,
true – если она равны по весу, false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
Не забываем про метод добавления фрукта в коробку.
 */

import java.util.ArrayList;

class Generics {

    public static void main(String[] args) {

        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5};
        Object[] objArray = new Object[]{"One", 2.0, 3, null, 5};

        printArray(swapElemtArray(intArray, 0, 2));
        printArray(swapElemtArray(objArray, 0, 3));

        ArrayList<Object> list = convertArrToArrayList(objArray);
        System.out.println(list);
    }

    public static <T> T[] swapElemtArray(T[] inputArray, int elem1, int elem2) {

        if (elem1 < inputArray.length - 1 && elem1 >= 0 && elem2 < inputArray.length - 1 && elem2 >= 0) {
            T temp;
            temp = inputArray[elem1];
            inputArray[elem1] = inputArray[elem2];
            inputArray[elem2] = temp;
            return inputArray;
        }
        return inputArray;
    }

    public static <T> void printArray(T[] inputArray) {
        System.out.print("[ ");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.print("]\n");
    }

    public static <T> ArrayList<T> convertArrToArrayList(T[] inputArray) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T element : inputArray) {
            arrayList.add(element);
        }
        return arrayList;
    }
}
