package com.ssafy.day0809.chat.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	class ClientThread extends Thread{
		Socket s;
		BufferedReader in;
		String name;
		public ClientThread(Socket s) throws IOException {
			this.s = s;
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		}
		
		public void run() {
			String msg = null;
			try {
				System.out.println(in.readLine());
				name = in.readLine();
				out.println(name);
				while((msg = in.readLine()) != null) {
					System.out.println(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				IOUtil.close(in);
				IOUtil.close(s);
			}
		}
	}
	
	Socket s = null;
	BufferedReader kin = null; // kin은 키보드 인, in은 서버에서 오는 in
	PrintWriter out = null;
	
	public void go() {

		String str = null;
		try {
			s = new Socket("70.12.108.80", 6767);
			out = new PrintWriter(s.getOutputStream(), true);
			kin = new BufferedReader(new InputStreamReader(System.in));
			
			new ClientThread(s).start();
			System.out.println();
			while( !(str = kin.readLine()).equals("x")) {
				out.println(str);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(kin);
			IOUtil.close(out);
			IOUtil.close(s);
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.go();


	}

}
