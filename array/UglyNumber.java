import java.util.LinkedList;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		 System.out.println("求第几个丑数：");
		 int a = new Scanner(System.in).nextInt();
		 long r = f(a);
		 System.out.println(r);
	}
	
	private static long f(int n) {
	/*
	 * 
	 * ---------*2
	 * 
	 * ---------*3
	 * 
	 * ---------*5
	 * 
	 * 1. 取最小值
	 * 2. 乘2，3，5 放入三个集合
	 * 
	 * r = 2 3 4 5 6 8 9
	 */
	if (n==1) {
		return 1;
	}
	LinkedList<Long> L2 = new LinkedList<Long>();
	LinkedList<Long> L3 = new LinkedList<Long>();
	LinkedList<Long> L5 = new LinkedList<Long>();
    L2.add(2L);
    L3.add(3L);
	L5.add(5L);
	//保存每一次取出的丑数
	long r = 0;
	//从第2个，求到第n个
	for (int i =2; i<=n; i++) {
		long a = L2.getFirst();//访问头部值
		long b = L3.getFirst();//等同于get(0)
		long c = L5.getFirst();
		r = Math.min(a, Math.min(b,c));
		if(r == a) L2.remove(0);//删除头部值
		if(r == b) L3.remove(0);//等同于removeFirst
		if(r == c) L5.remove(0);
		//
		L2.add(r*2);
		L3.add(r*3);
		L5.add(r*5);
	}
	return r;
}
}
