/*
 * This class  implements a deck of playing cards
 * 
 * Written by: Erica Eddy
 */
import java.util.*;

public class Deck {
    // class constant to hold size of complete deck
    public static final int CARDS_IN_DECK = 52;
    
    //----------------------------------
    //    Instance variables
    //----------------------------------
    /* 
     * An array of Card objects
     */
    private Card [] card;

    /* 
     * The number of cards in the Deck
     */
    private int count;

    //----------------------------------
    //    Constructor
    //----------------------------------
    public Deck ()  {
        // create the new array to hold cards
        card = new Card [CARDS_IN_DECK];

        // fill deck with correct suits and ranks
                
        for (int i = 2; i <=14; i++)    {

            // first 13 cards are Clubs
            card[i-2] = new Card(i,'C');

            // next 13 cards are Diamonds
            card[i+13-2] = new Card(i,'D');

            // next 13 cards are Hearts
            card[i+26-2] = new Card(i,'H');

            // last 13 cards are Spades
            card[i+39-2] = new Card(i,'S');
        }

        count = CARDS_IN_DECK;
    }


    //----------------------------------
    //    Methods
    //----------------------------------
    //Display card information in a neat way
    public String toString()
    {
        String holdAll = new String();

        for (int i = 0; i < CARDS_IN_DECK; i++)
            holdAll = holdAll + card[i].toString() + '\n';

        return holdAll;
    }

    // Use a random number generator to find array locations from
    // where to swap card values.
    public void shuffle()
    {

        for (int i = 0; i < CARDS_IN_DECK; i++)   {
            // calculate 2 integer locations for swap
            int loc1 = (int)(Math.random() * CARDS_IN_DECK);
    
            // create a temporary card and swap the values
            Card temp = card[loc1];
            card[loc1] = card[i];
            card[i] = temp;

        } // end for loop
    }

    // Return the card located at the top of the deck.
    // If the deck is empty, return null.
    // Keep the card count inside the deck current.
    public Card dealCard()
    {
        // create a temporary card that had a dummy rank and suit
        Card dealt = new Card(1,'C');

        // if there are still cards in the deck, return the top one
        // and decrement the count of cards left in the deck
        // else return 'null'

        if (count > 0)  {
            dealt = card[count-1];
            card[count-1] = null;
            count--;
        }
        else
            dealt = null;

        return dealt;
    }
}
