package HomeWork.TwoLikedList;

public class ListApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert("Lena", 22);
        list.insert("Mikko", 90);
        list.insert("Sona", 5);
        list.insertLast("Roma", 77);
        System.out.println("Print of the list");
        list.display();
        System.out.println();
        System.out.println("Remove Mikko");
        list.delete("Mikko");
        list.display();
        System.out.println();
        System.out.println("Remove");
        list.delete();
        list.display();
    }
}
