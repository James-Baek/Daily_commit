package com.ssafy.day0809.chat.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.ssafy.day0809.chat.step1.IOUtil;

public class Server {
	ServerSocket ss = null;
	
	class ServerThread extends Thread{
		Socket s = null;
		BufferedReader in = null;
		PrintWriter out = null;
		public ServerThread(Socket s) throws IOException{
			this.s = s;
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(), true);
		}
		
		public void run() {
			String str = null;
			try {
				while((str = in.readLine()) != null) {
					System.out.println("서버3 : "+str);
					out.println("서버가 보냄 : "+str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				IOUtil.close(in);
				IOUtil.close(out);
				IOUtil.close(s);
			}
		}
	}
	
	public void go() {
		Socket s = null;
		try {
			ss = new ServerSocket(6767);
			while(true) {
				System.out.println("서버3 : 접속준비중.....");
				s = ss.accept();
				System.out.println(s.getInetAddress()+"이(가) 접속했습니다.");
				new ServerThread(s).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(s);
			IOUtil.close(ss);
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
		server.go();
	}

}
