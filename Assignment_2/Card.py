#
# YunHwan Jeong
# CSCI - 333
#
# Program: Card.py
#
# This program will contain a class Card.
# This Card class will make objects of Card, giving them information about rank and suit.
# This class will be used in Card Main.py which will ask users how many cards they want to get.

class Card:
    # Define object constructor.
    def __init__(self, rank, suit):
        self.rank = rank        # Give initial value to an instance variable.
        self.suit = suit        # Give initial value to an instance variable.

    # Define a getter for an instance variable, rank.
    def getRank(self):
        return self.rank        # Return an instance variable.

    # Define a getter for a instance variable, suit.
    def getSuit(self):
        return self.suit        # Return an instance variable.

    # Define a method that will return value of an object.
    def value(self):
        # Check whether rank is Ace, one of face cards: Jack, Queen and King, or one of number cards.
        if self.rank == 1:
            self.value = 1      # Assign proper Blackjack value to an object.
        elif self.rank > 10:
            self.value = 10     # Assign proper Blackjack value to an object.
        else:
            self.value = self.rank      # Assign proper Blackjack value to an object.

        return self.value       # Return an instance variable.

    # Define a method that will return a String object containing information of Card object.
    def __str__(self):
        info = ""               # Initialize a String object that will hold information of Card object.

        # Determine the rank of Card object.
        if self.rank == 1:
            info += "Ace"       # Concatenate the String object initialized with proper rank information.
        elif self.rank == 2:
            info += "Two"       # Concatenate the String object initialized with proper rank information.
        elif self.rank == 3:
            info += "Three"     # Concatenate the String object initialized with proper rank information.
        elif self.rank == 4:
            info += "Four"      # Concatenate the String object initialized with proper rank information.
        elif self.rank == 5:
            info += "Five"      # Concatenate the String object initialized with proper rank information.
        elif self.rank == 6:
            info += "Six"       # Concatenate the String object initialized with proper rank information.
        elif self.rank == 7:
            info += "Seven"     # Concatenate the String object initialized with proper rank information.
        elif self.rank == 8:    
            info += "Eight"     # Concatenate the String object initialized with proper rank information.
        elif self.rank == 9:
            info += "Nine"      # Concatenate the String object initialized with proper rank information.
        elif self.rank == 10:
            info += "Ten"       # Concatenate the String object initialized with proper rank information.
        elif self.rank == 11:
            info += "Jack"      # Concatenate the String object initialized with proper rank information.
        elif self.rank == 12:
            info += "Queen"     # Concatenate the String object initialized with proper rank information.
        elif self.rank == 13:
            info += "King"      # Concatenate the String object initialized with proper rank information.

        # Concatenate the String object initialized a word, of, to combine 2 information.
        info += " of "          

        # Determine the suit of Card object.
        if self.suit == 'd':
            info += "Diamonds"  # Concatenate the String object initialized with proper suit information.
        elif self.suit == 'c':
            info += "Clobs"     # Concatenate the String object initialized with proper suit information.
        elif self.suit == 'h':
            info += "Hearts"    # Concatenate the String object initialized with proper suit information.
        elif self.suit == 's':
            info += "Spades"    # Concatenate the String object initialized with proper suit information.

        return info             # Return the String object holding information about a Card object.
 
