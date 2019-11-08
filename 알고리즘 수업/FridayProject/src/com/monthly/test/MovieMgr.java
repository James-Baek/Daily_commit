package com.monthly.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MovieMgr implements MovieInter {
	private ArrayList<Integer> list;
	private static MovieMgr instance = new MovieMgr();
	private static String fileName = "movie.dat";
	private MovieMgr() {
		super();
	}
	
	public static MovieMgr getInstance() {
		return instance;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(fileName);
			if(file.exists() && file.canRead()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				list = (ArrayList)ois.readObject();
			}else {
				list = new ArrayList<Integer>();
			}

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(ois != null)try {ois.close();}catch(Exception e) {}
			if(fis != null)try {fis.close();}catch(Exception e) {}
			
		}
	}

	@Override
	public void close() {
		save();
		System.exit(0);
	}
	
	public void save() {
		FileOutputStream fos =null;
		ObjectOutputStream
	}
	
	
}
