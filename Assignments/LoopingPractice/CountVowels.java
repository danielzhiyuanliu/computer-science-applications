public class CountVowels {
    public static void main(String args[]) {
        String myWord = "racecar";
        String[] vowelList = {"a", "e", "i", "o", "u"};
        String currentLetter;
        int vowelCount = 0;

        for (int i = 0; i < myWord.length(); i++) {
            currentLetter = myWord.substring(i, i + 1);
            
            for (int k = 0; k < vowelList.length; k++) {
                if (currentLetter.equals(vowelList[k])) {
                    vowelCount++;
                }
            }
        }

        System.out.println(vowelCount);
    }
}