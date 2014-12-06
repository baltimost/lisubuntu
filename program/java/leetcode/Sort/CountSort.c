#include <stdio.h>
#include <string.h>
#define RANGE 10
//#define RANGE 255

void countSort(char *str)
{
    // The output character array that will have sorted str
    char output[strlen(str)];
 
    // Create a count array to store count of inidividul characters and
    // initialize count array as 0
    int count[RANGE + 1], i;
    memset(count, 0, sizeof(count));
 
    // Store count of each character
    for(i = 0; str[i]; ++i)
        ++count[str[i]];
    /**/
    for(i = 0;i < RANGE;i++){
        printf("%d ", count[i]);
    }
    printf("\n");
    /**/
 
    // Change count[i] so that count[i] now contains actual position of
    // this character in output array
    for (i = 1; i <= RANGE; ++i)
        count[i] += count[i-1];
    /**/
    for(i = 0;i < RANGE;i++){
        printf("%d ", count[i]);
    }
    printf("\n");
    /**/
 
    // Build the output character array
    for (i = 0; str[i]; ++i)
    {
        output[count[str[i]]-1] = str[i];
        --count[str[i]];
    }
 
    // Copy the output array to str, so that str now
    // contains sorted characters
    for (i = 0; str[i]; ++i)
        str[i] = output[i];
}
 
// Driver program to test above function
int main()
{
    //char str[] = "geeksforgeeks";//"applepp";
    char str[] = "\x01\x04\x01\x02\x07\x05\x02";//"applepp";
 
    countSort(str);
 
    //printf("Sorted string is %s\n", str);
    int i;
    for(i = 0;i < RANGE;i++)
        printf("%d ", str[i]);
    printf("\n");
    return 0;
}
