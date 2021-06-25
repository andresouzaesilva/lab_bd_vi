
package br.gov.sp.fatec.ex_3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.ex_3.model.Calculadora;
@WebServlet(urlPatterns= {"/porcentagem"})
public class AppCalc extends HttpServlet{
		
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		ServletContext sc = req.getServletContext();
		
		try {
			sc.getRequestDispatcher("/resources/static/index.html").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
	
       try {	
			ObjectMapper mapper = new ObjectMapper();
			Calculadora mdCalculadora = mapper.readValue(req.getReader(), Calculadora.class);
			
			float mult = mdCalculadora.porcentagem();
			
			resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.setStatus(200);
		        
		    PrintWriter out = resp.getWriter();
		    out.print(mult);
		    out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	
	}
}
