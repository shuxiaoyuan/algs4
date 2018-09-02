package searching;

public class LinearProbingHashST<Key, Value> extends ST<Key, Value> {

    private int N;          // 符号表中键值对的总数
    private int M = 16;     // 线性探测表的大小
    private Key[] keys;     // 键
    private Value[] vals;   // 值    
    
    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }
    
    public LinearProbingHashST(int cap) {
        M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }
    
    @Override
    public void put(Key key, Value val) {
        if(N >= M/2) resize(2 * M);
        int i;
        
        // 线性探测
        for(i = hash(key); keys[i] != null; i = (i + 1) % M) {
            // key 相等则更新值
            if(keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        
        // 直到无碰撞（即遇到空位置），填入值
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    
    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(cap);
        for(int i = 0; i < M; i++) {
            if(keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        M = t.M;
        keys = t.keys;
        vals = t.vals;
    }
    
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        for(int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if(keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    @Override
    public void show() {
        System.out.println("基于线性探测的符号表：");
        System.out.print("  [i](Key,Value): ");
        boolean j = false; // 打印标记
        for(int i = 0; i < M; i++) {
            if(keys[i] != null) {
                if(j) {
                    System.out.print("->");
                }
                System.out.print("[" + i + "](" + keys[i] + "," + vals[i] + ")");
                j = true;
            }
        }
        System.out.println();
    }
    
}
