package com.ssafy.day0809.chat.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	Socket s = null;
	BufferedReader kin = null, in=null; // kin은 키보드 인, in은 서버에서 오는 in
	PrintWriter out = null;
	
	public void go() {

		String str = null, msg = null;
		try {
			s = new Socket("127.0.0.1", 6767);
			out = new PrintWriter(s.getOutputStream(), true);
			kin = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			while( !(str = kin.readLine()).equals("x")) {
				out.println(str);
				msg = in.readLine();
				System.out.println("서버에서 받은 메시지 : "+msg);
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
