import java.util.*;

public class MergeIntervals{
    /*TLE
    public static List<Interval> merge(List<Interval> intervals){
        for(int i = 0;i < intervals.size();i++){
            for(int j = i + 1;j < intervals.size();j++){
                System.out.println("i=" + i + "j=" + j);
                if(intervals.get(j).start >= intervals.get(i).start &&
                   intervals.get(j).start <= intervals.get(i).end
                   ){
                    if(intervals.get(j).end > intervals.get(i).end)
                        intervals.get(i).end = intervals.get(j).end;
                    intervals.remove(j);
                    j--;
                }
            }
        }
        return intervals;
    }
    */
    public List<Interval> merge(List<Interval> intervals){
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> output = new ArrayList<Interval>();
        Interval curr = intervals.get(0); 
        Interval next = null; 
        for(int i = 1;i < intervals.size();i++){
            next = intervals.get(i);
            if(curr.end >= next.start)
                curr.end = Math.max(curr.end, next.end);
            else{
                output.add(curr);
                curr = next;
            }
        }
        output.add(curr);
        return output;
    }

    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }
    public static void main(String[] args){
        MergeIntervals mi = new MergeIntervals();
        List<Interval> test = new ArrayList<Interval>();
        test.add(new Interval(1,3));
        test.add(new Interval(2,6));
        test.add(new Interval(2,3));
        test.add(new Interval(8,10));
        test.add(new Interval(15,18));

        for(Interval x: test){
            System.out.print("["+x.start +","+x.end+"] ");
        }
        System.out.println();

        List<Interval> output = mi.merge(test);

        for(Interval x: output){
            System.out.print("["+x.start +","+x.end+"] ");
        }
        System.out.println();

        for(Interval x: test){
            System.out.print("["+x.start +","+x.end+"] ");
        }
        System.out.println();


    }
}

class Interval{
    int start;
    int end;
    Interval(){ start = 0; end = 0;}
    Interval(int s, int e) { start = s; end = e; }
}
