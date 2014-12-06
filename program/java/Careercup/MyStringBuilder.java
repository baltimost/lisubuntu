import java.util.*;

public class MyStringBuilder{
    public char[] value;
    private int length;
    public MyStringBuilder(){
        value = new char[16];
        length = 16;
    }
    public MyStringBuilder(String str){
        char[] tmp = str.toCharArray();
        value = new char[tmp.length + 16];
        System.arraycopy(tmp, 0, value, 0, tmp.length);
        length = tmp.length;
    }
    public MyStringBuilder append(String str){
        if(str.length() + length > value.length){
            expandCapacity(str.length() + length);
        }
        for(int i = 0;i < str.length();i++)
            value[length + i] = str.charAt(i);
        length = length + str.length();
        return this;
    }
    public String toString(){
        return new String(value);
    }
    private void expandCapacity(int capacity){
        int newCapacity = Math.max(capacity, value.length * 2);
        value = Arrays.copyOf(value, newCapacity);//Equals to new + System.copyarray
    }
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        //My initial StringBuilder 15ms newCapacity = length + newstrlength+16
        //My optimized StringBuilder 5ms newCapacity = Math.max(value.length * 2, length + newstrlength) 
        MyStringBuilder msb = new MyStringBuilder();
        for(int i = 0;i < 1000;i++){
            msb.append("AAAAAAAA");
            msb.append("BBBBBBBB");
        }
        /*System's StringBuilder 5ms
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 1000;i++){
            sb.append("AAAAAAAA");
            sb.append("BBBBBBBB");
        }
        */

        /*No cache: 10,000 ms
        String s = "";
        for(int i = 0;i < 10000;i++){
            s += "AAAAAAAA";
            s += "BBBBBBBB";
        }*/
        //System.out.println(msb.toString());
        long end = System.currentTimeMillis();
        System.out.println("duration:"+(end-start));
    }
}
