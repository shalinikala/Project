package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Update_Fileds
 */
@WebServlet("/Update_Fields")
public class Update_Fields extends HttpServlet {

	String s2 = "", s3 = "", s4 = "", s5 = "";
	int s;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update_Fields() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String s1 = (String) session.getAttribute("id");
		s = Integer.parseInt(s1);
		System.out.println("Value of s1 is:" + s1);
		pw.println("<html>");
		pw.println("<body bgcolor='grey'>");
		pw.println("<center>");
		pw.println("<font color='Black'>");
		pw.println("<font size=20>");
		pw.println("<h1>Update Here...!!!</h1>");
		pw.println("</font></font>");
		pw.println("</center>");
		Connection con = DBInfo.con;
		try {
			String str = "Select * from login where UserId=?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setInt(1, s);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = rs.getInt(1);
				s2 = rs.getString(2);
				s3 = rs.getString(3);
				s4 = rs.getString(4);
				s5 = rs.getString(5);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("<form action='Update_Fields' method='post'>");
		pw.println("<center>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<td>UserId: </td>");
		pw.println("<td><input type='text' name='id' readonly='true' value=" + s + "></td/>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<td>FirstName: </td>");
		pw.println("<td><input type='text' name='id2' value=" + s2 + "></td/>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<td>LastName: </td>");
		pw.println("<td><input type='text' name='id3' value=" + s3 + "></td/>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<td>DateOfBirth: </td>");
		pw.println("<td><input type='text' name='id4' value=" + s4 + "></td/>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<td>Gender: </td>");
		pw.println("<td><input type='text' name='id5' value=" + s5 + "></td/>");
		pw.println("</tr>");

		pw.println("</table>");
		pw.println("<Br>");
		pw.println("<Br>");
		pw.println("<Br>");
		pw.println("<input type='submit' value='Update'>");
		pw.println("</center>");
		pw.println("</form></body></html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter pw = response.getWriter();
		int i = 0;
		String s1 = request.getParameter("id");
		s1 = request.getParameter("id");
		s = Integer.parseInt(s1);
		s2 = request.getParameter("id2");
		s3 = request.getParameter("id3");
		s4 = request.getParameter("id4");
		s5 = request.getParameter("id5");
		pw.println("<html>");
		pw.println("<body bgcolor='grey'>");
		pw.println("<center>");
		Connection con = DBInfo.con;
		try {
			String str = "Update login set FirstName=?,LastName=?,DateOfBirth=?,Gender=? where UserId=?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setString(1, s2);
			ps.setString(2, s3);
			ps.setString(3, s4);
			ps.setString(4, s5);
			ps.setInt(5, s);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (i != 0) {
			response.sendRedirect("Values");
		} else {
			pw.println("<h2><font size=20><font color='black'>Content Not Updated</font></font></h2>");
			pw.println("<br><br>");
			pw.println("<a href=Values>Retry</a>");
		}
		pw.println("</center></body></html>");
	}

}