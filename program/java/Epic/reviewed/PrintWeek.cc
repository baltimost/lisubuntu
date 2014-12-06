#include <iostream>
#include <string>
#include <vector>

using namespace std;

const int NUMBEROFDAYS[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};

bool isLeapYear(int year)
{
    return (year%400 == 0)||(year%4 == 0 && year%100 != 0);
}

int numberOfDaysInMonthAndYear(int month, int year)
{
    if(isLeapYear(year) && month == 2)
    {
        return 29;
    }
    else return NUMBEROFDAYS[month];
}

void printDay(int day, int month, int year, int whichDay)
{
    cout<<month<<", "<<day<<", "<<year<<" is "<<whichDay<<endl;
}

void findWeek(int month, int day, int year, int whichDay)
{
    for( int i = whichDay ; i > 0 ; -- i )
    {
        if(day == 1)
        {
            if(month == 1)
            {
                year--;
                month = 12;
                day = numberOfDaysInMonthAndYear(month, year);
            }
            else month--;
        }
        else day--;
    }
    
    for(int i = 0; i < 7 ; ++ i)
    {
        printDay(day, month, year, i);
        day++;
        if(day > numberOfDaysInMonthAndYear(month, year) )
        {
            day = 1;
            month++;
            if(month > 12)
            {
                month = 1;
                year++;
            }
        }
    }
    
}


int main (int argc, const char * argv[])
{
    findWeek(10,31,2008,0);
    //findWeek(12,28,2001,1);
    return 0;
}
