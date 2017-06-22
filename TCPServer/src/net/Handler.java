package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import control.Operator;
import util.Parser;

class Handler implements Runnable {
    
    private Socket tcpConn;

    public Handler(Socket tcpConn) {
        this.tcpConn = tcpConn;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("收到了客户端连接，来自" + tcpConn.getInetAddress() + ":" + tcpConn.getPort());
		
		try {
			Scanner netIn = new Scanner(tcpConn.getInputStream());
			OutputStream out = tcpConn.getOutputStream();
			String returnStr;
			
			while(true)
			{
				String receiveStr = netIn.nextLine();
				if(receiveStr.equals("exit"))
				{
					returnStr = "欢迎再次使用！";
					out.write(returnStr.getBytes());
					System.out.println("返回给客户端数据：" + returnStr);
					break;
				}
				else
				{
					Parser parser = new Parser();
					returnStr = parser.Parse(receiveStr);
					System.out.println("收到客户端数据：" + receiveStr);
					out.write(returnStr.getBytes());
					System.out.println("返回给客户端数据：" + returnStr);
				}
			}
			System.out.println("客户端:"+tcpConn.getInetAddress()+ ":" + tcpConn.getPort() +" 断开了！");
			out.close();
			tcpConn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}