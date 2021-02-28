public abstract class Animal {
    private String name;
    private static int animalCount;

    public Animal(String name){
        this.name = name;
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int returnCount() {
        return Animal.animalCount;
    }
}
