#ifndef BICYCLE_H
#define BICYCLE_H

#include <iostream>
#include "CarbonFootprint.h"

class Bicycle : public CarbonFootprint {
public:
   // Not counting the carbon used to make the bicycle,
   // a bike's carbon footprint is 0
   // http://www.livemint.com/2009/06/04230851/
   //    How-big-is-your-carbon-footpri.html?pg=1
   virtual void getCarbonFootprint() {
      std::cout << "Bicycle: 0" << std::endl;
   } 
}; 

#endif
