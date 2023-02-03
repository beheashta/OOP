package cp213;

/**
 * @author Beheashta Atchekzai 190637520
 * @version 2021-09-11
 */
public class Numbers {

    /**
     * Determines closest value of two values to a target value.
     *
     * @param target the target value
     * @param v1     first comparison value
     * @param v2     second comparison value
     * @return one of v1 or v2 that is closest to target, v1 is the value chosen if
     *         v1 and v2 are an equal distance from target
     */
    public static double closest(final double target, final double v1, final double v2) {
    
    // initialize variables
	double distance_v1;
	double distance_v2;
	double result;
	
	// check the distances between the target and the variable
	distance_v1 = target - v1;
	distance_v2 = target - v2;
	
	// if the numbers are negative, fix manually
	if (distance_v1 < 0) {
		distance_v1 = distance_v1*(-1);
	}
	if (distance_v2 < 0) {
		distance_v2 = distance_v2*(-1);
	}
	
	// the variable with the smallest distance is the closest to the target
	if (distance_v1 < distance_v2) {
		result = v1;
	}
	else if (distance_v2 < distance_v1) {
		result = v2;
	}
	else {
		result = v1; 
	}
	
	
	

	return result;
    }


    /**
     * Determines if n is a prime number. Prime numbers are whole numbers greater
     * than 1, that have only two factors – 1 and the number itself. Prime numbers
     * are divisible only by the number 1 or itself.
     *
     * @param n an integer
     * @return true if n is prime, false otherwise
     */
    public static boolean isPrime(final int n) {

	boolean result = true;
	
	if(n>1) {
		 for(int i = 2; i <= n/2; i++) {
	            if(n % i == 0){
	                result = false; //if it is divisable by a number other than itself and 1 then it is not a prime number
	                break;
	            }
	            
	        }
	}

	return result;
    }

    /**
     * Sums and returns the total of a partial harmonic series. This series is the
     * sum of all terms 1/i, where i ranges from 1 to n (inclusive). Ex:
     *
     * n = 3: sum = 1/1 + 1/2 + 1/3 = 1.8333333333333333
     *
     * @param n an integer
     * @return sum of partial harmonic series from 1 to n
     */
    public static double sumPartialHarmonic(final int n) {

	double result = 0;
	
	// base case n = 0 
	if (n==0) {
		return 0.0;
	}
	
	// second base case n  = 1
	if (n==1) {
		return 1.0;
	}
	
	// n > 0
	
	for (double i = 1; i<=n; i++) {
		result += (1/i);
		
	}
	return result;
		
    }

}
