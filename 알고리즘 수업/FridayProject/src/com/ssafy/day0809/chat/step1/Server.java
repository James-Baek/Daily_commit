package com.ssafy.day0809.chat.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket ss = null;
	Socket s = null;
	BufferedReader in = null;
	public void go() {
		String str = null;
		try {
			ss = new ServerSocket(6767);
			System.out.println("서버 : 접속준비중.....");
			s = ss.accept();
			System.out.println(s.getInetAddress()+"이(가) 접속했습니다.");
			
			
//			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			in = new BufferedReader(new InputStreamReader(s.getInputStream(), "MS949"));

			while((str = in.readLine()) != null) {
				System.out.println(str);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			IOUtil.close(in);
			IOUtil.close(s);
			IOUtil.close(ss);
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
		server.go();
	}

}
