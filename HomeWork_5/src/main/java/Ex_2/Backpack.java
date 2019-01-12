package Ex_2;

import java.util.ArrayList;
import java.util.List;

class Backpack {

    private List<Item> bestItems = null;
    private double maxW;
    private double bestPrice;

    public Backpack(double maxW) {
        this.maxW = maxW;
    }


    //вычисляет общий вес набора предметов
    private double CalcWeight(List<Item> items) {
        double sumW = 0;
        for (Item i : items) {
            sumW += i.weight;
        }
        return sumW;
    }

    //вычисляет общую стоимость набора предметов
    private double CalcPrice(List<Item> items) {
        double sumPrice = 0;
        for (Item i : items) {
            sumPrice += i.price;
        }
        return sumPrice;
    }

    //проверка, является ли данный набор лучшим решением задачи
    private void CheckSet(List<Item> items) {
        if (bestItems == null) {
            if (CalcWeight(items) <= maxW) {
                bestItems = items;
                bestPrice = CalcPrice(items);
            }
        } else {
            if(CalcWeight(items) <= maxW && CalcPrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = CalcPrice(items);
            }
        }
    }

    //создание всех наборов перестановок значений
    public void MakeAllSets(List<Item> items) {
        if (items.size() > 0)
            CheckSet(items);

        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<Item>(items);
            newSet.remove(i);
            MakeAllSets(newSet);
        }
    }

    //возвращает решение задачи (набор предметов)
    public List<Item> GetBestSet() {
        ShowItems(bestItems);
        return bestItems;
    }

    private void ShowItems(List<Item> items) {
        List<String> contents = null;
        System.out.println("Backpack result: "+
                "\n maxW = " + maxW +
                ",\n bestPrice = " + bestPrice);
        for (Item i : items) {
            contents = new ArrayList<String>();
            contents.add(i.name);
            System.out.println(contents.toString());
        }
    }
}
