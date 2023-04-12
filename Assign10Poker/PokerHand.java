/**
 * This class represents a five card poker hand
 * 
 * @author Erica Eddy
 */
public class PokerHand
{
    private Card [] hand;        // the hand of 5 cards

    // the default constructor
    public PokerHand ()
    {
        hand = new Card [5];
    }

    // A constructor to help with testing
    public PokerHand (Card c0, Card c1, Card c2, Card c3, Card c4)
    {
        hand = new Card [5];
        hand[0] = c0;
        hand[1] = c1;
        hand[2] = c2;
        hand[3] = c3;
        hand[4] = c4;
    }

    // This methods fills the hand with cards from the deck.
    // It uses an insertion sort so that the cards are ordered by rank.
    public void fillHand (Deck deck)
    {
        for (int i=0; i<5; i++)
        {
            int j=i-1;
            Card temp = deck.dealCard();
            while (j>=0 && hand[j].getRank() > temp.getRank())
            {   
                hand[j+1] = hand[j];
                j--;
            }
            hand[j+1] = temp;
        }
    }

    // PLACE ADDITIONAL METHODS AFTER THIS COMMENT

    // Before methods to check the hand, initialize a class constant: the sum of rank is royal flush.
    public static final int SUM_OF_ROYAL_FLUSH = 14 + 13 + 12 + 11 + 10;

    /*
     * 1. boolean isRoyalFlush():
     *    This method will return TRUE only if the hand is a royal flush.
     */
    public boolean isRoyalFlush ()  {
        boolean royalFlush = false;     // Initialize a boolean variable for return. 
        int sumOfRank = 0;              // Initialize a int variable to hold the sum of cards in hand.

        // Add the ranks of cards in the hand.
        for (int i = 0; i < hand.length; i++)   {        
            sumOfRank += hand[i].getRank();
        }

        // Compare the sum of hands to the sum of royal flush.
        // If the sum is same as the royal flush, change the boolean value to TRUE.
        if (sumOfRank == SUM_OF_ROYAL_FLUSH)
            royalFlush = true;

        // Check whether cards in the hand are in a same suit.
        // If any card is in the other suits, change the boolean value to FALSE.
        for (int i = 1; i < hand.length; i++)   {
            if (hand[0].getSuit() != hand[i].getSuit())
                royalFlush = false;
        }

        return royalFlush;         // Return the boolean variable.
    }

    /*
     * 2. boolean isStraightFlush():
     *    This method will return TRUE only if the hand is a straight flush.
     *    The hand should not be a royal flush when it returns true.
     */
    public boolean isStraightFlush ()    {
        boolean straightFlush = false;          // Initialize a boolean variable for return.
        int checkSequence = 0;                  // Initialze a int variable to check cards in the hand is increment.
        int sumOfRank = hand[0].getRank();      // Initialize a int variable to hold the sum of cards in hand.

        // Check the cards in the hand are in an increment by subtract 2 ranks of cards next to each other.
        // While checking cards, sum up of the ranks of cards in the hand.
        for (int i = 4; i > 0; i--)    {
            checkSequence = checkSequence + (hand[i].getRank() - hand[i - 1].getRank());
            sumOfRank += hand[i].getRank();
        }

        // If the cards are in an increment,
        // and the sum of ranks in the hand is less than the sum of the royal flush,
        // then change the boolean value to TRUE.
        if((checkSequence == 4) 
        && (sumOfRank < SUM_OF_ROYAL_FLUSH))
            straightFlush = true;

        // Check whether cards in the hand are in a same suit.
        // If any card is in the other suits, change the boolean value to FALSE.    
        for (int i = 1; i < hand.length; i++)   {
            if (hand[0].getSuit() != hand[i].getSuit())
                straightFlush = false;
        }

        return straightFlush;                // Return the boolean variable.
    }

