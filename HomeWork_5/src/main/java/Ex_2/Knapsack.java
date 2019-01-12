package Ex_2;

import java.util.*;

/**
 * containsKey(Object key) — проверяет, существует ли в массиве элемент с ключом key;
 * get(Object key) — возвращает значение, соответствующее ключу key;
 */


public class Knapsack {

    private static final List<Item> ITEMS = new ArrayList<Item>();
    private static double capacity;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ITEMS.add(new Item(15000.0, 4.0, "Tent"));
        ITEMS.add(new Item(7000, 2.2, "Dishes"));
        ITEMS.add(new Item(1000, 1.4, "Book"));
        ITEMS.add(new Item(150000, 3.3, "Laptop"));
        ITEMS.add(new Item(1200, 1, "Food"));

        System.out.println("Input Capacity of the knapsack ");
        capacity = in.nextDouble();
        Backpack bp = new Backpack(capacity);
        bp.MakeAllSets(ITEMS);

        List<Item> solve = bp.GetBestSet();

        if(solve == null) {
            System.out.println("Нет решения!");
        } else {
            System.out.println(solve);
        }


    }
}
