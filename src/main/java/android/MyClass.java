package android;

public class MyClass {

    public static void main(String[] Arg){

        System.out.println( calculate(1,1,4,2) );

        System.out.println( isBetween(10,5) );
        System.out.println( isBetween(10,11) );

        isPositiveNumber(10);
        isPositiveNumber(-10);

        System.out.println( isNegativeNumber(10) );
        System.out.println( isNegativeNumber(-10) );

        sayHi("Тимофей");

        getYear(5);
    }

    //2
    byte byteValue = 1;
    short shortVaule = 1;
    int intValue = 1;
    long longValue = 1;

    float floatValue = 1.0f;
    double doubleValue = 1.0;

    boolean booleanValue = true;

    char charValue = 'a';
    String stringValue = "a";

    //3
    public static double calculate(double a, double b, double c, double d){

        return a * (b + (c / d));
    }

    //4
    public static boolean isBetween(int a, int b){
        if( (a+b)>=10 && (a+b)<=20){
            return true;
        } else {
            return false;
        }
    }

    //5
    public static void isPositiveNumber(int a){
        if(a >= 0){
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    //6
    public static boolean isNegativeNumber(int a){
        if(0 > a){
            return true;
        } else {
            return false;
        }
    }

    //7
    public static void sayHi(String name){
        System.out.println("Привет, " + name);
    }

    //8
    public static void getYear(double year){
        String result = "Не високосный год";

        if( year%4 == 0 ) {
            result = "Високосный год";
            if (year % 100 == 0) {
                if (!(year % 400 == 0)) {
                    result = "Не високосный год";
                }
            }
        }

        System.out.println(result);
    }

}
