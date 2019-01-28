package Lesson_5_Recursion.Ex_2;

public class HelloBye {

    public static void main(String[] args) {
        hello("Artem");
    }

    public static void hello(String name) {
        System.out.println("Hello, " + name);
        bye(name);
    }

    private static void bye(String name){
        System.out.println("Bye, " + name);
    }

}
