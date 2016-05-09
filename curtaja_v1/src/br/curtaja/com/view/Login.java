package br.curtaja.com.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.curtaja.com.controller.dao.ClienteDao;

@WebServlet( name="login", urlPatterns="/login")
public class Login extends HttpServlet{
	static String email="null";
	static String senha="null";
	static boolean sucess=false;
	
	ClienteDao cDao;
	
	RequestDispatcher disp;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		email = req.getParameter("email");
		senha = req.getParameter("password");
		
		System.out.println("Email: "+email+" \nSenha: "+senha);
		
		//check if the information about login and password are true
		cDao = new ClienteDao();
		sucess = cDao.verificarLogin(email, senha);
		System.out.println("sucess result: "+sucess);
		
		if(sucess == true){// launch the control page to user
			disp = req.getRequestDispatcher("paineldecontrole.html");
			disp.forward(req, resp);
		}
		else{//show error pages
			disp = req.getRequestDispatcher("LoginErrorPage.jsp");
			disp.forward(req, resp);
		}
		
	}

}
