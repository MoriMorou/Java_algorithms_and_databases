package Lesson_5_Recursion.Ex_1;//package Lesson_5_Recursion.Ex_1;
//
//import java.util.Random;
//
//public class Main {
//
//    void findMatreshka() {
//        Matreshka matreshka = new Matreshka(true);
//        Matreshka nowMatreshka = matreshka;
//        while (nowMatreshka.hasMatreshkaInside()) {
//            nowMatreshka = nowMatreshka.matreshka();
//            System.out.println("go");
//        }
//        System.out.println("Matreshka found");
//    }
//
//    public static void main(String[] args) {
//        Main main = new Main();
//        main.findMatreshka();
//
//    }
//}
//
//class Matreshka{
//    private  Matreshka matreshka;
//
//    Matreshka(boolean hasMatreshkaInside) {
//        if (hasMatreshkaInside) {
//            Random random = new Random();
//            matreshka = new Matreshka(random.nextBoolean());
//
//        }
//    }
//}
