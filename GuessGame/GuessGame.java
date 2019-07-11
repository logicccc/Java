import java.util.Scanner;

public abstract class GuessGame {
	//启动游戏，执行游戏主流程
	public void start() {
		//产生一个随机值，不同，就调方法
		String r = suiJi();
		//游戏开始的提示
		tiShi();
		while (true) {
			System.out.println("猜: ");
			String c = new Scanner(System.in).nextLine();
			//比较猜的值c和随机值r，并得到比较结果
			String result = biJiao(c, r);
			System.out.println(result);
			//判断result是否是猜对的结果
				if (caiDui(result)) {
					break;
				}
			}
		}

	public abstract String suiJi();
	public abstract void tiShi();   
	public abstract String biJiao(String c, String r); 
	public abstract boolean caiDui(String result);	
	 
}


