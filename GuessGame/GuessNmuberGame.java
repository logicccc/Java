import java.util.Random;

public class GuessNmuberGame extends GuessGame {

	@Override
	public String suiJi() {
		// 1+ [0, 1000) 左闭右开
		int r = 1 + new Random().nextInt(1000);
		// int转成String
		return String.valueOf(r);
	}

	@Override
	public void tiShi() {
		System.out.println("已经随机产生了[1,1001)范围的整数");
		System.out.println("请猜这个数是几");

	}

	@Override
	public String biJiao(String c, String r) {
		// String 转成 int
		int cc = Integer.parseInt(c);
		int rr = Integer.parseInt(r);
		if (cc > rr) {
			return "大";
		} else if (cc < rr) {
			return "小";
		} else {
			return "对";
		}
	}

	@Override
	public boolean caiDui(String result) {
		return "对".equals(result);
	}
}
