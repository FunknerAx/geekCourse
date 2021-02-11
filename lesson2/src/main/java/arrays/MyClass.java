package arrays;

public class MyClass {
    static int[] arrayFirst = {0,0,1,1,0,1,0,0,1,0,1};
    static int[] arraySecond = new int[8];
    static int[] arrayThird = {1,5,3,2,11,4,5,2,4,8,9,1};
    static int[][] arrayFourth = new int[6][6];
    static int[] arrayFifth = {3,5,7,8,24,5,8,9,4,2,6,7};
    static int[] arraySeventh = {0,1,2,3,4,5,6};

    public static void main(String[] args) {
        //1
        showArray(arrayFirst);
        changeArrayValues(arrayFirst);
        showArray(arrayFirst);
        System.out.println();

        //2
        arraySecondFill(arraySecond);
        showArray(arraySecond);
        System.out.println();

        //3
        showArray(arrayThird);
        arrayThirdChange(arrayThird);
        showArray(arrayThird);
        System.out.println();

        //4
        showArray(arrayFourth);
        arrayFourthDiagonalFill(arrayFourth);
        showArray(arrayFourth);
        System.out.println();

        //5
        printMinMax(arrayFifth);
        System.out.println();

        //6
        System.out.println(checkSumLeftRight(new int[]{1,1,1,2,1}));
        System.out.println(checkSumLeftRight(new int[]{1,1,2,2,1}));
        System.out.println();

          //7
        showArray(arraySeventh);
        arrayShift(arraySeventh,2);
        showArray(arraySeventh);
        arrayShift(arraySeventh,-2);
        showArray(arraySeventh);
    }

    public static void showArray(int[] array){
        for (int cur:array) {
            System.out.print(cur+";");
        }
        System.out.println();
    }
    public static void showArray(int[][] array){
        for( int i = 0; i<array.length; i++){
            for( int j = 0; j< array[i].length; j++){
                System.out.print( array[i][j] );
            }
            System.out.println();
        }
        System.out.println();
    }

    //1
    public static void changeArrayValues(int[] array){
        for(int i = 0 ; i< array.length; i++){

            if(array[i] == 0) {
                array[i] = 1;
                continue;

            } else if(array[i] == 1) {
                array[i] = 0;
                continue;
            }
        }
    }

    //2
    public static void arraySecondFill(int[] array){
        for(int i = 0; i<array.length; i++){
            array[i] = i*3;
        }
    }

    //3
    public static void arrayThirdChange(int[] array){
        for(int i = 0; i< array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
    }

    //4
    public static void  arrayFourthDiagonalFill(int[][] array){
        for( int i = 0; i<array.length; i++){
            for( int j = 0; j< array[i].length; j++){
                if( i == j)
                    array[i][j] = 1;
                if( array.length-i == j+1 )
                    array[i][j] = 1;
            }
        }
    }

    //5
    public static void printMinMax(int[] array){
        int min = array[0],
            max = array[0];

        for ( int cur: array ) {
            if( cur < min )
                min = cur;
            if( cur > max)
                max = cur;
        }

        System.out.printf("Минимальное значение = %d \nМаксимальное значение = %d",min,max);
    }

    //6
    public static boolean checkSumLeftRight(int[] array){
        int leftPosition = 0;
        int rightPosition = array.length-1;
        int leftSum = array[leftPosition];
        int rightSum = array[rightPosition];

        for( int i = 1; i<array.length-1; i++){
            if( leftSum > rightSum ){
                rightSum += array[--rightPosition];
                continue;
            } else {
                leftSum+= array[++leftPosition];
            }
        }

        return checkSum(leftSum,rightSum);

    }

    public static boolean checkSum(int leftSum, int rightSum){
        return leftSum == rightSum;
    }

    //7
    public static void arrayShift(int[] array, int position){
        int temp;
        int firstTemp;

        if(position>0){
            for (int i = 0; i < Math.abs(position); i++){

                firstTemp = array[array.length-1];
                for( int j = array.length-1; j >= 0; j-- ){
                    if( j != 0 ){
                        temp = array[j-1];
                        array[j] = temp;
                    } else{
                        array[j] = firstTemp;
                    }
                }
            }
        } else {
            for (int i = 0; i < Math.abs(position); i++){

                firstTemp = array[0];
                for( int j = 0; j < array.length; j++ ){
                    if( j != array.length-1 ){
                        temp = array[j+1];
                        array[j] = temp;
                    } else{
                        array[j] = firstTemp;
                    }
                }
            }
        }
    }
}