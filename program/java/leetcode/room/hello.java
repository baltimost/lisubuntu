import java.util.*;
class interval{
    int start, end;
    public interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class hello{
    public static void main(String[] args){
        ArrayList<interval> test = new ArrayList<interval>();
        test.add(new interval(1,3));
        test.add(new interval(9,8));
        test.add(new interval(5,10));
        

        for(interval x: test)
            System.out.print(x.start + " ");
        System.out.println();
        Collections.sort(test, new IntervalComparator());
        for(interval x: test)
            System.out.print(x.start + " ");
        System.out.println();

        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("kaka");
        test2.add("maldini");
        test2.add("cafu");
        test2.add("drogba");
        test2.add("lampard");
        test2.add("maluda");
        test2.add("cronaldo");
        test2.add("cronaldohaha");
        Collections.sort(test2, new StringComparator());
        for(String x : test2)
            System.out.println(x + " ");
        System.out.println();


        String[] test3 = {"kaka","maldini","cafu","drogba","lampard","maluda","cronaldo","cronaldohaha"};
        Arrays.sort(test3);
        for(int i = 0;i < test3.length;i++)
            System.out.print(test3[i] + " ");
        System.out.println();
    }

    private static class IntervalComparator implements Comparator<interval>{
        public int compare(interval a, interval b){
            return a.start - b.start;
        }    
    } 
    private static class StringComparator implements Comparator<String>{
        public int compare(String a, String b){
            int i, j;
            for(i = 0, j = 0; i < a.length() && j < b.length();i++, j++){
                if(a.charAt(i) != b.charAt(j))
                    return a.charAt(i) - b.charAt(j);
            }
            if(i != a.length()) return 1;
            if(j != b.length()) return -1;
            return 0;
        }
    }
}
