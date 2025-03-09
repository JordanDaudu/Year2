public class Animal extends Organism {

    Animal(boolean isAlive) {
        super(isAlive);
    }
    void eat(){
        System.out.println("Eating...");
    }
    void speak() {
        System.out.println("Animal is speaking...");
    }
}
