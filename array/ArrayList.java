import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class test1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
	list.add(888);
	list.add(333);
	list.add(222);
	list.add(444);
	list.add(999);
	list.add(111);

	System.out.println(list.size());
	System.out.println(list);
	System.out.println(list.get(4));
	//调用remove(int) 通过下标删除
	System.out.println(list.remove(4));
	System.out.println(list);
	//调用remove(object) 寻找相等数据删除
	System.out.println(list.remove(Integer.valueOf(999)));
	System.out.println(list);
	//
	for (int i =0; i <list.size(); i++) {
		System.out.println(list.get(i));
	}
	System.out.println("-------");
	//
	for (Iterator<Integer> it = list.iterator();;) {
		Integer i = it.next();
		System.out.println(i);
	}
	
//	Iterator<Integer> it = list.iterator();
//	while (it.hasNext()) {
//		Integer i = it.next();
//		System.out.println(i);
//	}
	
	}

}
