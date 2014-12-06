import java.util.*;

public class ListTest{
    public static void main(String[] args){
//------//Time Measuring
/*---*/ long bt = System.currentTimeMillis();
/*---*/ long at;
/*---*/ long interval;
//------//Time Measuring

        ArrayList al = new ArrayList();
        al.add(5);
        al.add(8);
        al.add(1,"world");
        al.remove("world");
        al.remove(0);
        System.out.println(al.get(0));
        System.out.println(al.size());

        LinkedList ll = new LinkedList();
        ll.add(7);
        ll.add(8);
        ll.add(1,"linkedlist");
        ll.remove("linkedlist");
        ll.remove(0);
        System.out.println(ll.get(0));
        System.out.println(ll.size());

/*--performance testing--*/
/*--performance testing--*/

        for(int i=0;i<10000000;i++){
            al.add("alfoo");
            ll.add("llfoo");
        }
        al.add("last");
        ll.add("last");
/*---*/ bt = System.currentTimeMillis();
        //ll.remove(5000000);//30ms
        //ll.remove(9999998);//0ms
        //ll.remove(0);      //0ms
        //ll.remove("last"); //80ms
        //ll.remove("llfoo");//0ms
        //ll.get(5000000);   //28ms

        //al.remove(5000000);//5ms
        //al.remove(9999998);//0ms
        //al.remove(0);      //10ms
        //al.remove("last"); //70ms
        //al.remove("llfoo");//95ms
        al.get(5000000);     //0ms
        

        
//------//Time Measuring
/*---*/ at = System.currentTimeMillis();
/*---*/ interval = at - bt;
/*---*/ System.out.println(interval+"ms spent");
//------//Time Measuring
    }
}
