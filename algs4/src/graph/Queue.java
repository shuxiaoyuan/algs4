package graph;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    
    private Node first; // 指向最早添加的结点的链接
    private Node last;  // 指向最近添加的结点的链接
    private int N;      // 队列中的元素数量
    
    private class Node {
        Item item;
        Node next;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        return N;
    }
    
    public void enqueue(Item item) {
        // 向表尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }          
        N++;
    }
    
    public Item dequeue() {
        // 从表头删除元素
        Item item = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }
    
    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        
    }
    
}
