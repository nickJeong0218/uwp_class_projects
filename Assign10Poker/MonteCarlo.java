
/**
 *  Name: YunHwan Jeong (jeong)
 *  Course: CSCI 241 - Computer Science I
 *  Assignment: 10
 *  
 * Project/Class Description:
 *  This class will figure out the probability of 10 cases of hands.
 *  It will have a deck, and make 10 hands for each deck. After that, it will make a new deck.
 *  This class will check 100,000 hands. If this class is done with checking all hands,
 *  then it will print out the probability with counts of all cases and names of cases.
 *  
 * Known Bugs:
 *  none
 */
public class MonteCarlo {
    public static void main (String [] args)    {
        Deck newDeck = new Deck();                  // Make a new deck to make hands.
        newDeck.shuffle();                          // After making a deck, shuffle the deck.
        PokerHand newHand = new PokerHand();        // Make a new hand without any card in hand.

        int countForWhole = 0;                      // Initialize an int variable to count operating times.
        int cardLeftInDeck = Deck.CARDS_IN_DECK;    // Initialize an int variable for the number of cards left in a deck.
        int [] finalResult = new int [10];          // Instantiate an array to hold result of checking.

        // Make a loop which will check hands for 100,000 times.
        for (int runTime = 0; runTime < 100000; runTime++)    {        
            newHand.fillHand(newDeck);          // Fill the hand made before a loop.
            countForWhole++;                    // Count up an int value for the operating time.
            cardLeftInDeck -= 5;                // Subtract 5 from the deck made at first.
            countForAll(newHand, finalResult);  // Invoke a method to check a hand.

            // If the cards in a deck are less than 5, make a new deck.
            if (cardLeftInDeck < 5) {
                cardLeftInDeck = Deck.CARDS_IN_DECK;    // Set an int value for the card left to the origin.
                newDeck = new Deck();                   // Make a new deck.
                newDeck.shuffle();                      // Shuffle a new deck before using.
            }
        }

        // Invoke a method to print out the result after checking in a neat form.
        printOutProbability(countForWhole, finalResult);
    }

    /*
     * This method will check each hand and fill in the array for the result.
     * It will invoke 10 methods for all indexes in the result array.
     */
    public static void countForAll (PokerHand handParam, int [] arrayParam)  {
        // Invoke a method for counting up the hand which is a royal flush.
        arrayParam[0] += checkRoyalFlush(handParam);

        // Invoke a method for counting up the hand which is a straight flush.
        arrayParam[1] += checkStraightFlush(handParam);

        // Invoke a method for counting up the hand which is a 4 of a kind.
        arrayParam[2] += check4OfAKind(handParam);

        // Invoke a method for counting up the hand which is a full house.
        arrayParam[3] += checkFullHouse(handParam);

        // Invoke a method for counting up the hand which is a flush.
        arrayParam[4] += checkFlush(handParam);

        // Invoke a method for counting up the hand which is a straight.
        arrayParam[5] += checkStraight(handParam);

        // Invoke a method for counting up the hand which is a 3 of a kind.
        arrayParam[6] += check3OfAKind(handParam);

        // Invoke a method for counting up the hand which is a 2 pair.
        arrayParam[7] += check2Pair(handParam);

        // Invoke a method for counting up the hand which is a pair.
        arrayParam[8] += checkPair(handParam);

        // Invoke a method for counting up the hand which is a high card.
        arrayParam[9] += checkHighCard(handParam);
    }

