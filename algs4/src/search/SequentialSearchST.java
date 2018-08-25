package search;

// 顺序查找（基于无序链表）
public class SequentialSearchST<Key, Value> extends ST<Key, Value> {
    
    private int n = 0;  // 链表的长度
    private Node first; // 链表首结点

    private class Node { // 链表结点的定义
        Key key;
        Value val;
        Node next;
        
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
        
    }
    
    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }
    
    @Override
    public void put(Key key, Value val) {
        // TODO Auto-generated method stub
        
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) { // 命中，更新
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first); // 未命中，新建结点
        n++;
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
        System.out.println("顺序查找（基于无序链表）：");
        System.out.print("  (Key,Value): ");
        for(Node x = first; x != null; x = x.next) {
            if(x != first) {
                System.out.print("->");
            }
            System.out.print("(" + x.key + "," + x.val + ")");
        }
        System.out.println();
    }
    
    public int size() {
        return n;
    }
    
}
