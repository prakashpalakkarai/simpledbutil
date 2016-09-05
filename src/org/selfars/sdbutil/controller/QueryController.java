package org.selfars.sdbutil.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

@WebServlet("/queryResult")
public class QueryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String QUERY_RESULT_PAGE = "WEB-INF/jsp/queryResult.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {

		if(ControllerHelper.checkSessionAndForward(request, response, null)) {

			String sql = request.getParameter("query");

			Connection dbConn = DBConnFactory.getInstance().getConnection();
			StringBuilder queryResult = new StringBuilder("<table border=\"1\" sortable=\"true\">");

			try {
				System.out.println("SQL: " + sql);
				Statement stmt = dbConn.createStatement();
				ResultSet result = stmt.executeQuery(sql);
				ResultSetMetaData resultMeta = result.getMetaData();
				queryResult.append("<tr>");
				for(int i=1; i <= resultMeta.getColumnCount(); i++) {
					queryResult.append("<th>");
					queryResult.append(resultMeta.getColumnLabel(i));
					queryResult.append("</th>");
				}
				queryResult.append("</tr>");
				while(result.next()) {
					queryResult.append("<tr>");
					for(int j=1; j <= resultMeta.getColumnCount(); j++) {
						queryResult.append("<td>");
						switch(resultMeta.getColumnType(j)) {
							case java.sql.Types.VARCHAR:
								queryResult.append(result.getString(j));
								break;
							default:
								queryResult.append("Unknown Type");
								break;
						}
						queryResult.append("</td>");
					}
					queryResult.append("</tr>");
				}
				queryResult.append("</table>");
			} catch(SQLException sqlEx) {
				System.out.println("Error while querying. Exception Message: " + sqlEx.getMessage());
			}

			try {
				dbConn.close();
			} catch(SQLException ex) { System.out.println("Error while closing DB connection."); }

			HttpSession session=request.getSession();
			session.setAttribute("queryResult", queryResult.toString());

			RequestDispatcher dispatcher = request.getRequestDispatcher(QUERY_RESULT_PAGE);
			dispatcher.forward(request, response);
		}
	}
}
