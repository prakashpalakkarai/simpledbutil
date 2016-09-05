package org.selfars.sdbutil.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.selfars.sdbutil.db.DBConnFactory;

@WebServlet("/regSuccess")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		
		String userName = request.getParameter("user");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		Connection dbConn = DBConnFactory.getInstance().getConnection();
		
		try {
			Statement stmt = dbConn.createStatement();
			String sql = "INSERT INTO users values('" + userName + "','" + password + "','" + email + "')";
			System.out.println("SQL: " + sql);
			stmt.executeUpdate(sql);
			
		} catch(SQLException sqlEx) {
			System.out.println("Error while saving data. Exception Message: " + sqlEx.getMessage());
		}
		
		try {
			dbConn.close();
		} catch(SQLException ex) { System.out.println("Error while closing DB connection."); }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/regSuccess.jsp");
		dispatcher.forward(request, response);
	}
}
