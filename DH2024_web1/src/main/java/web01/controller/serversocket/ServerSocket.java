package web01.controller.serversocket;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

// WS (WebSocket) //
// Servlet 클래스가 아닌 WebSocket 클래스로 사용

// [1] @ServerEndpoint("서버 소켓 주소") 어노테이션을 통해 서버 소켓 주소 생성
@ServerEndpoint("/chatsocket")
public class ServerSocket {
	// * 매개변수의 타입 Session 은 WebSocket 자동완성 * //
	
	// [2] 접속된 클라이언트 세션 가져오기
	// => 접속성공한 클라이언트 소켓 정보  => List 컬렉션으로 여러 개 Session 저장 (클라이언트 소켓은 N 개 이기 때문)
	private static List<Session> 접속명단 = new Vector<Session>();
	
	
	// [3] @OnOpen 어노테이션을 통해 클라이언트 소켓의 접속 확인
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("WS 접속 성공");
		System.out.println(session); // org.apache.tomcat.websocket.WsSession@42b03ece 출력
	
		// 접속성고한 클라이언트 소켓이 세션 정보를 List 에 저장
		접속명단.add(session);
		System.out.println(접속명단);
	}
	
	// [4] @OnMessage 어노테이션을 통해 클라이언트 소켓이 보낸 메세지 확인
	@OnMessage
	public void opMessage(Session session , String message) {
		System.out.println("클라이언트 소켓으로부터 온 메세지");
		System.out.println(message); // "서버 소켓 안농2"
		
		/*
		// 매핑 테스트 //
		// [4-1] 서버 소켓 -메세지전송-> 클라이언트 소켓 (!!! 예외처리 필수 !!!)
		
		try {
			session.getBasicRemote().sendText("클라이언트 소켓 안농");
		}catch (Exception e) {
			System.out.println("서버의 메세지 오류 : " + e);
		}
		*/
		
		// [4-1] 현재 클라이언트 소켓이 전송한 메세지를 접속된 모든 클라이언트 소켓의 세션에게 보내기
		//	  => 받은 메세지 / 접속명단 필요
		// 1-1) 반복문을 통한 접속명단 순회
		for(int i = 0; i < 접속명단.size() ; i++) {
			// 1-2) 접속 명단의 i 번째 세션 가져오기
			Session clientSocket = 접속명단.get(i);
			// 1-3) i 번째 세션에 서버 소켓이 전송 받은 메세지 보내기 (!예외처리!)
			try {
				clientSocket.getBasicRemote().sendText(message);
			}catch (Exception e) {
				System.out.println("서버의 메세지 오류 : " + e);
			}
		}
		
	}
	
	// [5] @OnClose 어노테이션을 통해 클라이언트 소켓이 접속을 종료 시 실행
	//     => 접속 종료 : 클라이언트 소켓이 포함된 JS 새로고침 시
	public void onClose(Session session) {
		// 접속 종료한 클라이언트 소켓의 세션을 List 에서 제거
		접속명단.remove(session);
		System.out.println("접속 종료");
	}
	
	
	
	
}
