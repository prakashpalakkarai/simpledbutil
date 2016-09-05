package org.selfars.sdbutil.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login","/register","/queryPage"})
public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String LOGIN_PAGE = "WEB-INF/jsp/login.jsp";
	private static final String INDEX_PAGE = "/index.html";
	private static final String REGISTER_PAGE = "WEB-INF/jsp/register.jsp";
	private static final String QUERY_PAGE = "WEB-INF/jsp/queryPage.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		
		String appContextPath = request.getContextPath();
		
		if(request.getRequestURI().equals(appContextPath + "/")) {
			ControllerHelper.forwardToPage(request, response, INDEX_PAGE);
		} else if(request.getRequestURI().equals(appContextPath + "/login")) {
			ControllerHelper.forwardToPage(request, response, LOGIN_PAGE);
		} else if(request.getRequestURI().equals(appContextPath + "/register")) {
			ControllerHelper.forwardToPage(request, response, REGISTER_PAGE);
		} else if(request.getRequestURI().equals(appContextPath + "/queryPage")) {
			ControllerHelper.checkSessionAndForward(request, response, QUERY_PAGE);
		} 
	}
	
}
