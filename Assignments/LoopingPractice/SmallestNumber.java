public class SmallestNumber {
    public static void main(String args[]) {
        int[] numberList = {2, 3, 1, 4, 5, 6, 7, 8, 9, 10};
        
        int smallValue = numberList[0];
        int smallPos = 0;
        
        int firstValue = 0;
        firstValue = numberList[0];

        for (int i = 0; i < numberList.length; i++) {
            if (smallValue > numberList[i]) {
                smallValue = numberList[i];
                smallPos = i;
            }
        }
        
        numberList[0] = smallValue;
        numberList[smallPos] = firstValue;

        
        for (int k = 0; k < numberList.length; k++) {
            System.out.println(numberList[k]);
        }

    }
}
