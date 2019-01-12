package Ex_2;

// все ставлю public, не хочу писать гетеры и сеттеры

class Item {

    public double price;
    public double weight;
    public String name;

    public Item(double price, double weight, String name) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
