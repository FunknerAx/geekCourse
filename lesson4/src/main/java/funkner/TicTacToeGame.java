package funkner;

import java.util.Scanner;

/***
 * @author FunknerAlexandr;
 * @date 2021-02-20
 */

public class TicTacToeGame {
    public static int gameMode;
    public static Scanner in = new Scanner(System.in);
    public static int size = 4;
    public static int winSize = 3;
    public static int winCountPosition = 4;
    public static String areaSpace = " ";
    public static char firstChar = '#';
    public static final char EMPTY = '.';
    public static char[][] gameArea;
    public static final char PLAYER_ONE = 'x';
    public static final char PLAYER_TWO = 'o';
    public static boolean isWin = false;
    public static int movesCount = 0;
    public static char currentChar = PLAYER_ONE;


    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {

        prepareGame();

        while( !isWin ) {
            System.out.printf("movesCount = %d, count limit = %d\n",movesCount,size*size);
            game();
            if( !(movesCount < size*size) ){
                System.out.println("Limit range of moves count");
                break;
            }
        }
    }

    private static void prepareGame() {
        //        chooseMode();
        chooseSizeOfArea(size);
        fillArea(size);
        printArea();
    }

    private static void chooseMode() {
        System.out.println("Please choose mode \nPlayer vs Player - 1\nPlayer vs Computer - 2");
        gameMode = setMode();
    }

    private static int setMode() {
        int mode = 0;

        do {
            System.out.println("You should choose 1 or 2");
            if (in.hasNextInt())
                mode = in.nextInt();
            in.nextLine();
        } while (!(mode == 1 || mode == 2));

        return mode;
    }

    private static void chooseSizeOfArea(int lenght) {
        gameArea = new char[lenght][lenght];
    }

    private static void fillArea(int size) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                gameArea[i][j] = EMPTY;
    }

    private static void printArea() {

        printHeader();
        printBody();

    }

    private static void printBody() {
        for (int i = 0; i < size; i++){
            System.out.print( i+1 + areaSpace );

            for (int j = 0; j < size; j++){
                System.out.print( gameArea[i][j] + areaSpace );
            }

            System.out.println();
        }
    }

    private static void printHeader() {
        System.out.print( firstChar + areaSpace);

        for(int i = 1; i <=size; i++)
            System.out.print( i + areaSpace);

        System.out.println();
    }

    private static void game() {
        //ходит игрок
        makeMove(currentChar);
        printArea();
        checkWin(currentChar);
        changePlayer();
    }

    private static void makeMove(char playerChar) {
        int x = -1,y = -1;

        do {
            System.out.println("column->");
            y = in.nextInt();
            if( !isRightAreaSize(y) ){
                System.out.printf("column range between 1 and %d\n",size);
                continue;
            }

            System.out.println("row->");
            x = in.nextInt();
            if( !isRightAreaSize(x) ){
                System.out.printf("raw range between 1 and %d\n",size);
                continue;
            }
        } while( (x > size || x < 0 || y > size || y < 0) || !isCellEmpty(x,y));

        gameArea[x-1][y-1] = playerChar;
        ++movesCount;
    }

    private static boolean isRightAreaSize(int cell) {
        if( cell > size || cell < 0){
            return false;
        } else {
            return true;
        }
    }

    private static boolean isCellEmpty(int x, int y) {
        if( gameArea[x-1][y-1] == EMPTY ){
            return true;
        } else {
            System.out.printf("cell with row %d and column %d is not empty",x,y);
            return false;
        }
    }

    private static void changePlayer() {
        if(currentChar == PLAYER_ONE){
            currentChar = PLAYER_TWO;
        } else {
            currentChar = PLAYER_ONE;
        }
    }

    private static void checkWin(char isWinChar) {
        int[] winsPosition = new int[winCountPosition];

        checkHorizontal(isWinChar);
        checkVertical(isWinChar);
        checkDiagonal(isWinChar);
        checkCountWinPossition(winsPosition, isWinChar);

    }

    private static void checkHorizontal(char isWinChar) {
        int isWinCount = 0;

        for(int i = 0; i <size; i++){
            for(int j = 0; j < size; j++){
                if(gameArea[i][j] == isWinChar) {
                    isWinCount++;
                } else {
                    isWinCount--;
                }
            }

            if(isWinCount == winSize){
                isWin = true;
                break;
            } else {
                isWinCount = 0;
            }
        }
    }

    private static void checkVertical(char isWinChar) {
        int isWinCount = 0;

        for(int i = 0; i <size; i++){
            for(int j = 0; j < size; j++){
                if(gameArea[j][i] == isWinChar)
                    isWinCount++;
            }

            if(isWinCount == winSize){
                isWin = true;
                break;
            } else {
                isWinCount = 0;
            }
        }
    }

    private static void checkDiagonal(char isWinChar) {
        int isWinDiagonalCount = 0,
            isWinReverseDiagonalCount = 0;

        for(int i = 0; i <size; i++){
                if(gameArea[i][i] == isWinChar)
                    isWinDiagonalCount++;

                if(gameArea[i][size - 1 - i] == isWinChar)
                    isWinReverseDiagonalCount++;

            if(isWinReverseDiagonalCount == winSize || isWinDiagonalCount == winSize){
                isWin = true;
                break;
            }
        }
    }

    private static void countWinPosition(int[] winsPosition, char isWinChar) {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if( gameArea[i][j] == isWinChar && i == j ){
                    winsPosition[0] += 1;

                } else if( gameArea[i][j] == isWinChar ){
                    winsPosition[1] += 1;

                } else if( gameArea[j][i] == isWinChar ){
                    winsPosition[2] += 1;

                } else if( gameArea[i][size - 1 -i] == isWinChar){
                    winsPosition[3] += 1;
                }
            }
            if(winsPosition[1] != winSize)
                winsPosition[1] = 0;
        }
    }

    private static void checkCountWinPossition(int[] winsPosition, char isWinChar) {

        for( int i = 0; i < winsPosition.length; i++){
            if(winsPosition[i] == winSize)
                isWin = true;
        }

        if(isWin) {
            if(isWinChar == PLAYER_ONE){
                System.out.println("Player one is win");
            } else {
                System.out.println("Player two is win");
            }
        }
    }

}
