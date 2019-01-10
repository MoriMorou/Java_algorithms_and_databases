package Simple_LinkedList;

public class SimpleList {

    public static void main(String[] args) {
        LinkedListOne linkedList = new LinkedListOne();
        User userOne = new User("Alex", 32);
        User userTwo = new User("Stepa", 33);
        User userThree = new User("Sona", 28);
        linkedList.insert(userOne);
        linkedList.print();
        linkedList.insert(userTwo);
        linkedList.print();
        linkedList.delete();
        linkedList.print();
        linkedList.insert(userThree);
        linkedList.print();
    }
}

class User {
    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// узел списка
class Node {
    User data;
    Node next;

    Node(User data){
        this.data = data;
        this.next = null;
    }
}

// класс Связанный список
class LinkedListOne {

    private Node head;

    public LinkedListOne(){
        head = null;
    }

    boolean isEmpty(){
        return head == null;
    }

    void insert(User data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    Node delete(){
        Node temp = head;
        head = head.next;
        return temp;
    }

    void print(){
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp!= null){
            stringBuilder.append(temp.data.toString()).append("\n");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());

    }
}