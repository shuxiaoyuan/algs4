package searching;

// 二分查找（基于有序数组）
public class BinarySearchST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
    
    private Key[] keys;
    private Value[] vals;
    private int N = 0;
    
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }
    
    public int size() {
        return N;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        else {
            return null;
        }
    }
    
    // 小于 key 的数量
    public int rank(Key key) {
        //return rankR(key, 0, N-1);
        return rankI(key);
    }
    
    // 递归版二分
    public int rankR(Key key, int lo, int hi) {
        if(hi < lo) return lo; // 在 get(Key key) 中处理了这种情况
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0) {
            return rankR(key, lo, mid-1);
        }
        else if(cmp > 0) {
            return rankR(key, mid+1, hi);
        }
        else {
            return mid;
        }
    }
    
    // 迭代版二分
    public int rankI(Key key) {
        int lo = 0, hi = N - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) hi = mid - 1;
            else if(cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    
    @Override
    public void put(Key key, Value val) {
        // TODO Auto-generated method stub
        
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        
        // 将 i 往后的元素后移一格
        for(int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        
        // 将 key 放进 i 的位置        
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
        System.out.println("二分查找（基于有序数组）：");
        System.out.print("  (Key,Value): ");
        for(int i = 0; i < N; i++) {
            System.out.print("(" + keys[i] + "," + vals[i] + ")");
        }
        System.out.println();
    }
    
}
