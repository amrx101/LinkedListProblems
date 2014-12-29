/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Test {
    public static void main(String[] args) {
        /*
         * List1 =  1->3->30->90->120->240->511
List2 =  0->3->12->32->90->125->240->249
         */
        LinkedList List1 = new LinkedList();
        int [] arr1 = {1,23,3,30,90,20,40};
        
        int [] arr2 = {0,3,12,32,90,125,240,249};
        LinkedList List2 = new LinkedList();
        for(int i = 0; i < arr1.length; i++){
            List1.add(arr1[i]);
        }
        List1.traverse();
        List1.MergeSort();
        List1.traverse();
        /*
        for(int i = 0; i < arr2.length;i++){
            List2.add(arr2[i]);
        }
        LinkedList list3 = new LinkedList();
        list3 = List1.getMax(List2, list3);
        list3.traverse();*/
    }
    
}
