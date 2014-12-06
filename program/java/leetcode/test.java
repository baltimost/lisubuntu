public class test{
    public static void main(String[] args){
        int[] input = {0,1,2,3,4,5,6};
        int i = 0;
        System.out.println(input[++i]);
        System.out.println(i);
        System.out.println(input[i++]);
        //int j = 97;
        Integer j = new Integer(97);
        System.out.println(j.intValue());
    }
}
