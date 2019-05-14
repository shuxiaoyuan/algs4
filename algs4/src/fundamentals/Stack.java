package fundamentals;

import java.util.Iterator;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月13日 下午3:17:35
 * Description: P94 算法 1.2 下压堆栈（链表实现）
*/
public class Stack<Item> implements Iterable<Item> {

	private Node first;		// 栈顶结点
	private int N;			// 栈中结点数量
	private class Node {
		Item item;
		Node next;
	}
	
	private class StackIterator implements Iterator<Item> {

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
	
	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		++N;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		--N;
		return item;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		
		for(int a : stack) {
			System.out.println(a);
		}
		
		System.out.println("------");
		System.out.println("pop:" + stack.pop());
		
	}
	
}
