/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Node 
{
    int data; 
    ListNode listnode; 
    int index ; 
    public Node()
    {
        this.data = 0; 
        this.listnode = null; 
        this.index = -1;
    }
    public Node(int data , ListNode ptr, int index )
    {
        this.data = data; 
        listnode = ptr; 
        this.index = index; 
    }
    public Node(Node node)
    {
        data = node.data;
        listnode = node.listnode; 
        index = node.index ;
    }
}
class minHeap
{
    Node[] heapArray; 
    int heapSize;
    int capacity;
    
    public minHeap(int cap)
    {
        heapArray = new Node[cap];
        for(int i= 0;i< cap; i++)
        {
            heapArray[i] = new Node();
        }
        heapSize = 0; 
        capacity = cap;
    }
    public boolean isEmpty()
    {
        if(heapSize == 0 ) return true; 
        return false; 
    }
    public int getParent(int index)
    {
        return (index - 1 ) / 2; 
    }
    public int getLeftChild(int index ) {
        return (2*index + 1); 
    }
    public int getRightChild(int index ) {
        return (2*index +2) ; 
    }
    public boolean isLeaf(int index )
    {
        if(index >= heapSize/2 && index < heapSize )
         return true; 
        return false; 
    }
    public void copy(int i, Node node)
    {
        heapArray[i].data = node.data; 
        heapArray[i].listnode = node.listnode; 
        heapArray[i].index = node.index;
    }
    public void heapify(int index )
    {
        if(isLeaf(index) == true) return ; 
        int li = getLeftChild(index); 
        int ri = getRightChild(index); 
        int i = li; 
        if(ri<= heapSize -1 && heapArray[i].data > heapArray[ri].data )
        {
            int temp = i; 
            i = ri; 
            ri = temp;
        }
        if(heapArray[i].data < heapArray[index].data)
        {
            Node temp = heapArray[i];
            heapArray[i] = heapArray[index];
            heapArray[index] = temp ;
            heapify(i);
        }
        return; 
    }
    public Node getMin()
    {
        if(heapSize == 1) 
        {
            heapSize = heapSize - 1; 
            return heapArray[heapSize];
        }
        Node temp = heapArray[0];
        //System.out.println(temp.data);
        heapArray[0]= heapArray[heapSize -1];
        heapArray[heapSize - 1 ] = temp;
        heapSize = heapSize - 1; 
        heapify(0);
        return temp; 
    }
    public void insert(Node node )
    {
        copy(heapSize , node);
        /*heapArray[heapSize].data = node.data; 
        heapArray[heapSize].index = node.index; 
        heapArray[heapSize].listnode = node.listnode; */
        int curr = heapSize; 
        while(heapArray[curr ].data < heapArray[getParent(curr)].data)
        {
            Node temp = heapArray[curr];
            heapArray[curr] = heapArray[getParent(curr)];
            heapArray[getParent(curr)] = temp;
            curr = getParent(curr);
        }
            heapSize = heapSize + 1; 
       // heapify(heapSize - 1);
    }
    public void printMinHeap()
    {
        for(int i= 0; i<heapSize ; i++ )
        {
            System.out.print(heapArray[i].data+" ");
        } System.out.println();
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null; 
        ListNode tail = null; 
        int size = lists.length; 
        minHeap heap = new minHeap(size);
        for(int i = 0; i< size ; i++ ) 
        {
            if(lists[i]==null) continue; 
            Node node = new Node(lists[i].val, lists[i], i);
            heap.insert(node); 
            //heap.printMinHeap();
        }
        
        while(heap.isEmpty()!=true)
        {
            heap.printMinHeap();
            Node top = heap.getMin();
            if(head == null ) {
                head = new ListNode(top.data);
                tail = head; 
            }
            else 
            {
                tail.next = new ListNode(top.data);
                tail = tail.next; 
            }
            int i = top.index; 
            if(lists[i].next!= null ) 
            {
                lists[i]= lists[i].next; 
                heap.insert(new Node(lists[i].val, lists[i], i));
            }
        }
        return  head; 
    }
   
}
