import java.util.*;
import java.util.Calendar;
import java.io.*;

public class Helloworld{
    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeInMillis() % 1000000);  
        System.out.println((int)'a');
    }
}
