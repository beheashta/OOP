package cp213;

/**
 * @author Your name and id here
 * @version 2021-09-11
 */
public class Cipher {
    // Constants
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    /**
     * Encipher a string using a shift cipher. Each letter is replaced by a letter
     * 'n' letters to the right of the original. Thus for example, all shift values
     * evenly divisible by 26 (the length of the English alphabet) replace a letter
     * with itself. Non-letters are left unchanged.
     *
     * @param s string to encipher
     * @param n the number of letters to shift
     * @return the enciphered string
     */
    public static String shift(String s, int n) {
    	
    	// initialize variables
    	String str_to_encipher = s;
    	int shift_num = n;
    	String result = ""; // for returning
    	int endPoint; // endpoint of str
    	
        for (int i = 0; i < str_to_encipher.length(); ++i) {
        	
        	if (Character.isLetter(str_to_encipher.charAt(i))) {
        		
        		// create starting point for shift
	        	int startPoint = ALPHA.indexOf(Character.toUpperCase(str_to_encipher.charAt(i)));
	        	
	        	// adjust endpoint if shift goes past the end of the alphabet
	        	if ((startPoint + shift_num) >= ALPHA_LENGTH) {
	        		endPoint = shift_num - (ALPHA_LENGTH - startPoint);
	        	}
	        	
	        	// normal endpoint
	        	else {
	        		endPoint = startPoint + shift_num;
	        	}
	        	
	        	// shift character to endpoint
	        	result = result + Character.toString(ALPHA.charAt(endPoint));
        	}
        	// if shifted the full 26 characters then its back to the original character
        	else {
        		result = result + Character.toString(str_to_encipher.charAt(i));
        	}
	        
        	}
        return result;
    }

    /**
     * Encipher a string using the letter positions in ciphertext. Each letter is
     * replaced by the letter in the same ordinal position in the ciphertext.
     * Non-letters are left unchanged. Ex:
     *
     * <pre>
    Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
    Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
     * </pre>
     *
     * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
     * are ignored.
     *
     * @param s          string to encipher
     * @param ciphertext ciphertext alphabet
     * @return the enciphered string
     */
    public static String substitute( String s, String ciphertext) {
    	
    	// initialize variables
    	String str_to_encipher = s;
    	String ciphertext_a = ciphertext;
    	String result = "";
    	
        for (int i = 0; i < s.length(); ++i) {
        	
        	if (Character.isLetter(s.charAt(i))) {
        		result = result + Character.toString(ciphertext_a.charAt(ALPHA.indexOf(Character.toUpperCase(str_to_encipher.charAt(i)))));
        	}
        	else {
        		result = result + Character.toString(str_to_encipher.charAt(i));
        	}
    }
        return result;
    }

}
