package com.ssafy.day0809.chat.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	Socket s = null;
	BufferedReader kin = null;
	PrintWriter out = null;
	
	public void go() {

		String str = null;
		try {
			s = new Socket("127.0.0.1", 6767);
			out = new PrintWriter(s.getOutputStream(), true);
			kin = new BufferedReader(new InputStreamReader(System.in));
			
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
