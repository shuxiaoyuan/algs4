package fundamentals;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月4日 上午10:03:00
 * Description: 算法核心原理：gcd(p, q) == gcd(q, p % q)
*/
public class GCD {

	public static int gcd(int p, int q) {
		if(q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(18, 4));
	}

}
