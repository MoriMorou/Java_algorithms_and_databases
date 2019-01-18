
// 1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать деревьев с глубиной в
// 6 уровней. Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int. Число, которое
// попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
// 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.


import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Tree<Integer, Integer> assArr = new Tree<>();

        int tmp;
        for (int i = 0; i < 20; i++) {
            while (assArr.heightOfBinaryTree() < 6) {
                tmp = random.nextInt(200) - 100;
                assArr.put(tmp, 10);
                System.out.println(tmp);
            }
            System.out.println("Balance: " + assArr.isBalance());
            System.out.println();
            assArr = new Tree<>();
        }
    }
}
