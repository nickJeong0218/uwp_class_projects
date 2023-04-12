#
# YunHwan Jeong
# CSCI - 333
#
# Program: Acronym.py
#
# This program will be used to make acronyms.
# Acronym is a word formed by taking the first letters of the words in a phrase,
# and making a word from them.
# In order to make acronym, this program will ask users to input 1 phrase.
# Then, it will split the phrase word by word, and make acronym.

def main():
    print("This program builds acronyms")       # Print out the introduction of this prgram.
    
    phrase = input("Enter a phrase: ")          # Get phrase by asing users input.
    acronyms = ""                               # Initialize a String object which is an acornym.

    list = phrase.split(" ")                    # Split the phrase with respect to a space.

    # Make a loop that runs until the words in a phrase are not left.
    for i in list:
        acronyms += i[0]                        # Concatenate the first characters to acornym.

    acronyms = acronyms.upper()                 # Change acornym to upper case.
    
    print("The acronym is", acronyms)           # Print out the acornym.




main()
