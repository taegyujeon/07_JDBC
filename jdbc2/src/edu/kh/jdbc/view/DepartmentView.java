package edu.kh.jdbc.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dao.DepartmentDAO;
import edu.kh.jdbc.model.dto.Department;

public class DepartmentView {
	
	// 객체의 필드는 초기화 되지 않은 경우 
	// 생성 시 기본 값으로 자동 초기화됨
	
	private Scanner sc;  // = null
	private DepartmentDAO dao; // = null
	
	// 기본 생성자
	public DepartmentView() {
		sc = new Scanner(System.in);
		dao = new DepartmentDAO();
	}
	
	
	public void displayMenu() {
		
		int input = 0; // 메뉴 번호 입력 받을 변수
		
		do {
			try {
				System.out.println("\n===== 부서 관리 프로그램 =====\n");
				System.out.println("1. 부서 추가");
				System.out.println("2. 부서 전체 조회");
				System.out.println("3. 검색어가 부서명에 포함되는 부서 조회");
				System.out.println("4. 부서 삭제"); // 부서 코드 입력
				System.out.println("5. 부서명 변경"); // 부서 코드, 변경할 부서명 입력
				System.out.println("0. 프로그램 종료");
		
				System.out.print("메뉴 선택 >> ");
				
				input = sc.nextInt();
				
				switch(input) {
				case 1 : insertDepartment();  break;
				case 2 : selectAll(); break;
				case 3 : selectDepartmentTitle();  break;
				case 4 : deleteDepartment();  break;
				case 5 : updateDepartment();  break;
				case 0 : System.out.println("\n[프로그램 종료]\n");  break;
				default : System.out.println("\n[메뉴에 존재하는 번호만 입력하세요]\n");
				
				
				}
			} catch(InputMismatchException e) {
				
				System.out.println("\n[입력 형식이 잘못되었습니다]\n");
				input = -1;
				sc.nextLine(); // 스캐너 버퍼에 남아있는 잘못 입력된 값 비우기
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(input != 0);
		
		
	}
	
	
	/* 부서 추가
	 * @throws SQLException
	 */
	
	private void insertDepartment() throws SQLException {
		System.out.println("\n----- 부서 추가 -----\n");
		
		System.out.println("부서 코드(deptId) 입력:");
		String deptId = sc.next();
		
		System.out.println("부서명 (deptTitle) 입력 : ");
		String deptTitle = sc.next();
		
		System.out.println("지역 코드 (locationId) 입력 : ");
		String locationId = sc.next();
		
		// 입력 받은 값을 한 번에 저장할 Department 객체 생성
		Department dept = new Department(deptId, deptTitle, locationId);
		
		// DAO 메서드 호출 후 결과(삽입 성공한 행의 개수) 반환 받기
		int result = dao.insertDepartment(dept);
		
		if(result > 0) System.out.println("\n[삽입 성공]\n");
		else					 System.out.println("\n[삽입 실패]\n");
		
	}
	
	
	/** 부서 전체 조회
	 * @throws SQLException 
	 */
	private void selectAll() throws SQLException{
		
		System.out.println("\n ----- 부서 전체 조회 -----\n");
		
		List<Department> deptList = dao.selectAll();
		
		for(Department dept : deptList) {
			System.out.println(dept); // 자동으로 toString() 메서드 호출
		}
		
	}
	
	
	/** 검색어가 부서명에 포함되는 부서 조회
	 * @throws SQLException
	 */
	private void selectDepartmentTitle() throws SQLException{
		System.out.println("\n----- 검색어가 부서명에 포함되는 부서 조회 ------\n");
		
		System.out.print("검색할 부서명 : ");
		String title = sc.next();
		
		List<Department> deptList = dao.selectDepartmentTitle(title);
		
		// deptList가 비어있는 경우 
		// -> 검색 결과가 없음
		if(deptList.isEmpty()) {
			System.out.println(title + "이 포함된 부서가 없습니다.");
		}
		else {
			for(Department dept : deptList)	{
				System.out.println(dept);
			}
		}
		
	}
	
	
	/** 부서 삭제
	 * @throws SQLException
	 */
	private void deleteDepartment() throws SQLException{
		System.out.print("\n ----- 부서 삭제 -----\n");
		
		System.out.print("삭제할 부서코드 입력: ");
		String id = sc.next();
		
		// 입력 받은 부서 코드와 같은 부서 코드를 가지는 행이 있는지 검사
		// -> 있을 경우 "정말 삭제 하시겠습니까?" 한번 더 물어보기
		// -> 없을 경우 "부서코드가 일치하는 부서가 존재하지 않습니다"
		
		// DAO 메서드 호출 후 결과(삽입 성공한 행의 개수) 반환 받기
		int result = dao.deleteDepartment(id);
		
		if(result > 0) System.out.println("\n[삭제 성공]\n");
		else					 System.out.println("\n[삭제 실패]\n");
		
	}
	
	/** 부서명 변경
	 * @throws SQLException
	 */
	private void updateDepartment() throws SQLException{
		System.out.print("\n ----- 부서명 변경 -----\n");
		
		System.out.print("변경할 부서코드 입력: ");
		String id = sc.next();
		
		System.out.print("새로운 부서명 입력: ");
		String newTitle = sc.next();
		
		int result = dao.updateDepartment(id, newTitle);
		
		if(result > 0) System.out.println("\n[변경 성공]\n");
		else					 System.out.println("\n[변경 실패]\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



























































