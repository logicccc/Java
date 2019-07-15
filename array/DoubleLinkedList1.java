import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		/*
		 * <> 泛型
		 * 限制集合中存放的数据类型
		 *  
		 * 泛型和集合，都不支持基本类型
		 */
//		LinkedList<String> list = new LinkedList<>();
		LinkedList<String> aa =new LinkedList<>();
		aa.add("Hello world");
		aa.add("AAA");
		aa.add("BBB");
		aa.add("CCC");
		aa.add("DDD");
		aa.add("EEE");
		aa.add("FFF");
		aa.add("GGG");
		System.out.println(aa.size());
		System.out.println(aa);
		System.out.println(aa.get(0));
		System.out.println(aa.get(aa.size()-2));
		System.out.println(aa.remove(4));
		System.out.println(aa);
		System.out.println(aa.remove("aa"));
		System.out.println(aa);
		System.out.println(aa.remove("xxxxxx"));
		//双向链表下标遍历，效率低
		for (int i =0; i< aa.size(); i++) {
			System.out.println(aa.get(i));
		}
		System.out.println("---------------");
		
		//双向链表，迭代器遍历效率高
		//新建迭代器实例
		Iterator<String> it = aa.iterator();
		//当还有数据，取下一项数据
		while (it.hasNext()) {//hasNext判断还有没下一个
			String s = it.next();
			System.out.println(s);
		}
	}
}