    /*
     * This method will check if a hand is a royal flush.
     * If a hand is a royal flush, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int checkRoyalFlush (PokerHand handParam)  {
        int countRoyalFlush = 0;

        if (handParam.isRoyalFlush() == true)   {
            countRoyalFlush++;
        }

        return countRoyalFlush;
    }

    /*
     * This method will check if a hand is a straight flush.
     * If a hand is a straight flush, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int checkStraightFlush (PokerHand handParam)  {
        int countStraightFlush = 0;

        if (handParam.isStraightFlush() == true)   {
            countStraightFlush++;
        }

        return countStraightFlush;
    }

    /*
     * This method will check if a hand is a 4 of a kind.
     * If a hand is a 4 of a kind, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int check4OfAKind (PokerHand handParam)  {
        int count4OfAKind = 0;

        if (handParam.is4OfAKind() == true)   {
            count4OfAKind++;
        }

        return count4OfAKind;
    }

    /*
     * This method will check if a hand is a full house.
     * If a hand is a full house, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int checkFullHouse (PokerHand handParam)  {
        int countFullHouse = 0;

        if (handParam.isFullHouse() == true)   {
            countFullHouse++;
        }

        return countFullHouse;
    }

    /*
     * This method will check if a hand is a flush.
     * If a hand is a flush, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int checkFlush (PokerHand handParam)  {
        int countFlush = 0;

        if (handParam.isFlush() == true)   {
            countFlush++;
        }

        return countFlush;
    }

    /*
     * This method will check if a hand is a straight.
     * If a hand is a straight, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int checkStraight (PokerHand handParam)  {
        int countStraight = 0;

        if (handParam.isStraight() == true)   {
            countStraight++;
        }

        return countStraight;
    }

    /*
     * This method will check if a hand is a 3 of a kind.
     * If a hand is a 3 of a kind, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int check3OfAKind (PokerHand handParam)  {
        int count3OfAKind = 0;

        if (handParam.is3OfAKind() == true)   {
            count3OfAKind++;
        }

        return count3OfAKind;
    }

    /*
     * This method will check if a hand is a 2 pair.
     * If a hand is a 2 pair, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int check2Pair (PokerHand handParam)  {
        int count2Pair = 0;

        if (handParam.is2Pair() == true)   {
            count2Pair++;
        }

        return count2Pair;
    }

    /*
     * This method will check if a hand is a pair.
     * If a hand is a pair, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int checkPair (PokerHand handParam)  {
        int countPair = 0;

        if (handParam.isPair() == true)   {
            countPair++;
        }

        return countPair;
    }

    /*
     * This method will check if a hand is a high card.
     * If a hand is a high card, then it will increase an int variable by 1.
     * Then, it will return the int variable.
     */
    public static int checkHighCard (PokerHand handParam)  {
        int countHighCard = 0;

        if (handParam.isHighCard() == true)   {
            countHighCard++;
        }

        return countHighCard;
    }

    /*
     * This method will print out the result of checking 100,000 hands.
     * The result will be print with 3 columns: name of cases, counts and percentage.
     */
    public static void printOutProbability(int entireCountParam, int [] resultArrayParam)   {
        // Make a double array to print out the probabilities of all cases.
        double [] probabilityArray = new double [10];

        // Fill out the double array with the percentages.
        // The percentages are: CountForEachCase / CoutForOperating.
        for (int i = 0; i < probabilityArray.length; i++)   {
            probabilityArray[i] = (double)(resultArrayParam[i]) / entireCountParam;
        }

        // Before printing out the result, indicate 3 columns, and start printing out result.
        System.out.println(" Hand             Count    Probability");
        System.out.println("----------------------------------------");
        
        // Print out the result in order of the name of cases, count and probability with a format.
        for (int i = 0; i < probabilityArray.length; i++)   {
            // Print out the name of cases by using a swith statement.
            // The order of printing is:
            // royal flush, straight flush, 4 of a kind, full house, flush, straight, 3 of a kind, 2 pair, pair and high card.
            switch (i)  {
                case 0: System.out.printf(" %-15s","RoyalFlush");
                break;
                case 1: System.out.printf(" %-15s","StraightFlush");
                break;
                case 2: System.out.printf(" %-15s","4 Of A Kind");
                break;
                case 3: System.out.printf(" %-15s","Full House");
                break;
                case 4: System.out.printf(" %-15s","Flush");
                break;
                case 5: System.out.printf(" %-15s","Straight");
                break;
                case 6: System.out.printf(" %-15s","3 Of A Kind");
                break;
                case 7: System.out.printf(" %-15s","2 Pair");
                break;
                case 8: System.out.printf(" %-15s","Pair");
                break;
                case 9: System.out.printf(" %-15s","HighCard");
                break;
            }
            
            // After printing out the name of case, display the number of the case.
            System.out.printf("%9d    ", resultArrayParam[i]);
            
            // At last, print the probability.
            System.out.printf("%8.6f", probabilityArray[i]);
            
            // After finishing a case, go to next line for following case.
            System.out.println();
        }
    }
}