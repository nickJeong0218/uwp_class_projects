#include <stdexcept>
#include <iostream>
#include "Account.h" // include definition of class Account
using namespace std;

// Account constructor initializes data member balance
Account::Account(double initialBalance) : balance(0.0) {
   // if initialBalance is greater than or equal to 0.0, set this value 
   // as the balance of the Account
   if (initialBalance >= 0.0) {
      balance = initialBalance;
   }
   else {
      throw invalid_argument("Initial balance cannot be negative");
   }
} 

// credit (add) an amount to the account balance
void Account::credit(double amount) {
   balance = balance + amount; // add amount to balance
} 

// debit (subtract) an amount from the account balance
// return bool indicating whether money was debited
bool Account::debit(double amount) {
   if (amount > balance) { // debit amount exceeds balance
      cout << "Debit amount exceeded account balance." << endl;
      return false;
   } 
   else { // debit amount does not exceed balance
      balance = balance - amount;
      return true;
   } 
} 

// set the account balance
void Account::setBalance(double newBalance) {
   balance = newBalance;
} 

// return the account balance
double Account::getBalance() {
   return balance;
}
