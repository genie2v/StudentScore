package com.test;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Process obj = new Process();

		do {
			System.out.println();
			System.out.println("====[����ó��]====");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� ��ü ���");
			System.out.println("3. �̸� �˻� ���");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("==================");
			System.out.println(">>����(1~5), -1 ����");

			String menus = sc.next();

			try {
				int menu = Integer.parseInt(menus);

				if (menu == -1) {
					System.out.println();
					System.out.println(">> ���α׷��� ����Ǿ����ϴ�.");
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
