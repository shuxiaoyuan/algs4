package searching;

/**
 * Author: Sean Lee
 * Date&Time: 2019年6月7日 下午2:07:12
 * Description: P239 算法3.2 二分查找（基于有序数组）
*/
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    
    private Key[] keys;
    private Value[] values;
    private int N;
    
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    
    public int size() {
        return N;
    }
    
    public boolean isEmpty() {
        return N == 0;
    }
    
    public Value get(Key key) {
        if(isEmpty()) {
            return null;
        }
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        else {
            return null;
        }
    }
    
    public int rank(Key key) {
        return rankRecursive(key, 0, N-1);
    }
    
    private int rankRecursive(Key key, int lo, int hi) {
        if(hi < lo) {
            return lo;
        }
        int mid = lo + (hi-lo)/2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0) {
            return rankRecursive(key, lo, mid-1);
        }
        else if(cmp > 0) {
            return rankRecursive(key, mid+1, hi);
        }
        else {
            return mid;
        }
    }
    
    private int rankIterative(Key key) {
        int lo = 0, hi = N - 1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) {
                hi = mid - 1;
            }
            else if(cmp > 0) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }
        return lo;
    }
    
    public void put(Key key, Value value) {
        // 查找键，找到则更新值，否则创建新的元素
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for(int j = N; j > i; --j) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        ++N;
    }
    
}
