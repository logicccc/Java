import java.util.HashMap;
import java.util.Scanner;
/*
计算字符有几个
*/
public class Test2 {
	public static void main(String[] args) {
		System.out.println("输入：");
		String s = new Scanner(System.in).nextLine();
		HashMap<Character,Integer> map =  
		new HashMap<Character,Integer>();
		//
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			/*从map取字符c对应的计数值
			 * 有计数，得到计数值
			 * 没有计数，得到null值
			 */
			Integer count = map.get(c);
			//还没有该字符的计数值，它是第一个字符
			if (count == null) {
				map.put(c,1);
			}else {
				//已经有计数值，+1再放入
				map.put(c,count+1);
			}
		}
		System.out.println(map);
	}
}
