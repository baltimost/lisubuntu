import java.util.*;

public class hello{
    public static void main(String[] args){
        List<Country> l = new ArrayList<Country>();
        l.add(new Country(1, "India"));
        l.add(new Country(4, "China"));
        l.add(new Country(3, "Nepal"));
        l.add(new Country(2, "Bhutan"));
        Collections.sort(l);
        for(Country x : l)
            System.out.print(x.id + "," + x.name + "  ");
        System.out.println();

        Collections.sort(l, new SortByNameComparator());
        for(Country x : l)
            System.out.print(x.id + "," + x.name + "  ");
        System.out.println();

        Integer li = new Integer(1000);
        String xx = "1000";
        Integer wb = new Integer(1001);
       // System.out.println(new Country(55, "lala").compareTo(li));
        System.out.println(li.compareTo(wb));
    }

    private static class Country implements Comparable{
        int id;
        String name;
        public Country(int id, String name){ this.id = id; this.name = name;}
        public int compareTo(Object o){
            Country country = (Country)o;
            return this.id - country.id; 
        }
    }
    private static class SortByNameComparator implements Comparator<Country>{
        public int compare(Country a, Country b){
            return a.name.compareTo(b.name);
        }
    }
}
