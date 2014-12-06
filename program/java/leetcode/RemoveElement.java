public class RemoveElement{
    /*
    public static int removeElement(int[] A, int elem){
        int output = A.length;
        for(int i = 0;;i++){
            if(A[i] == elem){
                if(i == output - 1){
                    output--;
                    return output;
                }
                while(A[output - 1] == elem){
                    output--;
                }
                A[i] = A[output - 1];
                output--;
            }
        }
    }
    */
    /*
    public static int removeElement(int[] A, int elem){
        int i = 0;
        for(int j = 0; j < A.length; j++){
            if(A[j] != elem){
                A[i] = A[j];
                i++;
            }
        }
        return i;
    }
    */
    /*Best answer!!*/
    public static int removeElement(int[] A, int elem){
        int i = 0;
        int pointer = A.length - 1;
        while(i <= pointer){
            if(A[i] == elem){
                A[i] = A[pointer];
                pointer--;
            }else{
                i++;
            }
        }
        return pointer + 1;
    }
    public static void main(String[] args){
        RemoveElement re = new RemoveElement();
        //int A[] = {3,5,23,6,89,45,32,56,5,43,2,5,6,7,8};
        int A[] = {3,3};
        //int A[] = {5,1,5,5,5};
        for(int i = 0;i < A.length;i++)
           System.out.print(A[i] + " "); 
        System.out.println();
        int length = re.removeElement(A, 3); 
        for(int i = 0;i < length;i++)
           System.out.print(A[i] + " "); 
        System.out.println();
    }
}

