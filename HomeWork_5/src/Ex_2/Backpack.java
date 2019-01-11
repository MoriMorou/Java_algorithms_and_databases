package Ex_2;

import java.util.List;

public class Backpack {

    private List<Item> bestItems = null;
    private double maxW;
    private double bestPrice;

    public Backpack(double maxW){
        this.maxW = maxW;
    }

    //вычисляет общий вес набора предметов
    private double CalcWeigth(List<Item> items) {
        double sumW = 0;

        for (Item i:items){
           sumW += i.weigth;
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
            if (CalcWeigth(items) <= maxW) {
                bestItems = items;
                bestPrice = CalcPrice(items);
            }
        } else {
            if(CalcWeigth(items) <= maxW && CalcPrice(items) > bestPrice) {
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

            List<Item> newSet = new List<Item>(items) {

                @Override
                public Item remove(int index) {
                    return null;
                }
            };

            newSet.remove(i);
            MakeAllSets(newSet);
        }
    }

    //возвращает решение задачи (набор предметов)
    public List<Item> GetBestSet() {
        return bestItems;
    }
}
