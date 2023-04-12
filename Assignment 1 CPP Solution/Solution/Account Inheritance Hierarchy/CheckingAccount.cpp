#include <iostream>
#include <stdexcept>
#include "CheckingAccount.h" // CheckingAccount class definition
using namespace std;

// constructor initializes balance and transaction fee
CheckingAccount::CheckingAccount(double initialBalance, double fee)
   : Account(initialBalance), transactionFee(0.0) { // initialize base class
   if (fee >= 0.0) {
      transactionFee = fee;
   }
   else {
      throw invalid_argument("Transaction fee must be >= 0.0");
   }
} 

// credit (add) an amount to the account balance and charge fee
void CheckingAccount::credit(double amount) {
   Account::credit(amount); // always succeeds
   chargeFee();
} 

// debit (subtract) an amount from the account balance and charge fee
bool CheckingAccount::debit(double amount) {
   bool success{Account::debit(amount)}; // attempt to debit

   if (success) { // if money was debited, charge fee and return true
      chargeFee();
      return true;
   } 
   else { // otherwise, do not charge fee and return false
      return false;
   }
} 

// subtract transaction fee
void CheckingAccount::chargeFee() {
   Account::setBalance(getBalance() - transactionFee);
   cout << "$" << transactionFee << " transaction fee charged." << endl;
}
