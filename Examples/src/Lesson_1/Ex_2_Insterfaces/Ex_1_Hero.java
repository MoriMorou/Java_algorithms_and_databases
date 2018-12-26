package Lesson_1.Ex_2_Insterfaces;

public class Ex_1_Hero {

    public static void main(String[] args) {

    }
}
class ElfHero extends Hero {

    @Override
    public void attack() {
        this.damage = damage;
    }

    @Override
    public void move() {
        this.health = health;
    }
}
