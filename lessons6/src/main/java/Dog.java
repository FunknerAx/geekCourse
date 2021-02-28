public class Dog extends Animal {
    private final int RUN_DISTANCE = 500;
    private final int SWIM_DISTANCE = 10;
    private static int dogsCount;

    public Dog(String name) {
        super(name);
        dogsCount++;
    }

    @Override
    public void run(int distance) {
        if(distance < RUN_DISTANCE){
            System.out.printf("%s ran %d meters\n", this.getName(), distance);
        } else {
            System.out.printf("Run distance = %d. %s ran only %d meters and stopped to rest\n", distance, this.getName(), RUN_DISTANCE);
        }
    }

    @Override
    public void swim(int distance) {
        if(distance < this.SWIM_DISTANCE){
            System.out.printf("%s swim %d meter\n", this.getName(), distance);
        } else {
            System.out.printf("Swim distance = %d. %s swam only %d meters and began to sink\n",distance, this.getName(), SWIM_DISTANCE);
            System.out.printf("But human saves the %s\n", this.getName());
        }
    }

    public static int returnCount() {
        return Dog.dogsCount;
    }
}
