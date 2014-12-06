import java.util.*;

public class MapTest{
    public static void main(String[] args){
//------//Time Measuring
/*---*/ long bt = System.currentTimeMillis();
/*---*/ long at;
/*---*/ long interval;
//------//Time Measuring
        HashMap hm = new HashMap();
        //add
        hm.put(22,"Kaka");
        hm.put(7,"Beckham");
        hm.put(5,"Fan");
        //change
        hm.put(7,"Raul");
        //search
        System.out.println(hm.get(7));
        //delete
        hm.remove(5);

        Hashtable ht = new Hashtable();
        //add
        ht.put(1,"Toldo");
        ht.put(2,"Yao Lijun");
        ht.put(3,"Chen Yaodong");
        //change
        ht.put(1,"Wang Dalei");
        //search
        System.out.println(ht.get(1));
        //delete
        ht.remove(2);

        for(int i = 0;i<1000000;i++){
            hm.put(i,i+2);
            ht.put(i,i+2);
        }
        /*
        for(Iterator i = hm.keySet().iterator();i.hasNext();){
            Object key = i.next();
            System.out.println(key+":"+hm.get(key));
        }
        */
        bt = System.currentTimeMillis();
        //hm.get(500000);
        //hm.remove(500000);//0ms
        //ht.remove(500000);//0ms
        //hm.put(500000,"middle");//0ms
        //hm.put("kk","middle");//290ms
        //hm.put(1000000,"middle");//1ms
        //hm.put(1000007,"middle");//1ms
          hm.put(1050000,"middle");//280ms
        System.out.println(hm.size());
        

//------//Time Measuring
/*---*/ at = System.currentTimeMillis();
/*---*/ interval = at - bt;
/*---*/ System.out.println(interval+"ms spent");
    }
}
