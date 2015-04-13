import java.util.*;

public class Sofa {
    public static void main(String[] args) {
        List<Pair> l = new ArrayList<Pair>();
        l.add(new Pair(2,3));
        l.add(new Pair(1,3));
        l.add(new Pair(4,3));
        l.add(new Pair(7,3));
        l.add(new Pair(4,6));
        l.add(new Pair(9,3));
        for(Pair p : l) {
            System.out.print(p.x + "," + p.y + " ");
        }
        System.out.println();

        Collections.sort(l);
        for(Pair p : l) {
            System.out.print(p.x + "," + p.y + " ");
        }
        System.out.println();
    }

}
    class MyComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            if(p1.x == p2.x) {
                return p1.y - p2.y;
            }
            else {
                return p1.x - p2.x;
            }
        }
    }
    class Pair implements Comparable {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Object o) {
            Pair b = (Pair) o;
            if(x == b.x) {
                return y - b.y;
            }
            else {
                return x - b.x;
            }
        }
    }

