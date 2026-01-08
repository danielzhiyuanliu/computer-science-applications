public class EvenNumbers {
    public static void main(String args[]) {
        int[] numberList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < numberList.length; i++) {
            if ((numberList[i] % 2) == 0) {
                numberList[i] = numberList[i] + 1;
            } 
        }

        for (int k = 0; k < numberList.length; k++) {
            System.out.println(numberList[k]);
        }
    }
}