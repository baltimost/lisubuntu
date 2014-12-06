#include<iostream>

using namespace std;
class Solution {
public:
    double pow(double x, int n) {
        double res = 1;
        double p = x;
        bool neg = false;
        if (n < 0) n = -n, neg = true;
        while(n){
            if (n % 2){
                res *= p;
            }
            p = p * p;
            n /= 2;
        }
        if (neg) return 1/res;
        else return res;
    }
};
int main ( int argc, char *argv[] ) {
    /*{
    FILE* file = fopen(argv[1], "r");
    int a, b;
    while(fscanf(file, "%d,%d", &a, &b) != EOF){
    }*/
    /*
    getI(T);
    int T;
    FE(cases,1,T){
        printf("Cases #%d: ", cases);
    }
    }*/
    Solution s = Solution();
    cout << s.pow(

0.00001, 2147483647 
            ) << endl;
    //return EXIT_SUCCESS;
}
