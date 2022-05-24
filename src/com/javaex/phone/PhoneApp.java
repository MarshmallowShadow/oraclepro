package com.javaex.phone;
import java.util.*;

public class PhoneApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PhoneDao pDao = new PhoneDao();
		
		System.out.println("********************************************************");
		System.out.println("*                전화번호 관리 프로그램                *");
		System.out.println("********************************************************");
		
		while(true) {
			List<PersonVo> pList = pDao.personSelect();
			
			System.out.println();
			System.out.println("1. 리스트   2.등록   3.수정   4.삭제   5.검색   6.종료");
			System.out.println("------------------------------------------------------");
			System.out.print(">메뉴번호: ");
			String menu = sc.nextLine();
			
			if(menu.equals("6") || menu.equals("종료")) {
				break;
			}
			else if(menu.equals("1") || menu.equals("리스트")) {
				for(int i=0; i<pList.size(); i++) {
					int personId = pList.get(i).getPersonId();
					String name = pList.get(i).getName();
					String hp = pList.get(i).getHp();
					String company = pList.get(i).getCompany();
					
					System.out.println(personId + ".\t" + name + "\t" + hp + "\t" + company);
				}
			}
			else if(menu.equals("2") || menu.equals("등록")) {
				System.out.println("<2.등록>");
				System.out.print("이름 >  ");
				String name = sc.nextLine();
				System.out.print("휴대전화 > ");
				String hp = sc.nextLine();
				System.out.print("회사번호 > ");
				String company = sc.nextLine();
				
				pDao.personInsert(new PersonVo(name, hp, company));
			}
			else if(menu.equals("3") || menu.equals("수정")) {
				System.out.println("<3.수정>");
				
				try {
					System.out.print("번호 > ");
					int personId = sc.nextInt();
					sc.nextLine();
					System.out.print("이름 >  ");
					String name = sc.nextLine();
					System.out.print("휴대전화 > ");
					String hp = sc.nextLine();
					System.out.print("회사번호 > ");
					String company = sc.nextLine();
					
					pDao.personUpdate(new PersonVo(personId, name, hp, company));
					
				} catch(InputMismatchException e) {
					System.out.println("[ 잘못 입력하셨습니다. 다시 시도하세요 ] ");
					sc.nextLine();
				}
			}
			else if(menu.equals("4") || menu.equals("삭제")) {
				System.out.println("<4.삭제>");
				
				try {
					System.out.print(">번호: ");
					int personId = sc.nextInt();
					sc.nextLine();
					pDao.personDelete(personId);
					
				} catch(InputMismatchException e) {
					System.out.println("[ 잘못 입력하셨습니다. 다시 시도하세요 ] ");
					sc.nextLine();
				}
			}
			else if(menu.equals("5") || menu.equals("검색")) {
				System.out.println("<5.검색>");
				System.out.print("검색어를 입력하세요: ");
				String search = sc.nextLine();
				
				search = search.toLowerCase().replace("-", "").replace(" ", "");
				
				for(int i=0; i<pList.size(); i++) {
					int personId = pList.get(i).getPersonId();
					String name = pList.get(i).getName();
					String hp = pList.get(i).getHp();
					String company = pList.get(i).getCompany();
					
					if(Integer.toString(personId).contains(search) || name.toLowerCase().contains(search)
							|| hp.replace(" ", "").replace("-", "").contains(search)
							|| company.replace(" ", "").replace("-", "").contains(search)) {
						System.out.println(personId + ".\t" + name + "\t" + hp + "\t" + company);
					}
				}
			}
			else {
				System.out.println("[ 다시 입력하세요. ]");
			}
		}
		
		System.out.println("********************************************************");
		System.out.println("*                     프로그램 종료                    *");
		System.out.println("********************************************************");
		
		sc.close();
	}
}
