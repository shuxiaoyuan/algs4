package fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月19日 下午5:18:44
 * Description: 
*/
public class UFTest {

    public static void main(String[] args) {
        try(
            FileInputStream fis = new FileInputStream("test_data/mediumUF.txt"))
//            FileInputStream fis = new FileInputStream("test_data/largeUF.txt"))
        {
            System.setIn(fis);
            int N = StdIn.readInt();        // 读取触点数量
            UF uf = new QuickFind(N);
//            UF uf = new QuickUnion(N);
//            UF uf = new WeightedQuickUnionUF(N);
//            UF uf = new WeightedQuickUnionPathCompressionUF(N);
            Stopwatch stopwatch = new Stopwatch();
            while(!StdIn.isEmpty()) {
                int p = StdIn.readInt();
                int q = StdIn.readInt();    // 读取整数对
                if(uf.connected(p, q)) {    // 如果已经连通则忽略
                    continue;
                }
                uf.union(p, q);             // 归并分量
//                StdOut.println(uf.count() + " " + q);
            }
            StdOut.println(uf.count() + " components, " + stopwatch.elapsedTime() + "s");
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
