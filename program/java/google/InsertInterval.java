import java.util.*;

public class InsertInterval {
    public static void insert(List<Interval> l, Interval interval) {
        for(int i = 0;i < l.size();) {
            if(interval.x > l.get(i).y) {
                i++;
            }
            else if(interval.y >= l.get(i).x) {
                interval.x = Math.min(interval.x, l.get(i).x);
                interval.y = Math.max(interval.y, l.get(i).y);
                l.remove(i);
            }
            else {
                l.add(i, interval);
                return;
            }
        }
    }
    static class Interval {
        int x, y;
        public Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<Interval> l = new ArrayList<Interval>();
        l.add(new Interval(0,1));
        l.add(new Interval(3,7));
        l.add(new Interval(10,11));
        l.add(new Interval(12,16));
        for(Interval in : l) {
            System.out.println(in.x +"," +in.y);
        }
        System.out.println();
        insert(l, new Interval(4,10));
        for(Interval in : l) {
            System.out.println(in.x +"," +in.y);
        }
    }
}
