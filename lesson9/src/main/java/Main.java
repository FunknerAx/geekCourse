import static java.lang.Integer.parseInt;

public class Main {
    public static String[][] array = new String[][]{{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};
    public static String[][] arrErr = new String[][]{{"1","1"},{"1","1"},{"1","1"},{"1"}};
    public static String[][] arrErrSum = new String[][]{{"1","1","1","1"},{"1","1","asd","1"},{"1","1","1","1"},{"1","a","1","1"}};

    public static void main(String[] args) {

        try {
            checkArr(arrErr);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage()+"\n");
        }

        try {
            checkArr(array);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage()+"\n");
        }

        try {
            sum(array);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage()+"\n");
        }

        try {
            sum(arrErrSum);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage()+"\n");
        }
    }

    private static void checkArr(String[][] arr) throws MyArraySizeException {
        if( arr.length != 4 || arr[0].length != 4) throw new MyArraySizeException();
        System.out.println("Массив валиден\n");
    }

    private static void sum(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try{
                    sum += parseInt(array[i][j]);
                } catch ( NumberFormatException e ){
                    throw new MyArrayDataException(i,j,array[i][j]);
                }
            }
        }

        System.out.printf("Сумма элементов массива = %d\n", sum);
    }
}
