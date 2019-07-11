
import java.util.Random;

public class GuessLetterGame extends GuessGame {

	@Override
	public String suiJi() {
		// TODO 
		StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		// [i,26)
		for (int i = 0; i<5; i++) {
			int j = i + new Random().nextInt(26-i);
			char t = sb.charAt(i); //访问i位置字符
			//把i位置设置成j位置的字符
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, t);
		}
		sb.delete(5, 26); //删除后面字符，只保留前面5个
		System.out.println(sb);
		return sb.toString();//sb中的字符，创建成String字符
	}		
	@Override
	public void tiShi() {
		System.out.println("已经随机产生了5个不重复的大写字母");
		System.out.println("请猜这5个字母");
	}

	@Override
	public String biJiao(String c, String r) {
		// TODO 稍后完成
		int a = 0;
		int b = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				//i和j位置的字母相同
				if (c.charAt(i) == r.charAt(j)) {
					//字母相等的情况下，位置是否相等
					if (i == j) {
						a++;
					}else {
						b++;
					}
					break;
				}
			}
		}
		return a+"A"+b+"B";
	}

	@Override
	public boolean caiDui(String result) {
		return "5A0B".equals(result);
	}
}
