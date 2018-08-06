package search;

public class SearchTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        // 定义键值对数组
        String[] keys = {"S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E"};
        Integer[] vals = { 0,   1,   2,   3,   4,   5,   6,   7,   8,   9,  10,  11,  12};
        
        // 定义查找方式
        ST<String, Integer> ST = new SequentialSearchST<>();
        //ST<String, Integer> ST = new BinarySearchST<>(20);
        
        // 将键值对放入
        ST.puts(keys, vals);
        
        // 查看符号表内容
        ST.show();
        
        // 查找某个元素
        System.out.println("  A 对应的值为：" + ST.get("A"));
        
    }

}
