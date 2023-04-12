#ifndef BUILDING_H
#define BUILDING_H

#include <iostream>
#include "CarbonFootprint.h"

class Building : public CarbonFootprint {
public:
   Building(int sf) : squareFeet(sf) { } 

   // Simplified formula: Multiply the square footage by 50
   // for the wood frame, by 20 for the basement,
   // by 47 for the concrete, and 17 for the steel
   // http://www.greenerpath.org/Building_Carbon_Footprint.html
   virtual void getCarbonFootprint() {
      std::cout << "Building with " << squareFeet << " square feet: "
         << squareFeet * (50 + 20 + 47 + 17) << std::endl;
   } 
private:
   int squareFeet; // square footage of building
}; 

#endif
