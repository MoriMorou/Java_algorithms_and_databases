package HomeWork.LinkedList;

public class Link {

    private String name;
    private int age;

    public Link next;

    public Link(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name " + this.name + ", age " + this.age);
    }
}
