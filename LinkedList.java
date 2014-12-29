/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class LinkedList {
    
    private class Node{
        private int data;
        private Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
        public Node (){
            
        }
    }
    
    private Node Head;
    private Node tail;
    
    public LinkedList(){};
    
    public void add(int data){
        Node newNode = new Node(data);
        add(newNode);
        
    }
    // create a linked list that has maximum components from 2 lists
    public LinkedList getMax(LinkedList second, LinkedList result){
        Node current1 = this.Head;
        Node current2 = second.getHead();
        Node previous1 = current1;
        Node previous2 = current2;
        while((current1.next != null)&& (current2.next != null)){
            int sum1 = 0;
            int sum2 = 0;
            while((current1.data != current2.data)&&(current1 != null)&&(current2 != null)){
                if(current1.data < current2.data){
                    sum1 += current1.data;
                    current1 = current1.next;
                }
                if(current1.data > current2.data){
                    sum2 += current2.data;
                    current2 = current2.next;
                }
            }
            if(sum1 >= sum2){
                while(previous1 != current1){
                    result.add(previous1.data);
                    previous1 = previous1.next;
                }
                result.add(previous1.data);
            }
            if(sum1 < sum2){
                while (previous2 != current2){
                    result.add(previous2.data);
                    previous2 = previous2.next;
                }
                result.add(previous2.data);
            }
            if(current1.next != null){
                current1 = current1.next;
            }
            if(current2.next != null){
                current2 = current2.next;
            }
            previous1 = current1;
            previous2 = current2;
            
        }
        if(current1 != null && current2 != null){
            if(current1.data > current2.data){
                while(current1 != null){
                    result.add(current1.data);
                    current1 = current1.next;
                }
            }
            else{
                while(current2 != null){
                    result.add(current2.data);
                    current2 = current2.next;
                }
            }
        }
        else if(current1 != null && current2 == null){
            while(current1 != null){
                result.add(current1.data);
                current1 = current1.next;
            }
        }
        else/*(current2 != null&& current1 == null)*/{
            while(current2.next != null){
                result.add(current2.data);
                current2 = current2.next;
            }
            result.add(current2.data);
            
        }
        
        return result;
    }
    private void add(Node newNode){
        if(Head == null){
            addAtHead(newNode);
            tail = Head;
        }
        else{
            addAtTail(newNode);
        }
        
    }
    public Node getHead(){
        return this.Head;
    }
    public void addAtHead(int data){
        Node newNode = new Node(data);
        addAtHead(newNode);
    }
    private void addAtHead(Node newNode){
        newNode.next = Head;
        
        Head = newNode;
    }
    private void addAtTail(Node newNode){
        tail.next = newNode;
        tail = newNode;
    }
    public void traverse(){
        traverse(Head);
        System.out.println("");
    }
    private void traverse(Node Head){
        while(Head != null){
            System.out.print(Head.data+" ");
            Head = Head.next;
        }
    }
    public void MergeSort(){
        this.Head = MergeSort(Head);
    }
    private Node MergeSort(Node Head){
        if(Head == null || Head.next == null){
            return Head;
        }
        Node Middle = getMiddle(Head);
        Node Second = Middle.next;
        Middle.next = null;
        MergeSort(Head);
        MergeSort(Second);
        return Merge(Head, Second);
    }
    
    private Node Merge(Node First, Node Second){
         Node dummyHead, curr; dummyHead = new Node(); curr = dummyHead;
        while(First !=null && Second!= null) {
            if(First.data <= Second.data) { curr.next = First; First = First.next; }
            else { curr.next = Second; Second = Second.next; }
            curr = curr.next;
        }
        curr.next = (First == null) ? Second : First;
        return dummyHead.next;
    }
    
    private Node getMiddle(Node Head){
        if(Head == null){
            return Head;
        }
        Node Slow;
        Node Fast;
        Slow = Head;
        Fast = Head;
        while(Fast.next != null && Fast.next.next != null){
            Slow = Slow.next;
            Fast = Slow.next;
            
            
        }
        return Slow;
    }
    
    
}
