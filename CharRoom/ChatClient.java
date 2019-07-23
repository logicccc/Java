import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ChatClient {
	private Socket s;
	private BufferedReader in;
	private PrintWriter out;
	private String name;
	private LinkedList<String> list =
			new LinkedList<String>();
	private boolean inputFlag; //默认false,没有数据

	public void launch() {
		try {
			//选一位同学开服务器
			this.s = new Socket("176.114.11.127",8000);
			this.in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
			this.out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));         

			//昵称
			System.out.print("起一个昵称:");
			this.name = new Scanner(System.in).nextLine();
			out.println(name);
			out.flush();      
			//启动输入线程
			new Thread() {
				@Override
				public void run() {
					input();
				}
			}.start();

			//启动接收线程
			new Thread() {
				@Override
				public void run() {
					receive();
				}
			}.start();

			//打印线程
			new Thread() {
				@Override
				public void run() {
					print();
				}
			}.start();

		} catch (Exception e) {
			System.out.println("无法连接服务器");
		}
	}

	protected void print() {
		while (true) {
			synchronized (list) {
				//没有数据时,暂停等待
				while (list.size()==0 || inputFlag) {
					try {
						list.wait();
					} catch (InterruptedException e) {
					}
				}

				//消费者,从集合移出数据,打印
				String s = list.removeFirst();
				System.out.println(s);
			}
		}
	}

	protected void receive() {
		try {
			String line;
			while((line = in.readLine()) != null) {
				//System.out.println(line);
				//生产者,把收到的数据,存入集合
				synchronized (list) {
					list.add(line);
					list.notify();//通知打印线程,有数据了
				}
			}
		} catch (Exception e) {
		}

		System.out.println("已经与聊天室服务器断开连接");
	}

	protected void input() {
		System.out.println("按回车输入聊天内容");
		while (true) {
			new Scanner(System.in).nextLine();
			inputFlag = true;//打开开关
			System.out.print("输入聊天内容:");
			String s = new Scanner(System.in).nextLine();
			out.println(s);
			out.flush();

			inputFlag = false;//关闭开关
			synchronized (list) {
				//通知打印线程,输入结束,可以继续打印
		    	list.notify();
			}
		}
	}

	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.launch();
	}

}
