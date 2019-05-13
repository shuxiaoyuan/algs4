package fundamentals;

import java.util.Iterator;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月13日 下午4:06:49
 * Description: 算法 1.3 先进先出队列
*/
public class Queue<Item> implements Iterable<Item> {

	private Node first;	// 首结点
	private Node last;	// 尾节点
	private int N;		// 元素数量
	private class Node {
		Item item;
		Node next;
	}
	private class QueueIterator implements Iterator<Item> {

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
	
	public void enqueue(Item item) {
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
		++N;
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		--N;
		if(isEmpty()) {
			last = null;
		}
//		--N;				// 书中写在这里，私以为这样虽无 bug ，然会使 last 指向的对象保留，影响垃圾回收
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		
		queue.enqueue(1);
		queue.enqueue(2);
		
		for(int a : queue) {
			System.out.println(a);
		}
		
		System.out.println("------");
		System.out.println("dequeue: " + queue.dequeue());
	}

}
