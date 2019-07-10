public class Test {
	public static void main(String[] args) {
		System.out.println("---身份证号码---");
		f1();
		System.out.println("---固定电话号码---");
		f2();
	}

	
	private static void f1() {	
		System.out.println("请输入身份证号：");
		String s = new Scanner(System.in).nextLine();
		/*
		 *旧身份证号码15位数 
		 * 新身份证号码18位数
		 * 
		 * \d{15}|
		 * \b{15}|\d{17}
		 * \b{15}|\b{17}{\dxX}
		 * 正则表达式斜杠，写到java字符串中，都要用转义格式
		 * \\d{15}|\\d{17}[\\dxX]
		 */
		String regex = "\\d{15}|\\d{17}[\\dxX]";
		//判断字符串s能否与指定的正则表达式相匹配
		if (s.matches(regex)) {
			System.out.println("格式正确");
		}else {
			System.out.println("格式错误");
		}
	}
	
	
	private static void f2() {	
		System.out.println("请输入固定电话号码：");
		String s = new Scanner(System.in).nextLine();
		/*
		 * 1234567
		 * 12345678
		 * 010-1234567
		 * 0102-12345678
		 * (010)1234567
		 * (0102)12345678
		 * 
		 * \d{7,8}
		 * (区号)?\d{7,8}
		 * (\d{3,4}-|)?\d{7,8}
		 * (\d{3,4}-|\(\))?\d{7,8}
		 * (\d{3,4}-|\\(\\))?\\d{7,8}
		 */
		String regex = "(\\d{3,4}-|\\(\\d{3,4}\\))?\\d{7,8}";
		//判断字符串s能否与指定的正则表达式相匹配
		if (s.matches(regex)) {
			System.out.println("格式正确");
		}else {
			System.out.println("格式错误");
		}
	}
}
