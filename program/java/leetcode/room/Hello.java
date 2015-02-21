import java.util.*;

public class Hello{
    public static void main(String[] args){
        List<String> l = new ArrayList<String>();
        l.add("kaka");
        l.remove("hello");
        throw new MyException();
    }
}

