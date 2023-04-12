#include <vector>
#include "CarbonFootprint.h"
#include "Bicycle.h"
#include "Building.h"
#include "Car.h"
using namespace std;

int main() {
   vector<CarbonFootprint*> list;

   // add elements to list
   list.push_back(new Bicycle());
   list.push_back(new Building(2500));
   list.push_back(new Car(10));

   // display carbon footprint of each object
   for (size_t i{0}; i < list.size(); ++i) {
      list[i]->getCarbonFootprint();
   }

   // release elements of list
   for (size_t i = 0; i < list.size(); ++i) {
      delete list[i];
   }
}
