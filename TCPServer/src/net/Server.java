package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	private int port = 1234;
	private final int POOL_SIZE = 10;
	private ExecutorService executorService;
	
	
	public Server()
	{
		try {
			ServerSocket ss = new ServerSocket(port);
			executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
	                .availableProcessors() * POOL_SIZE);
			System.out.println("服务器启动了，等待客户端连接...");
			
			while(true)
			{
				Socket tcpConn = ss.accept();
				executorService.execute(new Handler(tcpConn));
			}			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}
}