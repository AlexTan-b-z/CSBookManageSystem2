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
		System.out.println("�յ��˿ͻ������ӣ�����" + tcpConn.getInetAddress() + ":" + tcpConn.getPort());
		
		try {
			Scanner netIn = new Scanner(tcpConn.getInputStream());
			OutputStream out = tcpConn.getOutputStream();
			String returnStr;
			
			while(true)
			{
				String receiveStr = netIn.nextLine();
				if(receiveStr.equals("exit"))
				{
					returnStr = "��ӭ�ٴ�ʹ�ã�";
					out.write(returnStr.getBytes());
					System.out.println("���ظ��ͻ������ݣ�" + returnStr);
					break;
				}
				else
				{
					Parser parser = new Parser();
					returnStr = parser.Parse(receiveStr);
					System.out.println("�յ��ͻ������ݣ�" + receiveStr);
					out.write(returnStr.getBytes());
					System.out.println("���ظ��ͻ������ݣ�" + returnStr);
				}
			}
			System.out.println("�ͻ���:"+tcpConn.getInetAddress()+ ":" + tcpConn.getPort() +" �Ͽ��ˣ�");
			out.close();
			tcpConn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}