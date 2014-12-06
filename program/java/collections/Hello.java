import java.util.*;

public class Hello{
    public static void main(String[] args){
        HashSet<String> s = new HashSet<String>();
        s.add("hello");
        s.add("world");
        for(Iterator i = s.iterator();i.hasNext();){
            String word = (String)i.next();
            System.out.println(word);
        }
    }
}
