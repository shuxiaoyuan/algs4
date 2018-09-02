package searching;

public class RedBlackBST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private Node root;
    
    private class Node {    // 含有 color 变量的 Node 对象
        Key key;            // 键
        Value val;          // 相关联的值
        Node left, right;   // 左右子树
        int N;              // 这棵子树中的结点总数
        boolean color;      // 由其父结点指向它的链接的颜色
        
        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }
    
    @Override
    public void put(Key key, Value val) {
        // TODO Auto-generated method stub
        root = put(root, key, val);
    }
    
    private Node put(Node h, Key key, Value val) {
        if(h == null)   // 标准的插入操作，和父结点用红链接相连
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if(cmp < 0)         h.left = put(h.left, key, val);
        else if(cmp > 0)    h.right = put(h.right, key, val);
        else                h.val = val;
        
        if(isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right))     flipColors(h);
        
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
    
    private boolean isRed(Node x) {
        if(x == null) return false;
        return x.color == RED;
    }
    
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    
    public void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    
    public int size(Node x) {
        if(x == null) return 0;
        else return x.N;
    }
    
    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)         return get(x.left, key);
        else if(cmp > 0)    return get(x.right, key);
        else                return x.val;
    }
    
    @Override
    public void show() {
        // TODO Auto-generated method stub
        System.out.println("红黑二叉查找树（中序遍历）：");
        System.out.print("  (Key,Value): ");
        LDR(root);
        System.out.println();
    }
    
    private void LDR(Node x) {
        if(x == null) return;
        LDR(x.left);
        System.out.print("(" + x.key + "," + x.val + ")");
        LDR(x.right);
    }

}
