public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Kandy");
        Cat cat2 = new Cat("Grab");

        Dog dog1 = new Dog("Bobby");
        Dog dog2 = new Dog("Gun");
        Dog dog3 = new Dog("Greg");

        Animal[] animals = {cat1, dog1, cat2, dog2, dog3};

        for (Animal cur: animals) {
            cur.run( (int) (Math.random() * 1000) );
            cur.swim( (int) (Math.random() * 20) );
            System.out.println();
        }

        System.out.printf("Animals count: %d\nDogs count: %d\nCats count: %d\n",Animal.returnCount(),Cat.returnCount(),Dog.returnCount());
    }
}
