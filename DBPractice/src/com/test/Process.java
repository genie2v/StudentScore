package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {
	// �ֿ� �Ӽ�
	private ScoreDAO dao;
	private Scanner sc;

	public Process() {
		dao = new ScoreDAO();
	}

	// �ֿ� ���
	// ���� �Է�
	public void sungjukInsert() {
		try {
			dao.connection();

			int count = dao.count();
			sc = new Scanner(System.in);

			do {
				System.out.println();
				System.out.printf("%d�� �л� ���� �Է�(�̸� ���� ���� ����) : ", (++count));
				String name = sc.next();
				if (name.equals("."))
					break;
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();

				ScoreDTO dto = new ScoreDTO();
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);

				int result = dao.add(dto);
				if (result > 0)
					System.out.println(">> ���� �Է��� �Ϸ�Ǿ����ϴ�.");
			} while (true);

			dao.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	// ���� ��ü ���
	public void sungjukSelectAll() {
		try {
			dao.connection();

			System.out.printf("��ü�ο� %d��\n", dao.count());
			System.out.println("��ȣ	�̸�	����	����	����	����	���	����");
			for (ScoreDTO obj : dao.lists()) {
				System.out.printf("%s	%3s	%3d	%3d	%3d	%3d	%5.1f	%3d\n", obj.getSid(), obj.getName(),
						obj.getKor(), obj.getEng(), obj.getMat(), obj.getTot(), obj.getAvg(), obj.getRank());
			}

			dao.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	// �̸� �˻� ���
	public void sungjukSearchName() {
		try {
			sc = new Scanner(System.in);
			
			System.out.println("�˻��� �̸��� �Է��ϼ��� : ");
			String name = sc.next();

			dao.connection();

			ArrayList<ScoreDTO> arr = dao.lists(name);
			System.out.printf("�˻��� �ο� %d��\n", arr.size());
			System.out.println("��ȣ	�̸�	����	����	����	����	���	����");
			for (ScoreDTO obj : arr) {
				System.out.printf("%s	%3s	%3d	%3d	%3d	%3d	%5.1f	%3d\n", obj.getSid(), obj.getName(),
						obj.getKor(), obj.getEng(), obj.getMat(), obj.getTot(), obj.getAvg(), obj.getRank());
			}

			dao.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	// ���� ����
	public void sungjukUpdate() {
		try {
			sc = new Scanner(System.in);
			System.out.println("������ �л��� ��ȣ�� �Է��ϼ��� : ");
			int sid = sc.nextInt();

			dao.connection();

			ArrayList<ScoreDTO> arrayList = dao.lists(sid);
			if (arrayList.size() > 0) {
				System.out.println("��ȣ	�̸�	����	����	����	����	���	����");
				for (ScoreDTO obj : arrayList) {
					System.out.printf("%s	%3s	%3d	%3d	%3d	%3d	%5.1f	%3d\n", obj.getSid(),
							obj.getName(), obj.getKor(), obj.getEng(), obj.getMat(), obj.getTot(), obj.getAvg(),
							obj.getRank());
				}

				System.out.println("���� ������ �Է�(�̸� ���� ���� ����) : ");
				String name = sc.next();
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();

				ScoreDTO dto = new ScoreDTO();
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
				dto.setSid(String.valueOf(sid));

				int result = dao.modify(dto);

				if (result > 0)
					System.out.println(">> ������ �Ϸ�Ǿ����ϴ�.");
			} else
				System.out.println("���� ����� �������� �ʽ��ϴ�.");

			dao.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	// ���� ����
	public void sungjukDelete() {
		try {
			sc = new Scanner(System.in);

			System.out.println();
			System.out.println(">> ������ ��ȣ �Է� : ");
			int sid = sc.nextInt();

			dao.connection();

			ArrayList<ScoreDTO> arrayList = dao.lists(sid);
			if (arrayList.size() > 0) {
				System.out.println("��ȣ	�̸�	����	����	����	����	���	����");
				for (ScoreDTO obj : arrayList) {
					System.out.printf("%s	%3s	%3d	%3d	%3d	%3d	%5.1f	%3d\n", obj.getSid(),
							obj.getName(), obj.getKor(), obj.getEng(), obj.getMat(), obj.getTot(), obj.getAvg(),
							obj.getRank());
				}
				System.out.println("���� �����Ͻðڽ��ϱ�?(Y/N) : ");
				String response = sc.next();

				if (response.contentEquals("Y") || response.equals("y")) {
					int result = dao.remove(sid);
					if (result > 0)
						System.out.println(">> ������ �Ϸ�Ǿ����ϴ�.");
				} else
					System.out.println(">> ��ҵǾ����ϴ�.");
			} else
				System.out.println(">> ���� ����� �������� �ʽ��ϴ�.");

			dao.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

}
