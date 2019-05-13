package fundamentals;

import java.util.Iterator;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月13日 下午4:46:54
 * Description: 算法 1.4 背包
*/
public class Bag<Item> implements Iterable<Item> {

	private Node first;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	private class BagIterator implements Iterator<Item> {

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
	
	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		++N;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}
	
	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}
	
	public static void main(String[] args) {
		Bag<Integer> bag = new Bag<>();
		
		bag.add(1);
		bag.add(2);
		bag.add(3);
		
		// 用迭代器而非 foreach 语句只为练手玩玩
		Iterator<Integer> bagIterator = bag.iterator();
		while(bagIterator.hasNext()) {
			System.out.println(bagIterator.next());
		}
	}

}
