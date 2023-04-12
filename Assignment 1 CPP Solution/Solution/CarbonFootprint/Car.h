#ifndef CAR_H
#define CAR_H

#include <iostream>
#include "CarbonFootprint.h"

class Car : public CarbonFootprint {
public:
   Car(double g) : gallons(g) { } 

   // one gallon of gas yields 20 pounds of CO2
   // http://www.enviroduck.com/carbon_footprint_calculations.php
   virtual void getCarbonFootprint() {
      std::cout << "Car that has used " << gallons << " gallons of gas: "
         << gallons * 20 << std::endl;
   } 
private:
   double gallons;
}; 

#endif
