/**
 * Sample program to run a few tests on a PokerHand
 * 
 * @author Erica Eddy
 */
public class TestHand
{
    public static void main (String [] args)
    {
        Card c0 = new Card (8, 'S');
        Card c1 = new Card (10, 'S');
        Card c2 = new Card (11, 'S');
        Card c3 = new Card (12, 'S');
        Card c4 = new Card (13, 'S');
        
        PokerHand hand = new PokerHand (c0, c1, c2, c3, c4);
        System.out.println("This hand is a straight: " + hand.isStraightFlush());
    }
}
