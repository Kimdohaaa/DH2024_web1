package web01.controller.member;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web01.model.dao.MemberDao;
import web01.model.dto.MemberDto;

@WebServlet("/member/signup")
public class SignUpController extends HttpServlet{
	/*
 	// 업로드 전 버전 (프로필 등록 불가능)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> SINGUP POST");
		
		// [1] HTTP 요청의 HEADER BODY 자료(JSON) 를 자바(DTO)로 받기 
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		System.out.println(">> memberDto Check : " + memberDto); // 확인

		// [2] 유효성 검사
		// [3] DAO 에게 전달 / 응답 받기
		boolean result = MemberDao.getInstance().signup(memberDto);
		
		// [4] HTTP 로 response(응답) 할 객체(DTO) 타입을 JS(JSON) 타입으로 변환
		resp.setContentType("application/json");
		
		// [5] HTTP HEADER BODY 로 response
		resp.getWriter().print(result);
	}
	*/
	
	// 업로드 가능 버전 (프로필 등록 불가능)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> SINGUP POST (UPLOAD)");
		
		// [1] 업로드할 경로 가져오기
		String uploadpath = req.getServletContext().getRealPath("/upload");
		
		// [2] 만약 해당 경로가 없을 시 생성하기
		File file = new File(uploadpath);
		
		if(file.exists()) {	// 만약 존재하면
			// ~~~존재 시 아무것도 안함~~~ //
		}else {	// 만약 존재하지 않으면
			file.mkdir();	// 해당 경로(폴더) 생성
		}
		
		// [3] 업로드할 파일 설정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(file); 			  // 경로 지정 (file)
		factory.setSizeThreshold(1024*1024*1024); // 용량 지정 (1GB)
		factory.setDefaultCharset("UTF-8"); 	  // 인코딩 지정 (한글)

		// [4] 설정된 객체를 서블릿업로드 객체에 대입
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
		
		String fileName = "default.jpg"; // 전역변수로 사용할 첨부파일명 생성
		
		try {
			
			// [5] HTTP 요청 데이터 파싱/가져오기
			List<FileItem> fileList = fileUpload.parseRequest(req); // 예외 발생
		
			// [6] 파싱된 자료에 대한 배열 순회를 통해 첨부파일 찾기 -> 향상된 for 문 사용
			for(FileItem item : fileList) {
				// [7] 만약 조회 중인 자료가 첨부파일이 아닌 일반텍스트이면
				if(item.isFormField()) {
					// ~~~아무것도 안함~~~ //
				// [8] 만약 조회 중인 자료가 첨부파일이면	
				}else {
					
					// [9] 만약 해당 첨부파일이 비어있지 않으면
					if(!item.getName().isEmpty()) {
						
						// [10] UUID 를 이용하여 첨부파일명 조합하기(.replaceAll() 메소드를 통해 -(하이픈) 을 _(언더바) 로 치환)
						fileName = UUID.randomUUID().toString() + "-" + item.getName().replaceAll("-", "_");
						
						// [11] 업로드할 경로와 파일명조홥하여 경로 생성
						File uploadFile = new File(uploadpath + "/" + fileName);
						
						// [12] 지정한 경로에 item 업로드하기
						item.write(uploadFile);	// 예외 발생
					}
				}
			}
			
		
		
		// [13] 첨부파일이 아닌 일반 텍스트 파일 파싱
		MemberDto memberDto = new MemberDto();
		
		
			// 지정 필드의 텍스트 가져오기
		memberDto.setMid(fileList.get(0).getString());
		memberDto.setMpwd(fileList.get(1).getString());
		memberDto.setMname(fileList.get(2).getString());
		memberDto.setMphone(fileList.get(3).getString());
		memberDto.setMimg(fileName); // 업로드된 파일명 SET
		
		// [14] DAO 에게 전달 / 응답 받기
		boolean result = MemberDao.getInstance().signup(memberDto);
		
		
		// [15] HTTP 로 response(응답) 할 객체(DTO) 타입을 JS(JSON) 타입으로 변환
		resp.setContentType("application/json");
				
		// [16] HTTP HEADER BODY 로 response
		resp.getWriter().print(result);
		
		
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
















