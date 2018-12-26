package Lesson_2.Ex_1_Array;


import java.util.Arrays;


public class Ex_1_Array {

    public static void main(String[] args) {
        // создание массива
        int[] array = new int[10];

        Integer[] arrayInt = new Integer[10];
        // заполнение массива
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = i * 2;
        }
        System.out.println(Arrays.deepToString(arrayInt));
        arrayInt = addToArray(arrayInt, 4, 80);
        System.out.println(Arrays.deepToString(arrayInt));
        arrayInt = removeToArray(arrayInt, 80);
        System.out.println(Arrays.deepToString(arrayInt));
        int index = findElement(arrayInt, 12);
        System.out.println(index);
        int index2 = fastFindElement(arrayInt, 12);
        System.out.println("Found index = "+ index2);
        int index3 = fastFindElementTwo(arrayInt, 12);
        System.out.println("Found index = "+ index3);

    }

    // вставляем элемент
    private static Integer[] addToArray(Integer[] input, int index, int element) {
        Integer[] output = new Integer[input.length + 1];
        for (int i = 0; i <= input.length; i++) {
            if(i > index){
                output[i] = input[i-1];
            } else if(i == index) {
                output[i] = element;
            } else {
                output[i] = input[i];
            }
        }
        return output;
    }

    // удаление элемента
    private static Integer[] removeToArray(Integer[] input, int element) {
        Integer[] output = new Integer[input.length - 1];
        int index = -1;
        for (int j = 0; j < input.length; j++) {
            if(input[j] == element) {
                index = j;
                break;
            }
        }
        if (index == -1){
            throw new IllegalArgumentException("Element is not found");
        }
        for (int i = 0; i < output.length; i++) {
            if(i < index){
                output[i] = input[i];
            } else {
                output[i] = input[i + 1];
            }
        }
        return output;
    }

    // поиск по элементу
    private static Integer findElement(Integer[] input, int element){
        int j = 1;
        for (int i = 0; i < input.length; i++, j++) {
            System.out.println("Try number " + j);
            if(element == input[i]) {
                return i;
            }
        }
        return -1;
    }

    // поиск по элементу рекурсию (тут есть ошибка, выдает 1, так как постоянно идет деление массива)
    private static Integer fastFindElement(Integer[] input, int element) {
        System.out.println("Fast find");
        int middle = input.length / 2;
        if (input[middle] > element) {
            return fastFindElement(Arrays.copyOf(input, middle), element);
        } else if (input[middle] == element) {
            return middle;
        } else {
            return fastFindElement(Arrays.copyOfRange(input, middle, input.length), element);
        }
    }

    // поиск по элементу рекурсию (тут есть ошибка, выдает 1, так как постоянно идет деление массива)
    private static Integer fastFindElementTwo(Integer[] input, int element) {
        int low = 0;
        int high = input.length - 1;
        int mid;
        while (low < high){
            mid = (low + high) / 2;
            System.out.println("Fast find 2");
            if (element == input[mid]){
                return mid;
            } else {
                if (element < input[mid]){
                        high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}