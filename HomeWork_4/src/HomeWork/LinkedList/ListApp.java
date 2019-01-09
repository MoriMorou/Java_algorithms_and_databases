package HomeWork.LinkedList;

public class ListApp {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insert("Mikko", 21);
        list.insert("Mori", 90);
        list.insert("Sona", 35);

        list.display();
        System.out.println();
        if (!list.isEmpty()) list.delete();

        list.display();
    }
}
