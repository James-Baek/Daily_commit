package com.ssafy.step2.movie;

import java.util.Arrays;

import com.ssafy.step1.car.Car;

public class MovieMgr {
	private Movie[] movies;
	private int index;
	private static MovieMgr instance = new MovieMgr();
	
	private MovieMgr() {
		super();
	}
	
	public static MovieMgr getInstance() {
		return instance;
	}
	
	public void add(Movie m) {
		int idx = 0;
		if(movies == null) {
			this.movies = new Movie[1];
			movies[movies.length-1] = m;
		}else {
			if(m != null) {
				for(Movie temp : movies) {
					if(temp == null) {
						movies[idx] = m;
						System.out.println("영화 \'"+m.getTitle()+"\'가 추가됐습니다.");
						return;
					}
					if(m.getTitle().equals(temp.getTitle())) {
						System.out.println("이미 등록된 영화입니다.");
						return;
					}
					idx++;
				}
				movies = Arrays.copyOf(movies, movies.length+1);
				movies[movies.length-1] = m;
			}
		}
		System.out.println("영화 \'"+m.getTitle()+"\'가 추가됐습니다.");
	}
	
	public Movie[] search() {
		if(movies == null) {
			System.out.println("영화 정보가 하나도 없습니다.");
			return null;
		}
		System.out.println("####################### 모든 영화 정보 ########################");
		for(Movie temp : movies) {
			if(temp == null) {
				continue;
			}
			System.out.println(temp.toString());
		}
		return movies;
	}
	
	public Movie[] search(String title) {
		if(movies == null) {
			System.out.println("######### 요청하신 \'"+title+"\' 이(가) 포함된 영화가 없습니다. #########");
			return null;
		}
		boolean isFind = false;
		String txtfindList = "";
		Movie[] findList = new Movie[movies.length];
		int idx = 0;
		
		for(Movie temp : movies) {
			if(temp == null) {
				continue;
			}
			if(temp.getTitle().contains(title)) {
				isFind = true;
				findList[idx] = temp;
				txtfindList += temp.toString()+"\n";
				idx++;
			}
		}
		if(isFind) {
			System.out.println("######### 요청하신 \'"+title+"\' 이(가) 포함된 영화정보입니다. #########");
			System.out.print(txtfindList);
			findList = Arrays.copyOf(findList, idx+1);
			return findList;
		}else {
			System.out.println("######### 요청하신 \'"+title+"\' 이(가) 포함된 영화가 없습니다. #########");
			return null;
		}
	}
	
	public Movie[] searchDirector(String name) {
		boolean isFind = false;
		String txtfindList = "";
		Movie[] findList = new Movie[movies.length];
		int idx = 0;
		
		for(Movie temp : movies) {
			if(temp == null) {
				continue;
			}
			if(temp.getDirector().equals(name)) {
				isFind = true;
				findList[idx] = temp;
				txtfindList += temp.toString()+"\n";
				idx++;
			}
		}
		if(isFind) {
			System.out.println("######### 요청하신 \'"+name+"\' 감독의 영화정보입니다. #########");
			System.out.print(txtfindList);
			findList = Arrays.copyOf(findList, idx+1);
			return findList;
		}else {
			System.out.println("######### 요청하신 \'"+name+"\' 감독의 영화가 없습니다. #########");
			return null;
		}
	}
	
	public Movie[] searchGenre(String genre) {
		if(movies == null) {
			System.out.println("######### 요청하신 \'"+genre+"\' 장르 영화가 없습니다. #########");
			return null;
		}
		boolean isFind = false;
		String txtfindList = "";
		Movie[] findList = new Movie[movies.length];
		int idx = 0;
		
		for(Movie temp : movies) {
			if(temp == null) {
				continue;
			}
			if(temp.getGenre().equals(genre)) {
				isFind = true;
				findList[idx] = temp;
				txtfindList += temp.toString()+"\n";
				idx++;
			}
		}
		if(isFind) {
			System.out.println("######### 요청하신 \'"+genre+"\' 장르 영화정보입니다. #########");
			System.out.print(txtfindList);
			findList = Arrays.copyOf(findList, idx+1);
			return findList;
		}else {
			System.out.println("######### 요청하신 \'"+genre+"\' 장르 영화가 없습니다. #########");
			return null;
		}
	}
	
	public void delete(String title) {
		if(movies == null) {
			System.out.println("######### 요청하신 \'"+title+"\' 이(가) 포함된 영화가 없습니다. #########");
			return;
		}
		int len = movies.length;
		int idx = 0;
		for(Movie temp : movies) {
			if(temp == null) {
				continue;
			}
			if(temp.getTitle().equals(title)) {
				movies[idx] = null;
				System.out.println("############# 요청하신 \'"+title+"\' 영화 정보가 삭제됐습니다.");
				return;
			}
			idx++;
		}
		if(idx == 0) {
			System.out.println("######### 요청하신 \'"+title+"\' 이(가) 포함된 영화가 없습니다. #########");
			return;
		}
	}
	
	public int getSize() {
		int sum = 0;
		for(Movie temp : movies) {
			if(temp != null) sum += 1;
		}
		System.out.println("저장된 영화 정보의 갯수는 총 "+sum+"개 입니다.");
		return sum;
	}
}
