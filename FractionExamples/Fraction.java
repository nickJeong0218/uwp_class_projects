/**
 * Fraction class
 * 
 * This class models a fraction with an integer
 * in both the numerator and denominator.
 * It does not reduce the fraction.
 * It does not notice if the denominator is zero.
 * 
 * @author Erica Eddy
 * @version December 2010
 */
public class Fraction
{
    // instance variables
    private int numer;      // non-reduced numerator
    private int denom;    // non-reduced denominator

    /**
     * Default Constructor for objects of class Fraction
     * Calls the other constructor using this()
     */
    public Fraction()
    {
        this(0,1);
    }
    
    // Constructor which initialized the instance variables
    // from the parameter list.
    // Also uses "this" to refer to the current object.
    public Fraction(int numer, int denom)
    {
        this.numer = numer;
        this.denom = denom;
    }
    
    public void setNumerator(int numer)
    {
        this.numer = numer;
    }
    
    public void setDenominator(int denom)
    {
        this.denom = denom;
    }
    
    public double toDouble()
    {
        return (double)numer / denom;
    }
    
    // toString()
    // Builds a String of instance variable information
    // and returns it.
    // public String toString()
    // {
        // String fracText = numer + "/" + denom;
        // return fracText;
    // }
    
    // check if two Fractions are the same
    // Must compare each instance variable of the current
    // object to the instance variables found in the parameter
    public boolean equals(Fraction f2)
    {
        boolean retValue = false;
        if (numer == f2.numer &&
            denom == f2.denom)
            retValue = true;
        return retValue;
    }
    
    // plus #1
    public Fraction plus (Fraction frac2) {
        int newNumerator = numer * frac2.denom
                            + frac2.numer * denom;
        int newDenominator = denom * frac2.denom;
        Fraction sum = new Fraction(newNumerator,newDenominator);
        return sum;
    } 
    // plus #2
    public void plus (Fraction frac2, Fraction result) {
        result.numer = numer * frac2.denom
                            + frac2.numer * denom;
        result.denom = denom * frac2.denom;
    }
    
    public void badPlus(Fraction frac3, Fraction result)    {
        System.out.println(result);
        result = plus(frac3);    
        System.out.println(result);
    }
    
    public static void main(String [] args)
    {
        Fraction half = new Fraction(1,2);
        Fraction quarter = new Fraction(1,4);
        Fraction threeFourths = half.plus(quarter);  
        
        Fraction oneSixth = new Fraction(1,6);
        Fraction twoThirds = new Fraction();
        half.plus(oneSixth, twoThirds);
        System.out.println("twoThirds = " + twoThirds);
        
        System.out.println(half.toString() + " = " + half.toDouble());
        System.out.println(quarter + " = " + quarter.toDouble());

   
    }
}
