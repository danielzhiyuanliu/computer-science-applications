public class SumAverage {
    public static void main(String args[]) {
        int[] numberList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int sumNum = 0;
        
        int listCount = 0;

        for (int i = 0; i < numberList.length; i++) {
            sumNum += numberList[i];
            listCount++;
        }

        System.out.println("Sum: " + sumNum);
        System.out.println("Average: " + sumNum/listCount);
    }
}