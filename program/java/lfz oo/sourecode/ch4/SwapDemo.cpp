// Swap coordinates -- C++ °æ±¾
#include <iostream>
using namespace std;

class Coord {
	public:
		int x;
		int y;
};

// Swap contents of two Coord objects.
void swap(Coord &a, Coord &b) {
	Coord temp;
	
	// swap contents of objects
	temp = a;
	a = b;
	b = temp;
}

int main(){
	Coord ob1, ob2;
	
	ob1.x = 10;
	ob1.y = 20;
	ob2.x = 88;
	ob2.y = 99;
	
	cout << "Original values:\n";
	cout << "ob1: " << ob1.x << ", " << ob1.y << "\n";
	cout << "ob2: " << ob2.x << ", " << ob2.y << "\n";

	swap(ob1, ob2);
	
	cout << "Swapped values:\n";
	cout << "ob1: " << ob1.x << ", " << ob1.y << "\n";
	cout << "ob2: " << ob2.x << ", " << ob2.y << "\n";
	
	return 0;
}