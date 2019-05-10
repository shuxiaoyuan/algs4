package fundamentals;

import java.util.Iterator;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月10日 上午9:39:36
 * Description: P88 算法 1.1 下压（LIFO）栈（能够动态调整数组大小的实现）
*/
public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = N;
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
		
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0; i < N; ++i) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void push(Item item) {
		// 将元素添加到栈顶
		if(N == a.length) {
			resize(a.length * 2);
		}
		a[N++] = item;
	}
	
	public Item pop() {
		// 从栈顶删除元素
		Item item = a[--N];
		a[N] = null;	// 避免对象游离（见 1.3.2.4 节）
		if(N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	public static void main(String[] args) {
		ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack<>();
		
		resizingArrayStack.push("AAA");
		resizingArrayStack.push("BBB");
		resizingArrayStack.push("CCC");
		
		// foreach 遍历
		for(String string : resizingArrayStack) {
			System.out.println(string);
		}
		System.out.println("------");
		
		// 迭代器遍历，和上面的 foreach 语句等价，推荐使用 foreach 语句，详见本书 P86
		Iterator<String> iterator = resizingArrayStack.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("------");
		
		System.out.println(resizingArrayStack.pop());
	}

}
