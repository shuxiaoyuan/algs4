package sorting;

public abstract class Sort {
    /**
     * 模板函数
     */
	public abstract void sort(Comparable[] a);
	
	
    /**
     * 辅助函数
     */
	
    // 比较(小于)
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    // 交换
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    // 打印
    public static void show(Comparable[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    // 判断是否有序
    public static boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length; i++) {
            if(less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }
}
