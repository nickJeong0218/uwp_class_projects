/*
 * This class  implements a playing card.
 * 
 * Written by: Erica Eddy
 */

public class Card {

    //----------------------------------
    //    Instance variables
    //----------------------------------

    /* 
     * An integer for the card rank
     */
    private int rank;

    /* 
     * A char to hold the card suit: 
     * 'C' for "Clubs"
     * 'D' for "Diamonds"
     * 'H' for "Hearts"
     * 'S' for "Spades"
     */
    private char suit;

    //----------------------------------
    //    Constructor
    //----------------------------------

    /**
     * @param - a card must have a rank and suit
     */
    public Card (int rank, char suit) {
        this.rank = rank;
        this.suit = suit;
    } 

    //----------------------------------
    //    Methods
    //----------------------------------
    // return the card's rank
    public int getRank()
    {
        return rank;
    }

    // return the card's suit
    public char getSuit()
    {
        return suit;
    }

    /**
     *  return a String name for the card
     *  @return s - a String of text describing the card
     */
    public String toString() {

        String s = "";
        switch (rank) {
            case 14: s = "Ace"; break;
            case 2: s = "Two"; break;
            case 3: s = "Three"; break;
            case 4: s = "Four"; break;
            case 5: s = "Five"; break;
            case 6: s = "Six"; break;
            case 7: s = "Seven"; break;
            case 8: s = "Eight"; break;
            case 9: s = "Nine"; break;
            case 10: s = "Ten"; break;
            case 11: s = "Jack"; break;
            case 12: s = "Queen"; break;
            case 13: s = "King"; break;
        }
        s += " of ";
        switch (suit)  {
            case 'C': s = s + "Clubs"; break;
            case 'D': s = s + "Diamonds"; break;
            case 'H': s = s + "Hearts"; break;
            case 'S': s = s + "Spades"; break;
        }
        return s;
    }
}
