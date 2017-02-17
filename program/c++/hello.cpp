#include <iostream>
#include <vector>
#include <deque>
#include <map>

using namespace std;

class Mammal {
    public:
        virtual void say() {
            cout << "Mammal" << endl;
        }
};

class PolarBear: public Mammal {
    public:
        void say() {
            cout << "PolarBear" << endl;
        }
};

class Human: public Mammal {
    public:
        void say() {
            cout << "Human" << endl;
        }
};

int main() 
{
    /*
    Mammal * mm;
    PolarBear pb;
    Human hm;
    mm = &pb;
    mm->say();
    mm = &hm;
    mm->say();
    */
    dequeue<int> d;
    d.push_back(1);
    d.push_back(2);
    d.push_back(3);
    d.push_back(4);
    cout << d.pop_front << endl;
}
