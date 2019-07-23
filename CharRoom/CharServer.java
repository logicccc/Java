import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
//用来收集所有的通信线程实例
//接收到聊天数据后,要遍历通信线程实例,
//向所有客户端发送数据
private ArrayList<TongXinThread> list =
        new ArrayList<TongXinThread>();


public void launch() {
    new Thread() {
        @Override
        public void run() {
           try {
              //启动服务
              ServerSocket ss = new ServerSocket(8000);
              System.out.println("聊天室服务器已启动");
              while (true) {
                 Socket s = ss.accept();
                 System.out.println("一个客户端已连接");
                 TongXinThread t = new TongXinThread(s); 
                 t.start();
              }
           } catch (Exception e) {
              System.out.println(
              "不能在8000端口上启动服务,或者服务已经停止");
           }
        }
    }.start();
}

class TongXinThread extends Thread {

    Socket s;
    BufferedReader in;
    PrintWriter out;
    private String name;
    public TongXinThread(Socket s) {
       this.s = s;
    }

    public void send(String msg) {
        out.println(msg);
        out.flush();
    }

    public void sendAll(String msg) {
        synchronized (list) {
           for (TongXinThread t : list) {
              t.send(msg);
           }
        }
    }

    @Override
    public void run() {
        try {
           this.in = new BufferedReader(
            new InputStreamReader(
            s.getInputStream(), "UTF-8"));
           this.out = new PrintWriter(
            new OutputStreamWriter(
            s.getOutputStream(), "UTF-8"));           
           this.name = in.readLine();//接收昵称           
           send(name+",欢迎进入赞美涛哥聊天室");//发送欢迎信息
           //当前通信线程实例,加入list集合
           //加入集合后可以向他发送聊天内容
           synchronized (list) {
              list.add(this);
           }
           //群发一个上线消息
           sendAll(name+"进入了聊天室,在线人数:"+list.size());

           //开始接收他的聊天内容,并群发
           String line;
           while((line = in.readLine()) != null) {
        	   //获得客户端的ip地址
        	   InetSocketAddress addr =
        	     (InetSocketAddress)s.getRemoteSocketAddress();
        	     String ip = addr.getHostName();
        	   
              System.out.println(name+"说: "+line);
              sendAll(name+"说: "+line);
           }
           //null,断开
        } catch (Exception e) {
           //异常,断开
        }
        //删除当前通信线程实例
        synchronized (list) {
           list.remove(this);
        }
        //群发离线消息
        sendAll(name+"离开了聊天室,在线人数:"+list.size());
    }
}
public static void main(String[] args) {
    ChatServer server = new ChatServer();
    server.launch();
}
}
