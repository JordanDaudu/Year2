public class Dog extends Animal {

    int lives;

    Dog() {
        super(true);
        this.lives = 1;
    }

    Dog(boolean isAlive, int lives) {
        super(isAlive);
        this.lives = lives;
    }

    @Override
    void speak(){
        System.out.println("The dog goes *woof*");
    }
}
