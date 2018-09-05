package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Test")
public class Index extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int flag = 0;
		PrintWriter pw = response.getWriter();
		String s1 = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", s1);

		Connection con = DBInfo.con;

		String str = "select * from login where UserId=?";
		try {
			PreparedStatement ps = con.prepareStatement(str);
			ps.setString(1, s1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				flag = 1;

				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag == 1) {

			getServletContext().getRequestDispatcher("/Values").forward(request, response);
		} else {
			pw.println("Please Enter The Correct UserId!!!!");
		}
	}

}
