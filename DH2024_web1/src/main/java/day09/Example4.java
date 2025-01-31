package day09;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/day09/example4")
public class Example4 extends HttpServlet{
	// [1] 파일 업로드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST (COMMONS)");
		
		// 1) 현재 서블릿의 로컬경로(서버경로) 조회
			// req.getServletContext().getRealPath("경로") : 서버 내 경로 반환
		String uploadPath = req.getServletContext().getRealPath("/upload");
		System.out.println(uploadPath);
		// 자바 코드 실행 파일의 서버경로(배포후) 출력 : C:\Users\TJ-BU-702-PC22\Desktop\DH2024_web1\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\DH2024_web1\upload
		
		// 2) 지정한 경로의 File 객체 생성
		File file = new File(uploadPath);

		// 2) 만약 업로드할 폴더가 존재하지 않으면 생성
		if(!file.exists()) {	// 존재하지 않을 시
			file.mkdir();	// 폴더 생성
			System.out.println(">> 파일 생성");
		}
		
		// 3) 서블릿의 HTTP 요청 중 ContentType 이 'multipart/from-data' 일 때 첨부파일을 업로드하기
		
		// 3-1) DiskFileItemFactory 클래스 객체를 이용하여 저장위치 / 업로드용량제한 / 한글 인코딩 지정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(file); 			// 1_ 저장 위치 설정
		factory.setSizeThreshold(1024 * 1024);  // 2_ 업로드 용량(바이트) 제한 => 1024바이트 -> 1KB
		factory.setDefaultCharset("UTF-8");		// 3_ 한글 인코딩 설정
		
		// 3-2) ServletFileUpload 클래스 객체에 DiskFileItemFactory 클래스를 통해 지정한 방식으로 업로드 객체 생성
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
		
		try {
			// 3-3) 업로드 객체에 HTTP 요청 객체를 대입하여 HTTP 요청 객체를 업로드객체로 변환 -> 변환된 자료를 리스트 타입으로 받기
			List<FileItem> formItems = fileUpload.parseRequest(req);	// 예외처리 발생
				// cos.jar 또는 commons.jar 사용 시 오류 -> 톰캣 10.1 버전을 지원하지 않기 때문
				// -> 톰캣 버전을 9이하 사용 또는 마이그레이션을 이용하여 라이브러리 버전을 낮춰 사용해야함
	
			
			// 3-4) 만약 업로드 객체(formItems) 내 반환된 자료들이 존재하면
			if(formItems != null && !formItems.isEmpty()) {
				
				// 3-5) 존재 시 반복문을 이요하여 form 자료 조회
				for(int i = 0; i <= formItems.size()-1; i++) {
				
					// 3-6) 자료 1 개 추출
					FileItem fileItem =  formItems.get(i);
					
					// 3-7) 자료가 첨부파일(파일)인지 문자열인지 구분
						// .isFormField() : 자료가 첨부파일인지 문자열인지 구분
					if(fileItem.isFormField()) {	// 자료가 일반 문자열 일시
						System.out.println(">> 일반 텍스트 : " + fileItem.getName());	
					}else {							// 자료가 첨부파일일 시
						System.out.println(">> 첨부 파일 : " + fileItem.getName());
					
						// 3-8) 현재 경로에 파일명 붙이기
						File uploadFile = new File(uploadPath + "/" + fileItem.getName());
						
						// 3-9) 지정한 파일명으로 업로드
						fileItem.write(uploadFile);	// 예외처리 발생
					}
					
				}
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}

	}
}
