import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        Human humanOne = new Human("David", 100, 40);
        Human humanTwo = new Human("Alex", 120, 30);
        Human humanThree = new Human("Kelvin", 60, 20);

        Cat catOne = new Cat("Jack",200,60);
        Cat catTwo = new Cat("Roy",250,80);
        Cat catThree = new Cat("Jack",300,90);

        Robot robotOne = new Robot("Drz-001",400,100);
        Robot robotTwo = new Robot("Drz-002",410,110);
        Robot robotThree = new Robot("Drz-003",420,120);

        Wall wallOne = new Wall(10);
        Wall wallTwo = new Wall(50);
        Wall wallThree = new Wall(120);

        RunTrack runTrackOne = new RunTrack(60);
        RunTrack runTrackTwo = new RunTrack(120);
        RunTrack runTrackThree  = new RunTrack(420);

        PersonAction[] person = {humanOne, humanTwo, humanThree, catOne, catThree, catTwo, robotOne, robotTwo, robotThree};
        Let[] lets = {wallOne, runTrackOne, wallTwo, runTrackTwo, wallThree, runTrackThree};


        for ( PersonAction cur: person ) {
            for (int i = 0; i < lets.length ; i++) {
                if(lets[i] instanceof Wall){
                    if(!cur.jump((Wall) lets[i])){
                        System.out.printf("%s can`t do else\n",cur.getName());
                        break;
                    }
                } else {
                    if(!cur.run((RunTrack) lets[i])) {
                        System.out.printf("%s can`t do else\n", cur.getName());
                        break;
                    }
                }
            }
            System.out.println();
        }

    }
}
