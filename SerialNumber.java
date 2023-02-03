package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Beheashta Atchekzai 190637520
 * @version 2021-09-11
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {
    
    boolean valid = true;
    
    // loop through all characters in str, if one of them is not a digit, break 
    for (int i = 0; i < str.length(); ++i) {
    	if(!Character.isDigit(str.charAt(i))) {
    		valid = false;
    		break;
    	}
    }

	return valid;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {
    
    	boolean valid = true;
    	
    	// check for the dash
    	if(Character.isDigit(sn.charAt(7))) {
    		valid = false;
    		
    	}
    	/*
    	// the overall str length should be 11
    	if (sn.length() != 10) {
    		System.out.println(sn.length());
    		valid = false;
    	}
    	
    	
    	// test for the beginning of str includes "SN/"
    	if (sn.substring(0,3) != "SN/") {
    		valid = false;
    	}
    	
    	
    	// test that the 8th character is a - symbol
    	if (sn.substring(7,8) == "-") {
    		valid = true;
    	}
    	
    	*/
    	
	return valid;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

	// your code here

	return;
    }

}
