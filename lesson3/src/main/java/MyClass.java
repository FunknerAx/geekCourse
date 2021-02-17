import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class MyClass {
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static char[] answer = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
    static String checkWord;
    static int countMoves = 0;
    static boolean isWin = false;

    public static void main(String[] args) throws IOException {

        getRandomWordFromArray();
        welcome();
        startGame();
        endGame();
    }

    public static void getRandomWordFromArray(){
        checkWord = words[(int) (Math.random() * words.length)];
    }

    public static void welcome() {
        System.out.println("Hey you\nI have the word for you\n");
        System.out.println("Try to guess the name of a fruit or vegetable\n");
    }

    public static void startGame() throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        while ( !isWin ) {
            System.out.print("=>");
            checkAnswer(reader.readLine().toLowerCase(Locale.ROOT));

            if( isWin ){
                System.out.printf("Congratulation\nYou guessed right in %d moves", countMoves);
            } else {
                System.out.printf("You answer is: %s\n", new String(answer));
                countMoves++;
            }

        }
    }

    public static void checkAnswer(String word) {
        if( word.equals(checkWord) ){
            isWin = true;
        } else {
            checkChars(word);
        }
    }

    public static void checkChars(String word){
        for( int i = 0; i<word.length() && i<checkWord.length(); i++){
            if(word.charAt(i) == checkWord.charAt(i)){
                answer[i] = word.charAt(i);
            }
        }
    }

    public static void endGame(){
        System.out.printf("Congratulation\nYou guessed right in %d moves", countMoves);
    }
}
