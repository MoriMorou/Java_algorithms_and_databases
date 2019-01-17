package Lesson_6_Tree;

public class Tree {

    private Node root;

    Node find(int id) {
        Node current = root;
        while (current.person.id != 0) {
//            if(id < current.person.id) {
//                current = current.leftChild;
//            } else {
//                current = current.rightChild;
//            }
            // упростили
            current = (id > current.person.id) ? current.leftChild : current.rightChild;

            if (current == null) {
                return null;
            }
        }
        return null;
    }

    void insert(Person person) {
        Node node = new Node();
        node.person = person;
        if (root == null){
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (person.id < current.person.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }

            }
        }
    }

    boolean delete (int id) {
        return false;
    }

    void displayTree(){
        inOrder(root);

    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.println(node);
            inOrder(node.rightChild);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(Person.getNewPerson("Mark", 30, 1));
        tree.insert(Person.getNewPerson("Lera", 33, 2));
        tree.insert(Person.getNewPerson("Olga", 36, 3));
        tree.insert(Person.getNewPerson("Givi", 39, 4));
        tree.insert(Person.getNewPerson("Mori", 30, 5));
        tree.displayTree();

    }
}

// узел
class Node {

    Person person;
    Node leftChild;
    Node rightChild;

    @Override
    public String toString() {
        return person.id + " " + person.name + " " + person.age;
    }
}

class Person {

    String name;
    int age;
    int id;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    static Person getNewPerson(){
        return new Person("test", 99, 1);
    }

    static Person getNewPerson(String name, int age, int id){
        return new Person(name, age, id);
    }

}