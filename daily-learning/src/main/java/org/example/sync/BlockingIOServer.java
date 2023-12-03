package org.example.sync;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: hanchaowei
 * @date 2023/12/3
 * @description: 阻塞IO
 */

public class BlockingIOServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(8080);
		System.out.println("启动服务,等待连接........");
		// 阻塞直到有连接
		Socket clientSocket = serverSocket.accept();
		System.out.println("客户端连接来了....");

		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println("收到数据: " + line);
		}
		reader.close();
		clientSocket.close();
		serverSocket.close();
	}















}
