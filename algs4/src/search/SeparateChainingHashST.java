package search;

/**
 *  基于拉链法的散列表
 *  依赖于 SequentialSearchST 类
 * 
 */
public class SeparateChainingHashST<Key, Value> extends ST<Key, Value> {
    
    private int N;  // 键值对总数
    private int M;  // 散列表的大小
    private SequentialSearchST<Key, Value>[] st; // 存放链表对象的数组
    
    public SeparateChainingHashST() {
        this(997);
    }
    
    public SeparateChainingHashST(int M) {
        // 创建 M 条链表
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for(int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }
    
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    @Override
    public void put(Key key, Value val) {
        // TODO Auto-generated method stub
        st[hash(key)].put(key, val);
    }

    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        return (Value) st[hash(key)].get(key);
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        System.out.println("基于拉链法的散列表查找：");
        for(int i = 0; i < M; i++) {
            if(st[i].size() != 0) {
                System.out.print("(st[" + i + "])");
                st[i].show();
            }
        }
    }

}
