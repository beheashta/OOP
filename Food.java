package cp213;

import java.io.PrintStream;

/**
 * Food class definition.
 *
 * @author David Brown
 * @version 2021-09-24
 */
public class Food implements Comparable<Food> {

    // Constants
    public static final String ORIGINS[] = { "Canadian", "Chinese", "Indian", "Ethiopian", "Mexican", "Greek",
	    "Japanese", "Italian", "Moroccan", "Scottish", "Columbian", "English" };

    /**
     * Creates a string of food origins in the format:
     *
     * <pre>
Origins
 0 Canadian
 1 Chinese
...
11 English
     * </pre>
     *
     * @return A formatted numbered string of valid food origins.
     */
    public static String originsMenu() {

	// your code here
    	String origins="";
		for (int i = 0;i<ORIGINS.length;i++) {
			origins += String.format("%d %s \n", i,ORIGINS[i]);
		}

		return origins;
    }

    // Attributes
    private String name = null;
    private int origin = 0;
    private boolean isVegetarian = false;
    private int calories = 0;

    /**
     * Food constructor.
     *
     * @param name         food name
     * @param origin       food origin code
     * @param isVegetarian whether food is vegetarian
     * @param calories     caloric content of food
     */
    public Food(final String name, final int origin, final boolean isVegetarian, final int calories) {

	// your code here
    	this.name = name;
		this.origin = origin;
		this.isVegetarian = isVegetarian;
		this.calories = calories;

	return;
    }

    /*
     * (non-Javadoc) Compares this food against another food.
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    /**
     * Foods are compared by name, then by origin if the names match.
     * Must ignore case.
     */
    @Override
    public int compareTo(final Food target) {

	// your code here
    	if (this.name.compareTo(target.name)==0) {
			if (this.origin < target.origin) {
				return -1;
			} else if (this.origin > target.origin) {
				return 1;
			} else {
				return 0;
			}
		}
		return this.name.compareTo(target.name);
    }

    /**
     * Getter for calories attribute.
     *
     * @return calories
     */
    public int getCalories() {

	// your code here
    	return this.calories;

    }

    /**
     * Getter for name attribute.
     *
     * @return name
     */
    public String getName() {

	// your code here
    	return(this.name);
    }

    /**
     * Getter for origin attribute.
     *
     * @return origin
     */
    public int getOrigin() {

	// your code here
    	return(this.origin);
    }

    /**
     * Getter for string version of origin attribute.
     *
     * @return string version of origin
     */
    public String getOriginString() {

    	return ORIGINS[this.origin];
    }

    /**
     * Getter for isVegetarian attribute.
     *
     * @return isVegetarian
     */
    public boolean isVegetarian() {

	// your code here
    	return(this.isVegetarian);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object//toString() Creates a formatted string of food data.
     */
    /**
     * Returns a string version of a Food object in the form:
<pre>
Name:       name
Origin:     origin string
Vegetarian: true/false
Calories:   calories
</pre>
     */
    @Override
    public String toString() {

	// your code here
    	String string = String.format("Name:       %s%n", this.name);
		string += String.format("Origin:     %s%n", Food.ORIGINS[this.origin]);
		string += String.format("Vegetarian: %s%n", this.isVegetarian);
		string += String.format("Calories:   %d%n", this.calories);
		return string;
    }

    /**
     * Writes a single line of food data to an open PrintStream. The contents of
     * food are written as a string in the format name|origin|isVegetarian|calories to ps.
     *
     * @param ps The PrintStream to write to.
     */
    public void write(final PrintStream ps) {

    	final String string = String.format("%s|%s|%b|%d", this.name,
				this.origin, this.isVegetarian, this.calories);
		ps.println(string);
		return;
    }

}
