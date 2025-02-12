package web01.controller.serversocket;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/loginsocket")
public class LoginSocket {
	
	private static List<Session> slist = new Vector<Session>();
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(" 접속 성공 ");
		System.out.println(session);
		
		slist.add(session);
	}
	
	@OnMessage
	public void onMsg(Session session , String msg) {
		System.out.println();
		
		for(int i = 0; i < slist.size(); i++) {
			Session csocket = slist.get(i);
			
			try{
				System.out.println(msg);
				csocket.getBasicRemote().sendText(msg);
			}catch (Exception e) {
				System.out.println(e);
			}
					
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		slist.remove(session);
	}
	
}
