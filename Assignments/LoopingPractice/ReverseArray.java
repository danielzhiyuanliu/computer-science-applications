public class ReverseArray {
    public static void main(String args[]) {
        int[] numberList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int firstPos = 0;
        int firstValue = numberList[firstPos];

        int lastPos = numberList.length - 1;
        int lastValue = numberList[lastPos];

        for (int i = 0; i < numberList.length; i++) {
            if (i <= numberList.length / 2) {
                numberList[firstPos] = lastValue;
                numberList[lastPos] = firstValue;

                firstPos++;
                lastPos--;
                
                firstValue = numberList[firstPos];
                lastValue = numberList[lastPos];
            }
        }

        for (int k = 0; k < numberList.length; k++) {
            System.out.println(numberList[k]);
        }
    }
}
