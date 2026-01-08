public class LargestNumber {
    public static void main(String args[]) {
        int[] numberList = {2, 3, 1, 4, 5, 6, 10, 8, 9, 7};
        
        int largeValue = 0;
        int largePos = 0;
        
        int lastValue = numberList[numberList.length - 1];

        for (int i = 0; i < numberList.length; i++) {
            if (largeValue < numberList[i]) {
                largeValue = numberList[i];
                largePos = i;
            }
        }
        
        numberList[numberList.length - 1] = largeValue;
        numberList[largePos] = lastValue;

        for (int k = 0; k < numberList.length; k++) {
            System.out.println(numberList[k]);
        }

    }
}
