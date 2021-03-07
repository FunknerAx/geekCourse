public class Main {

    public static void main(String[] args) {

        Plate plate = new Plate(10);
        Cat[] cats = {new Cat("Kasper",17), new Cat("Mark",5), new Cat("Jack",21),new Cat("Robbie",38),
                      new Cat("Jon",4), new Cat("Karl",88), new Cat("Ini",2),new Cat("Lucky",29)};

        plate.info();

        for ( Cat cur : cats ) {
            cur.tryEat(plate);
            plate.increaseFood((int) (Math.random() * 20) + 1 );
        }

        for ( Cat cur: cats ) {
            cur.info();
        }

        plate.info();
    }
}
