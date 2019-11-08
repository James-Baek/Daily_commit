package com.ssafy.step2.movie;
import java.util.*;

public class MovieTest {

	public static void main(String[] args) {
		MovieMgr m1 = MovieMgr.getInstance();
		MovieMgr m2 = MovieMgr.getInstance();
		Scanner sc = new Scanner(System.in);
		String menuText = "<<< 영화 관리 프로그램 >>>\n 1. 영화 정보 입력 \n 2. 영화 정보 전체 검색\n 3. 영화명 검색\n 4. 영화 장르별 검색\n 5. 영화 정보 삭제\n 0. 종료\n 원하는 번호를 선택하세요.\n";
		int menu = 1;
		
		while(menu != 0) {
			System.out.println();
			System.out.print(menuText);
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("영화 정보를 /로 나눠서 입력하세요.\n   영화제목/감독 이름/평점/장르/줄거리\n ex)엽기적인 그녀/곽재용/9/멜로드라마/대한민국 대표 로멘틱 코미디 영화");
				
				sc.nextLine();
				String[] info = sc.nextLine().split("/");
				if(info.length == 5) m1.add(new Movie(info[0],info[1],Integer.parseInt(info[2]),info[3],info[4]));
				else if(info.length ==4) m1.add(new Movie(info[0],info[1],Integer.parseInt(info[2]),info[3]));
				else System.out.println("정보를 잘못 입력했습니다. 다시 시도하세요.");
				break;
			case 2:
				m1.search();
				break;
			case 3:
				sc.nextLine();
				System.out.println("검색할 영화의 제목를 입력하세요.");
				String title = sc.nextLine();
				m1.search(title);
				break;
			case 4:
				sc.nextLine();
				System.out.println("검색할 영화의 장르를 입력하세요.");
				String genre = sc.nextLine();
				m1.searchGenre(genre);
				break;
			case 5:
				sc.nextLine();
				System.out.println("삭제할 영화의 제목을 입력하세요.");
				String del = sc.nextLine();
				m1.delete(del);
				break;
			}

		}
		System.out.println("영화 관리 프로그램을 종료합니다.");
	}

}
