public class Cat  extends Animal{
    private final int RUN_DISTANCE = 200;
    private static int catsCount;

    public Cat(String name) {
        super(name);
        catsCount++;
    }

    @Override
    public void run(int distance) {
        if(distance < this.RUN_DISTANCE){
            System.out.printf("%s ran %d meters\n", this.getName(), distance);
        } else {
            System.out.printf("Run distance = %d. %s does`nt want to run further than %d meters\n" ,distance, this.getName(), RUN_DISTANCE);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s does not want to swim\n", this.getName());
    }

    public static int returnCount(){ return Cat.catsCount; }
}
