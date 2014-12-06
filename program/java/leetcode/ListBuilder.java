public class ListBuilder{
    //int[] input = {60,71,49,11,82,49,3,66};
    public ListNode create(int[] input){
        ListNode h, p, t;
        h = new ListNode(0);
        t = h;
        for(int i = 0;i < input.length;i++){
            p = new ListNode(input[i]);
            t.next = p;
            t = p;
        }
        return h.next;

    }

    public static void main(String[] args){
        int[] test = {60,71,48,11,82,49,3,66};
        ListBuilder lb = new ListBuilder();
        ListNode h = lb.create(test);
        ListNode p = h;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
        /* Build the LikedList*/

/*Reverse a Linked List
        */
        ReverseLinkedListII rll = new ReverseLinkedListII();
        p = rll.reverseBetween(h, 2, 5);
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

       /*Quick Sort 
        SortList sl = new SortList();
        //int[] test = {10,9,8,7,6,5,4,3,2,1};
        int[] test = {60,71,49,11,82,49,3,66};
        ListBuilder lb = new ListBuilder();
        ListNode l1 = lb.create(test); 
        ListNode p = sl.sortList(l1);
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
        */
        
        /*Insertion Sort
        InsertionSortList isl = new InsertionSortList();
        p = isl.insertionSortList(h);
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
        
        /*Merge Sort
        MergeSort ms = new MergeSort();
        p = ms.sortList(h);
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
          */
        
        /*Merge Two Sorted lists*/
        /*Build the testcase*/
        /*
        int[] test1 = {11,49,60,62,71};
        int[] test2 = {3,49,66,82};
        ListNode l1 = lb.create(test1); 
        ListNode l2 = lb.create(test2); 
        ListNode rst = MergeTwoSortedLists.mergeTwoLists(l1, l2);
        while(rst != null){
            System.out.print(rst.val + " ");
            rst = rst.next;
        }
        System.out.println();
        */


        /*Reorder list
        int[] test3 = {1,2,3};
        ListNode l3 = lb.create(test3);
        ReorderList.reorderList(l3);
        while(l3 != null){
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
        System.out.println();
        */

        /*AddTwoNumbers*/
        /*
        int[] al1 = {2,4,3};
        int[] al2 = {5,6,6,9,9};
        ListBuilder lb = new ListBuilder();
        ListNode l1 =  lb.create(al1);
        ListNode l2 =  lb.create(al2);
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l3 = atn.addTwoNumbers(l1, l2);
        ListNode p = l3;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
        */
        /*AddTwoNumbers*/

        /*ReverseNodesink-Group*/
        /*
        int[] test = {1,2};

        ListBuilder lb = new ListBuilder();
        ListNode l1 = lb.create(test); 
        ReverseNodesinkGroup rng = new ReverseNodesinkGroup();
        ListNode rst = rng.reverseKGroup(l1, 2);
        while(rst != null){
           System.out.print(rst.val + " ");
           rst = rst.next;
        }
        System.out.println(); 
        */
        /*ReverseNodesink-Group*/
        /*Rotate List*/
        /*
        int[] test = {1};
        ListBuilder lb = new ListBuilder();
        ListNode l1 = lb.create(test); 
        RotateList rl = new RotateList();
        ListNode rst = rl.rotateRight(l1, 1);
        while(rst != null){
           System.out.print(rst.val + " ");
           rst = rst.next;
        }
        System.out.println(); 
        */
        /*Rotate List*/
        /*Partition List*/
        //int[] test = {2,1};
        //int[] test = {1,4,3,2,5,2};
        /*
        int[] test = {2,0,4,1,3,1,4,0,3};
        ListBuilder lb = new ListBuilder();
        ListNode l1 = lb.create(test); 
        PartitionList pl = new PartitionList();
        ListNode rst = pl.partition(l1, 2);
        while(rst != null){
           System.out.print(rst.val + " ");
           rst = rst.next;
        }
        System.out.println(); 
        */
        /*Partition List*/
    }
}
