package org.selfars.sdbutil.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerHelper {
	private static final String LOGIN_PAGE = "WEB-INF/jsp/login.jsp";

	public static boolean checkSessionAndForward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("user") != null) {
			if(page != null) {
				ControllerHelper.forwardToPage(request, response, page);
				return false;
			}
		} else {
			ControllerHelper.forwardToPage(request, response, LOGIN_PAGE);
			return false;
		}
		return true;
	}

	public static void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