    /*
     * 3. boolean is4OfAKind():
     *    This method will return TRUE only if the hand is a 4 of a kind.
     */
    public boolean is4OfAKind ()    {
        boolean fourOfAKind = false;            // Initialize a boolean variable for return.
        int count = 0;                          // Initialize a int variable to count how many cards are same.

        // By using a nested-loop, check how many times the ranks of two cards are same.
        // Whenever, two cards have same ranks, increase int value by 1.
        for (int i = 0; i < hand.length - 1; i++) {
            for (int j = i + 1; j < hand.length; j++)   {
                if ((hand[i].getRank() - hand[j].getRank()) == 0)
                    count++;
            }
        }

        // If the value of int variable is 6, change the boolean value to TRUE.
        if (count == 6)
            fourOfAKind = true;

        return fourOfAKind;                     // Return the boolean variable.
    }

    /*
     * 4. boolean isFullHouse():
     *    This method will return TRUE only if the hand is a full house.
     *    This should not return true when the hand is 3 of a kind or 2 pairs.
     */
    public boolean isFullHouse ()    {
        boolean fullHouse = false;          // Initialize a boolean variable for return.
        int count = 0;                      // Initialize a int variable to count how many cards are same.

        // By using a nested-loop, check how many times the ranks of two cards are same.
        // Whenever, two cards have same ranks, increase int value by 1.
        for (int i = 0; i < hand.length - 1; i++) {
            for (int j = i + 1; j < hand.length; j++)   {
                if ((hand[i].getRank() - hand[j].getRank()) == 0)
                    count++;
            }
        }

        // If the value of int variable is 4, change the boolean value to TRUE.
        if (count == 4)
            fullHouse = true;

        return fullHouse;                   // Return the boolean variable.
    }

    /*
     * 5. boolean isFlush():
     *    This method will return TRUE only if the hand is a flush.
     *    This method will not return true is the hand is royal or straight flush.
     */
    public boolean isFlush ()    {
        boolean flush = true;               // Initialize a boolean variable for return.
        int checkSequence = 0;              // Initialze a int variable to check cards in the hand is increment.

        // Check whether cards in the hand are in a same suit.
        // If any card is in the other suits, change the boolean value to FALSE. 
        for (int i = 1; i < hand.length; i++)   {
            if (hand[0].getSuit() != hand[i].getSuit())
                flush = false;
        }

        // Check the cards in the hand are in an increment by subtract 2 ranks of cards next to each other.
        for (int i = 4; i > 0; i--)    {
            checkSequence = checkSequence + (hand[i].getRank() - hand[i - 1].getRank());
        }
        
        // If the cards are NOT in an increment, change the boolean value to FALSE.
        if (checkSequence == 4)
            flush = false;

        return flush;                       // Return the boolean variable.
    }

    /*
     * 6. boolean isStraight():
     *    This method will return TRUE only if the hand is a straight.
     *    This method will not return true if the hand is royal or straight flush.
     */
    public boolean isStraight () {
        boolean straight = false;           // Initialize a boolean variable for return.
        int checkSequence = 0;              // Initialze a int variable to check cards in the hand is increment.
        int count = 0;                      // Initialize a int variable to count how many cards are same.

        // Check the cards in the hand are in an increment by subtract 2 ranks of cards next to each other.
        for (int i = 4; i > 0; i--) {
            checkSequence = checkSequence + (hand[i].getRank() - hand[i - 1].getRank());
        }

        // By using a loop, check how many times the ranks of two cards next to each other are same.
        // Whenever, two cards have same ranks, increase int value by 1.
        for (int i = 0; i < hand.length - 1; i++) {
            int j = i + 1;
            if ((hand[i].getRank() - hand[j].getRank()) == 0)
                count++;
        }

        // If the cards are in an increment, and there is no same rank among cards,
        // then determine whether every card is in the same suit.
        // If the cards are not in one suit, then change the boolean value to TRUE.
        if ((checkSequence == 4) && (count == 0))   {
            for (int i = 1; i < hand.length; i++)   {
                if (hand[0].getSuit() != hand[i].getSuit())
                    straight = true;
            }
        }

        return straight;                    // Return the boolean variable.
    }

