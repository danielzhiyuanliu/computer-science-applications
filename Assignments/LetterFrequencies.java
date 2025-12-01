public class LetterFrequencies
{
    public static void main(String[] args)
    {

        String letters = "abcdefghijklmnopqrstuvwxyz"; 
        String phrase = "This is a phrase!";

        System.out.println("Letter frequencies in '" + phrase + "'");

        for (int i = 0; i < letters.length(); i++) {
            String currentLetter = letters.substring(i, i + 1);
            int letterCount = 0;

            for (int j = 0; j < phrase.length(); j++) {
                String phraseLetter = phrase.toLowerCase().substring(j, j + 1);
                
                if (phraseLetter.equals(currentLetter)) {
                    letterCount++;
                }
            }

            System.out.println(currentLetter + ": " + letterCount);
        }
    }
}