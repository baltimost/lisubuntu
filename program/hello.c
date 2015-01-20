#include<stdio.h>

enum Security_Levels{
    black_ops,
    top_secret,
    secret,
    non_secret
};

enum Boolean{
    false,
    true
};
void main(){
    printf("hello\n");
    printf("%d\n", black_ops);
    printf("%d\n", top_secret);
    printf("%d\n", secret);
    printf("%d\n", non_secret);
}