    /*
     * 7. boolean is3OfAKind():
     *    This method will return TRUE only if the hand is a 3 of a kind.
     *    It will not return true when the hand is a 4 of a kind or a full house.
     */
    public boolean is3OfAKind ()    {
        boolean threeOfAKind = false;           // Initialize a boolean variable for return.
        int count = 0;                          // Initialize a int variable to count how many cards are same.

        // By using a nested-loop, check how many times the ranks of two cards are same.
        // Whenever, two cards have same ranks, increase int value by 1.
        for (int i = 0; i < hand.length - 1; i++) {
            for (int j = i + 1; j < hand.length; j++)   {
                if ((hand[i].getRank() - hand[j].getRank()) == 0)
                    count++;
            }
        }

        // If the value of int variable is 3, change the boolean value to TRUE.
        if (count == 3)
            threeOfAKind = true;

        return threeOfAKind;                    // Return the boolean variable.
    }

    /*
     * 8. boolean is2Pair():
     *    This method will return TRUE only if the hand is a 2 pair.
     *    It will not return turn if the hand is a 4 of a kind or a full house.
     */
    public boolean is2Pair ()   {
        boolean twoPair = false;            // Initialize a boolean variable for return.
        int count = 0;                      // Initialize a int variable to count how many cards are same.

        // By using a nested-loop, check how many times the ranks of two cards are same.
        // Whenever, two cards have same ranks, increase int value by 1.
        for (int i = 0; i < hand.length - 1; i++) {
            for (int j = i + 1; j < hand.length; j++)   {
                if ((hand[i].getRank() - hand[j].getRank()) == 0)
                    count++;
            }
        }

        // If the value of int variable is 2, change the boolean value to TRUE.
        if (count == 2)
            twoPair = true;

        return twoPair;                     // Return the boolean variable.
    }

    /*
     * 9. boolean isPair():
     *    This method will return TRUE only if the hand is a pair.
     *    For this case, it doesn't include upper level:
     *    4 of a kind, 3 of a kind, 2 pair and full house.
     */
    public boolean isPair ()    {
        boolean pair = false;           // Initialize a boolean variable for return.
        int count = 0;                  // Initialize a int variable to count how many cards are same.

        // By using a nested-loop, check how many times the ranks of two cards are same.
        // Whenever, two cards have same ranks, increase int value by 1.
        for (int i = 0; i < hand.length - 1; i++)   {
            for (int j = i + 1; j < hand.length; j++)   {
                if ((hand[i].getRank() - hand[j].getRank()) == 0)
                    count++;
            }
        }

        // If the value of int variable is 2, change the boolean value to TRUE.
        if (count == 1)
            pair = true;

        return pair;                    // Return the boolean variable.
    }

    /*
     * 10. boolean isHighCard():
     *     This method will return TRUE 
     *     only if the hand is not fit in any above methods.
     */
    public boolean isHighCard ()    {
        boolean highCard = false;           // Initialize a boolean variable for return.
        int count = 0;                      // Initialize a int variable to count how many cards are same.
        int checkSequence = 0;              // Initialze a int variable to check cards in the hand is increment.

        // By using a nested-loop, check how many times the ranks of two cards are same.
        // Whenever, two cards have same ranks, increase int value by 1.
        for (int i = 0; i < hand.length - 1; i++)   {
            for (int j = i + 1; j < hand.length; j++)   {
                if ((hand[i].getRank() - hand[j].getRank()) == 0)
                    count++;
            }
        }

        // Check the cards in the hand are in an increment by subtract 2 ranks of cards next to each other.
        for (int i = 4; i > 0; i--) {
            checkSequence = checkSequence + (hand[i].getRank() - hand[i - 1].getRank());
        }

        // If the value of int variable is 2, and cards are not in an increment,
        // then determine whether every card is in one suit.
        // If not, change the boolean value to TRUE.
        if ((count == 0) && (checkSequence != 4))   {
            for (int i = 1; i < hand.length; i++)   {
                if (hand[0].getSuit() != hand[i].getSuit())
                    highCard = true;
            }
        }

        return highCard;                    // Return the boolean variable.
    }
}