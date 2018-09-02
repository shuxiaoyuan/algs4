package searching;

public class BST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private Node root;              // 二叉查找树的根结点
    
    private class Node {
        private Key key;            // 键
        private Value val;          // 值
        private Node left, right;   // 指向子树的链接
        private int N;              // 以该结点为根的子树中的结点总数
        
        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
        
    }
    
    @Override
    public void put(Key key, Value val) {
        // 查找 key，找到则更新它的值，否则为它创建一个新的结点
        root = put(root, key, val);
    }
    
    private Node put(Node x, Key key, Value val) {
        // 如果 key 存在于以 x 为根结点的子树中则更新它的值；
        // 否则将以 key 和 val 为键值对的新结点插入到孩子树中
        if(x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)         x.left = put(x.left, key, val);
        else if(cmp > 0)    x.right = put(x.right, key, val);
        else                x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public int size(Node x) {
        if(x == null)   return 0;
        else            return x.N;          
    }

    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        return get(root, key);
    }
    
    // 在以 x 为根结点的子树中查找并返回 Key 所对应的值
    // 如果找不到则返回 null
    private Value get(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)         return get(x.left, key);
        else if(cmp > 0)    return get(x.right, key);
        else                return x.val;
    }
    
    @Override
    public void show() {
        // TODO Auto-generated method stub
        System.out.println("二叉查找树（中序遍历）：");
        System.out.print("  (Key,Value): ");
        LDR(root);
        System.out.println();
    }
    
    private void LDR(Node x) {
        // 中序遍历打印结点键值对
        if(x == null) return;
        LDR(x.left);
        System.out.print("(" + x.key + "," + x.val + ")");
        LDR(x.right);
    }

}
