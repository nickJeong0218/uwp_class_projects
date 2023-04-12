from Card import Card
from random import randrange

def main():
    print("Testing card class")
    n = eval(input("How many cards would you like to see? "))
    for i in range(n):
        rank = randrange(1,14)
        suit = "dchs"[randrange(4)]
        randCard = Card(rank, suit)
        print(randCard, "counts", randCard.value())
main()
