public class RemoveDuplicates {
    public static void main(String args[]) {
        String[] stringList = {"dog", "bat", "sheep", "panda", "panda", "dog", "cat", "panda"};

        for (int i = 0; i < stringList.length; i++) { // loops to check every value in list
            for (int j = i + 1; j < stringList.length - 1; j++) { // loops  to replace next value if match, +1 to not include current string, -1 to not go out of bounds
                if (stringList[j] == null) { // if null, then stop loop or else errors with .equals comparision string/null
                    break;
                }

                if (stringList[i].equals(stringList[j])) { //if current word equals a "word after it"
                    for (int k = j; k < stringList.length-1; k++) { // replaces "word after it" with the following words, moving it all up by one, -1 to not go out of bounds for last letter (k+1 on line 13)
                        stringList[k] = stringList[k + 1];
                    } 
                } stringList[stringList.length - 1] = null; // sets last index, duplicate of previous value, to null
            }
        }

        for (int k = 0; k < stringList.length; k++) { // loop to print out every value in list
            System.out.println(stringList[k]);
        }
    }
}
