public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Нельзя создавать массив больше или меньше размера 4х4");
    }
}
