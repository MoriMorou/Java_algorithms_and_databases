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
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.person.id != id) {
            parent = current;
            if (id < current.person.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        // удаляет если нет потомков
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        // удаляет если нет правого потомка
        } else if (current.rightChild == null) {
            if (current == root){
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        // удаляет если нет левого потомка
        } else if(current.leftChild == null ) {
            if (current == root){
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccesor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    Node getSuccesor (Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
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

    // last будет хранить последний существующий child
    Node isMin() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current= current.leftChild;
        }
        return last;
    }

    Node isMax() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current= current.rightChild;
        }
        return last;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(Person.getNewPerson("Mark", 30, 3));
        tree.insert(Person.getNewPerson("Lera", 33, 5));
        tree.insert(Person.getNewPerson("Olga", 36, 1));
        tree.insert(Person.getNewPerson("Givi", 39, 4));
        tree.insert(Person.getNewPerson("SSSS", 44, 2));
        tree.insert(Person.getNewPerson("MMMM", 55, 6));
        tree.insert(Person.getNewPerson("LLLL", 30, 8));
        tree.insert(Person.getNewPerson("LKKJ", 30, 7));
        tree.displayTree();
        System.out.println("The min is " + tree.isMin());
        System.out.println("The max is " + tree.isMax());
        tree.delete(5);
        tree.displayTree();
        System.out.println("The min is " + tree.isMin());
        System.out.println("The max is " + tree.isMax());
        tree.delete(8);
        tree.displayTree();
        System.out.println("The min is " + tree.isMin());
        System.out.println("The max is " + tree.isMax());
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