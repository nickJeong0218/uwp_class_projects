#
# YunHwan Jeong
# CSCI - 333
#
# Program: CalculateBMI.py
#
# This program will calculate BMI: body mass index.
# It will ask users 2 inputs: weight in pounds and height in inches.
# After calculating BMI, it will print out the result: above, within or below.

import math

def main():
    while True:
        weight = eval(input("Enter your weight (in pounds): "))     # Get an input from user.
        height = eval(input("Enter your height (in inches): "))     # Get an input from user.

        # Check whether inputs are proper or not.
        if (weight > 0 and height > 0):
            break                           # Escape the loop.
        else:
            print("Wrong input")            # Print out error message.

    bmi = (weight * 720) / math.pow(height, 2)                      # Caculate the BMI.

    print("\nYour BMI is ", str(bmi))                               # Print out the figure for BMI.

    # Determine whether the figure is above, within or below the healthy range: 19 - 25.
    if (bmi >= 19 and bmi <= 25):
        print("That's on the healthy range.")                       # Print out proper phrase.
    elif bmi < 19:
        print("That's on the low side.")                            # Print out proper phrase.
    elif bmi > 25:
        print("That's on the high side.")                           # Print out proper phrase.



main()
