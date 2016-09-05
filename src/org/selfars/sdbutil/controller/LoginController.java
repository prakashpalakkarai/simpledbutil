package org.selfars.sdbutil.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.selfars.sdbutil.db.DBConnFactory;

@WebServlet("/loginCheck")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		
		String userName = request.getParameter("user");
		String password = request.getParameter("password");
		
		Connection dbConn = DBConnFactory.getInstance().getConnection();
		
		try {
			String sql = "select * from users where username = '" + userName + "' and password ='" + password + "';";
			System.out.println("SQL: " + sql);
			Statement stmt = dbConn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			HttpSession session=request.getSession();
			if(result.next()) {
			    session.setAttribute("user",userName);				
			    session.setAttribute("errorMessage",null); // clear any previous errors
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/queryPage.jsp");
				dispatcher.forward(request, response);
			} else {
				session.setAttribute("errorMessage","Invalid username or password. Try Again.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
			}
		} catch(SQLException sqlEx) {
			System.out.println("Error while Login Check. Exception Message: " + sqlEx.getMessage());
		}
		
		try {
			dbConn.close();
		} catch(SQLException ex) { System.out.println("Error while closing DB connection."); }
		
	}
}
