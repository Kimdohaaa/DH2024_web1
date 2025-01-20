package day_03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example1")	// 주소 매핑(web.xml 자동처리)
public class Example1 extends HttpServlet{
	// http://localhost:8080/DH2024_web1/day03/example1
	
	// 1. dopost
	@Override	// http , get , queryString : http://localhost:8080/day03/example1?data1=유재석&data2=40;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println( "[HTTP *POST 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter( "data1" ); System.out.println( "data1 : " + data1 );
		int data2 = Integer.parseInt( req.getParameter( "data2" ) ); System.out.println( "data2 : " + data2 );
	} // f end 
	// 2. doget
	@Override	// http , post , queryString : http://localhost:8080/day03/example1?data1=유재석&data2=40;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println( "[HTTP *GET 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter( "data1" ); System.out.println( "data1 : " + data1 );
		int data2 = Integer.parseInt( req.getParameter( "data2" ) ); System.out.println( "data2 : " + data2 );
	} // f end 
	// 3. doput
	@Override	// http , put , queryString : http://localhost:8080/day03/example1?data1=유재석&data2=40;
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println( "[HTTP *PUT 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter( "data1" ); System.out.println( "data1 : " + data1 );
		int data2 = Integer.parseInt( req.getParameter( "data2" ) ); System.out.println( "data2 : " + data2 );
	} // f end 
	// 4. dodelete
	@Override	// http , delete , queryString : http://localhost:8080/day03/example1?data1=유재석&data2=40;
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println( "[HTTP *DELETE 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter( "data1" ); System.out.println( "data1 : " + data1 );
		int data2 = Integer.parseInt( req.getParameter( "data2" ) ); System.out.println( "data2 : " + data2 );
	} // f end 
}
