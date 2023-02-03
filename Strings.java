package cp213;
;
/**
 * @author Beheashta Atchekzai 190637520
 * @version 2021-09-11
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as "Able
     * was I ere I saw Elba") that reads the same backward or forward. Ignores case,
     * spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {

    	String sLower = string.toLowerCase();
        sLower = sLower.trim();
        boolean result = true;
        int leftSide = 0;
        int rightSide = sLower.length()-1;
        while (result && leftSide <= sLower.length()-1 && rightSide >= 0) {
        	if (Character.isLetter(sLower.charAt(leftSide)) != true || Character.isLetter(sLower.charAt(leftSide))) {
        		if (Character.isLetter(sLower.charAt(leftSide)) != true && leftSide < sLower.length()-1) {
        			while (Character.isLetter(sLower.charAt(leftSide)) != true && leftSide < sLower.length()-1) {
        				leftSide += 1;
        			}
        		}
        		if (Character.isLetter(sLower.charAt(rightSide)) != true) {
        			while (Character.isLetter(sLower.charAt(rightSide)) != true && rightSide > 0) {
        				rightSide -= 1;
        				
        		}
        	}
        	}
        	if (sLower.charAt(leftSide) != sLower.charAt(rightSide)) {
        		result = false;
        	}
        	leftSide += 1;
        	rightSide -= 1;
        	
        }
        return result;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {
    	boolean valid = true;
        if (name.length() == 1) {
        	if (Character.isLetter(name.charAt(0)) == false){
        		valid = false;
        	}
        }
        else {
        	if (Character.isLetter(name.charAt(0)) == true || name.charAt(0) == '_'){
        		for (int i = 0; i < name.length(); ++i) {
        			if (Character.isLetter(name.charAt(i)) == false && Character.isDigit(name.charAt(i)) == false && name.charAt(i) != '_') {
        				valid = false;
        			}
        		}
        	}
        	else {
        		valid = false;
        	}
        }
        return valid;
    }
    
    
    /**
     * Helper method 
     * Determines if character passed is a vowel or not by checking if it is in the list of vowels.
     *
     * @param character to be checked
     * @return true if character is a vowel, false otherwise
     */
    public static boolean isVowel(char c) {
    	
    	
    	String cc = Character.toString(c);
    
    	boolean result = VOWELS.contains(cc);
    	
    	return result;
    	
    }
    
    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    
    
    public static String pigLatin(String word) {

    	String lowerCaseWord = word.toLowerCase();
    	boolean capital = false;
    	
    	// check if word is capitilized at the beginning to capitalize it at the end.
    	if(Character.isUpperCase(word.charAt(0))) {
    		capital = true;
    	}
        int pos = -1; // Position of first vowel
        char ch;

        // This for loop finds the index of the first vowel in the word
        for (int i = 0; i < lowerCaseWord.length(); i++) {
            ch = lowerCaseWord.charAt(i);

            if (VOWELS.contains(Character.toString(ch))) {
                pos = i;
                break;
            }
        }

        if (pos == 0) {
            // Translating word if the first character is a vowel (Rule 3)
        	
        	// capitalizing answer
        	if(capital==true) {
        		lowerCaseWord = lowerCaseWord.substring(0, 1).toUpperCase() + lowerCaseWord.substring(1);
            } 
            return lowerCaseWord + "yay"; // Adding "yay" to the end of string (can also be "way" or just "ay")
            
        } else {
            // Translating word if the first character(s) are consonants (Rule 1 and 2)
            String a = lowerCaseWord.substring(pos); // Extracting all characters in the word beginning from the 1st vowel
            String b = lowerCaseWord.substring(0, pos); // Extracting all characters located before the first vowel
            
         // capitalizing answer
            if(capital==true) {
        		a = a.substring(0, 1).toUpperCase() + a.substring(1);
            }
            return a + b + "ay"; // Adding "ay" at the end of the extracted words after joining them.
        }
     
 
    }

}
