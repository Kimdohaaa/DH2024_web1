package day07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day07/example6")
public class Example6 extends HttpServlet {
        
      private Set<HashSet<Integer>> set = new HashSet<HashSet<Integer>>();
        
        @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	System.out.println("/day07/example6 POST OK ");
        
        	ObjectMapper mapper = new ObjectMapper();
        	HashSet<Integer> set = mapper.readValue(req.getReader(), HashSet.class);
        	
        	
        	
        	resp.setContentType("application/json");
        	resp.getWriter().print(true);
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           System.out.println("/day07/example6 GET OK ");
           
           
           ObjectMapper mapper = new ObjectMapper();
           
           String jsonResult = mapper.writeValueAsString(set);
           
           resp.setContentType("application/json");
           resp.getWriter().print(jsonResult);
           
           
        }
        
} // c end

