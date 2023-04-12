#include <cstdlib>
#include <iostream> 
#include <stdexcept>
#include <sstream>
#include "RationalNumber.h"
using namespace std;

// RationalNumber constructor sets n and d and calls reduction
RationalNumber::RationalNumber(int n, int d) {
   numerator = n;
   
   // validate denominator
   if (d > 0) {
      denominator = d;
   }
   else {
      invalid_argument("Denominator cannot be 0");
   }
} 

// overloaded + operator
RationalNumber RationalNumber::operator+(const RationalNumber& a) {
   return RationalNumber{
      numerator * a.denominator + denominator * a.numerator,
      denominator * a.denominator};
} 

// overloaded - operator
RationalNumber RationalNumber::operator-(const RationalNumber& s) {
   return RationalNumber{
      numerator * s.denominator - denominator * s.numerator,
      denominator * s.denominator};
} 

// overloaded * operator
RationalNumber RationalNumber::operator*(const RationalNumber& m) {
   return RationalNumber{numerator * m.numerator,
      denominator * m.denominator};
} 

// overloaded / operator
RationalNumber RationalNumber::operator/(const RationalNumber& d) {
   if (d.numerator != 0) { // check for a zero in numerator
      return RationalNumber{numerator * d.denominator,
         denominator * d.numerator};
   } 

   throw invalid_argument(
      "Argument's numerator is 0, which would result in division by zero");
} 

// overloaded == operator
bool RationalNumber::operator==(const RationalNumber &er) const {
   return numerator == er.numerator && denominator == er.denominator;
} 

// overloaded != operator
bool RationalNumber::operator!=(const RationalNumber &ner) const { 
   return !(*this == ner);
} 

// function printRational definition
string RationalNumber::toString() const {
   ostringstream output;

   if (numerator == 0) { // print fraction as zero
      output << numerator;
   }
   else if (denominator == 1) { // print fraction as integer
      output << numerator;
   }
   else {
      output << numerator << '/' << denominator;
   }

   return output.str();
}
