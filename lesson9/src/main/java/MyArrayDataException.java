public class MyArrayDataException extends Exception{
    public MyArrayDataException(int i, int j, String val) {
        super("В строке " + i+1 + " столбце " + j+1 + " не лежит не циферное значение = " + val);
    }
}
