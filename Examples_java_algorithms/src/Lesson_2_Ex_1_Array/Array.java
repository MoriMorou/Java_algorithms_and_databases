package Lesson_2_Ex_1_Array;


import java.util.Arrays;
import java.util.Random;


public class Array {

    public static void main(String[] args) {
        // создание массива
        int[] array = new int[10];

        Integer[] arrayInt = new Integer[10];
        // заполнение массива
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = i * 2;
        }

//        part1(arrayInt);

        // создаем массив и делаем элементы рамдомными
        Integer[] arrayIntRan = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < arrayIntRan.length ; i++) {
            arrayIntRan[i] = random.nextInt(100);
        }

        // запускаем копии массивов
        testBubble(Arrays.copyOf(arrayIntRan, arrayIntRan.length));
        testSelect(Arrays.copyOf(arrayIntRan, arrayIntRan.length));
        testInsert(Arrays.copyOf(arrayIntRan, arrayIntRan.length));
    }

    // общий метод для отражения данных
    private static void part1(Integer[] arrayInt) {
        System.out.println(Arrays.deepToString(arrayInt));
        arrayInt = addToArray(arrayInt, 4, 80);
        System.out.println(Arrays.deepToString(arrayInt));
        arrayInt = removeToArray(arrayInt, 80);
        System.out.println(Arrays.deepToString(arrayInt));
        int index = findElement(arrayInt, 12);
        System.out.println(index);
        int index2 = fastFindElement(arrayInt, 12);
        System.out.println("Found index = "+ index2);
        int index3 = binaryFind(arrayInt, 12);
        System.out.println("Found index = "+ index3);
    }

    private static void testBubble(Integer[] arrayIntRan) {
        System.out.println(Arrays.deepToString(arrayIntRan));
        long startS = System.currentTimeMillis();
        arrayIntRan = sortBubble(arrayIntRan);
        long endS = System.currentTimeMillis() - startS;
        System.out.println(Arrays.deepToString(arrayIntRan));
        System.out.println("The time of select sort is " + endS + " ms");
    }

    private static void testSelect(Integer[] arrayIntRan) {
        System.out.println(Arrays.deepToString(arrayIntRan));
        long startS = System.currentTimeMillis();
        arrayIntRan = selectSort(arrayIntRan);
        long endS = System.currentTimeMillis() - startS;
        System.out.println(Arrays.deepToString(arrayIntRan));
        System.out.println("The time of select sort is " + endS + " ms");
    }

    private static void testInsert(Integer[] arrayIntRan) {
        System.out.println(Arrays.deepToString(arrayIntRan));
        long startS = System.currentTimeMillis();
        arrayIntRan = insertSort(arrayIntRan);
        long endS = System.currentTimeMillis() - startS;
        System.out.println(Arrays.deepToString(arrayIntRan));
        System.out.println("The time of insert sort is " + endS + " ms");
    }

    // вставляем элемент
    private static Integer[] addToArray(Integer[] input, int index, int element) {
        Integer[] output = new Integer[input.length + 1]; // создаем новый массив размером больше на одну ячейку
        for (int i = 0; i <= input.length; i++) { // заполняем массив
            if (i < index){                        // если i меньше нужного нам элемента, то копируем массив
                output[i] = input[i];
            } else if (i == index) {               // дошли до нужного i и вставляем новый элемент
                output[i] = element;
            } else {                               // дальше вставляем кусок массива
                output[i] = input[i-1];
            }
        }
        return output;
    }

    // удаление элемента
    private static Integer[] removeToArray(Integer[] input, int element) {
        Integer[] output = new Integer[input.length - 1];  // создаем массив на один элемент меньше
        int index = -1;
        for (int j = 0; j < input.length; j++) {  // сначала ищем элемент, который хотим удалить
            if(input[j] == element) {
                index = j;                        // когда нашли элемент приравниваем его к переменной
                break;
            }
        }
        if (index == -1){
            throw new IllegalArgumentException("Element is not found");
        }
        for (int i = 0; i < output.length; i++) { // при копировании массива пропускаем элемент, который нашли ранее
            if(i < index){
                output[i] = input[i];
            } else {
                output[i] = input[i + 1];
            }
        }
        return output;
    }

    // поиск по элементу (линейный поиск)
    private static Integer findElement(Integer[] input, int element){
        int j = 1; // номер попытки
        for (int i = 0; i < input.length; i++, j++) {
            System.out.println("Try number " + j);
            if(element == input[i]) {
                return i;
            }
        }
        return -1;
    }

    // поиск по элементу рекурсия (тут есть ошибка, выдает 1, так как постоянно идет деление массива)
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

    // поиск бинарный
    private static Integer binaryFind(Integer[] input, int element) {
        int low = 0;
        int high = input.length - 1;  // input.length - 1 так как нам нужен индекс, а не длина массива
        int mid;
        while (low < high){
            mid = (low + high) / 2;   // получаем номер элемента по средине
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

    // сортировка в пузырьковом стиле
    private static Integer[] sortBubble(Integer[] arrayIntRan) {
        int out, in;
        // out = arrayIntRan.length - 1 - то есть out приравниваем к последнему элементу массива
        for (out = arrayIntRan.length - 1; out >= 1; out--) { // то есть самый правый элемент
            for (in = 0; in < out; in++) {                    // самый левый элемент
                if (arrayIntRan[in] > arrayIntRan[in + 1]) {
                    change(arrayIntRan, in, in+1);
                }
            }
        }
        return arrayIntRan;
    }

    // сортировка методом выбора
    private static Integer[] selectSort(Integer[] arrayIntRan) {
        int out, in, mark;  // out  - это вврехний индекс
        for (out = 0; out < arrayIntRan.length; out++) {
            mark = out;
            for (in = out + 1; in < arrayIntRan.length; in++) {
                if (arrayIntRan[in] < arrayIntRan[mark]) {
                    mark = in;
                }
            }
            change(arrayIntRan, out, mark);
        }
        return arrayIntRan;
    }

    private static void change(Integer[] arrayIntRan, int a, int b) {
        Integer tmp = arrayIntRan[a]; // временный массив
        arrayIntRan[a] = arrayIntRan[b];
        arrayIntRan[b] = tmp;
    }

    // сортировка методом вставки
    private static Integer[] insertSort(Integer[] arrayIntRan) {
        int in, out;
        for (out = 1; out < arrayIntRan.length; out++) {
            int temp = arrayIntRan[out]; // временный эллемент
            in = out;
            while (in > 0 && arrayIntRan[in - 1] >= temp) {
                arrayIntRan[in] = arrayIntRan[in-1];
                --in;
            }
            arrayIntRan[in] = temp;
        }
        return arrayIntRan;
    }
}