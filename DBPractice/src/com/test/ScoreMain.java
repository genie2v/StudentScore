package com.test;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Process obj = new Process();

		do {
			System.out.println();
			System.out.println("====[성적처리]====");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 전체 출력");
			System.out.println("3. 이름 검색 출력");
			System.out.println("4. 성적 수정");
			System.out.println("5. 성적 삭제");
			System.out.println("==================");
			System.out.println(">>선택(1~5), -1 종료");

			String menus = sc.next();

			try {
				int menu = Integer.parseInt(menus);

				if (menu == -1) {
					System.out.println();
					System.out.println(">> 프로그램이 종료되었습니다.");
					return;
				}

				switch (menu) {
				case 1:
					obj.sungjukInsert();
					break;
				case 2:
					obj.sungjukSelectAll();
					break;
				case 3:
					obj.sungjukSearchName();
					break;
				case 4:
					obj.sungjukUpdate();
					break;
				case 5:
					obj.sungjukDelete();
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		} while (true);
		
	}

}
