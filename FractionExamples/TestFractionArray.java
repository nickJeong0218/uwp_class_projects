
/**
 * Compare int array to Fraction(object) array
 */
public class TestFractionArray  {
    // instance variables
    private int [] num;     // array of integers to contrast w/Fractions
    private int numCount;   // how many slots in array are filled
    private Fraction [] frac;   // array of Fraction objects
    private int fracCount;      // how many slots in Fraction array are filled

    // constructor
    public TestFractionArray()  {
        // initialize instance variables
        num = new int[5];
        numCount = 0;
        frac = new Fraction[5];
        fracCount = 0;
    }
    
    // fill slots in the array
    public void fillArray() {
        addNum(90);
        addNum(121);
        Fraction half = new Fraction(1,2);
        addFrac(half);
        addFrac(new Fraction(1,3));
    }
    
    // print contents of integer array
    public void printArray()    {
        for (int i = 0; i < numCount; i++)    
            System.out.println("num[" + i + "] = " + num[i]);
        
        for (int i = 0; i < fracCount; i++)
            System.out.println("frac[" + i + "] = " + frac[i].toString());
    }

    // add a Fraction object to the array
    public void addFrac(Fraction myFrac)    {
        if (fracCount < frac.length)    {
            frac[fracCount] = myFrac;
            fracCount++;
        }
    }
    
    // add an integer to the next available position in the array
    public void addNum(int value)   {
        if (numCount < num.length)  {    // then there is still room
            num[numCount] = value;
            numCount++;
        }
        else
            System.out.println("Not enough space to add more to num array");
    }
}
