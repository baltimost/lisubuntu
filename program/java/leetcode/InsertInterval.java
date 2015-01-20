import java.util.*;

public class InsertInterval{
    /*My code
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
        List<Interval> output = new ArrayList<Interval>();
        int i = 0, j, start, end;
        if(intervals == null || newInterval == null)
            return output;
        for(; i < intervals.size() && newInterval.start > intervals.get(i).end;i++)
            output.add(intervals.get(i));
        start = i == intervals.size() ? newInterval.start : Math.min(intervals.get(i).start, newInterval.start);
        for(;i < intervals.size() && newInterval.end >= intervals.get(i).start;i++);
        end = i == 0 ? newInterval.end : Math.max(intervals.get(i - 1).end, newInterval.end);
        output.add(new Interval(start, end));
        for(;i < intervals.size();i++)
            output.add(intervals.get(i));
        return output;
    }*/ 
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
        if(intervals == null || newInterval == null)
            return intervals;
        List<Interval> output = new ArrayList<Interval>();
        int insertIndex = 0;
        boolean added = false;
        for(Interval x: intervals){
            if(newInterval.start > x.end){
                output.add(x);
                insertIndex++;
            }
            else if(newInterval.end < x.start){
                if(!added){
                    output.add(newInterval);
                    added = true;
                }
                output.add(x);
            }
            else{
                newInterval.start = Math.min(x.start, newInterval.start);
                newInterval.end = Math.max(x.end, newInterval.end);
            }
        }
        //output.add(insertIndex, newInterval); 
        return output;
    }
    public static void main(String[] args){
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(3,5));
        input.add(new Interval(6,7));
        input.add(new Interval(8,10));
        input.add(new Interval(12,16));
        List<Interval> output = insert(input, new Interval(4,9));

        for(Interval x: output){
            System.out.println("["+x.start+","+x.end+"]");
        }
    }
}

class Interval{
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
