package searching;

// 用于查找测试的模板
public abstract class ST<Key, Value> {
    
    // 将键值对存入表中，若键已存在则更新其值（若值为空则将键 key 从表中删除）
    public abstract void put(Key key, Value val);
    
    // 获取键 key 对应的值（若键 key 不存在则返回 null）
    public abstract Value get(Key key);
    
    // 按顺序打印出符号表中的键值对
    public abstract void show();
    
    // 将 keys 数组和对应的 vals 数组依次 put 到符号表中
    public void puts(Key[] keys, Value[] vals) {
        for(int i = 0; i < keys.length; i++) {
            put(keys[i], vals[i]);
        }
    }
}
