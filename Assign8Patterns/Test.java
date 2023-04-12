public class Test{    
    public static void main(String [] args) {
        int [][] block = new int [4][5];
        fillArray(block);
        
        for (int c = 0; c <block[0].length; c++) {
            int colSum = sumOfColumn (block, c);
            System.out.println("column " + c + " sum = " + colSum);
        }
    }
    
    public static void fillArray (int [][] arrayParam)    {
        for (int r = 0; r < arrayParam.length; r++)
            for (int c = 0; c < arrayParam[r].length; c++)
                arrayParam [r][c] = (int)(Math.random() * 101);
    }
    
    public static int sumOfColumn (int [][] arrayParam, int colParam)   {
        int sum = 0;
        for (int r = 0; r < arrayParam.length; r++) {
            sum += arrayParam [r][colParam];
        }
        return sum;
    }
    
    public static double max (int num1, double num2)   {
        System.out.println("version 1");
        if (num1 > num2)
            return num1;
        else
            return num2;
    }
    
    public static double max (double num1, int num2)    {
        System.out.println("version 2");
        if (num1 > num2)
            return num1;
        else
            return num2;
    }
}    