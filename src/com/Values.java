package com;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Value
 */
@WebServlet("/Values")
public class Values extends HttpServlet {
	String s2 = "", s3 = "", s4 = "", s5 = "";
	int s;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private static int count = 0;

	public Values() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ----------------------------->Login Code

		HttpSession session = request.getSession();
		String s1 = (String) session.getAttribute("id");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body >");
		pw.println("<center>");
		Connection con = DBInfo.con;
		try {
			String str = "Select * from login where UserId=?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setString(1, s1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String s = rs.getString("UserId");
				pw.println("<form action='Check'>");
				pw.println("<img src='carefirst.png'>");
				pw.println("<table>");
				pw.println("<tr>");
				pw.println("<td>User Id: </td>");
				pw.println("<td><input type='text' name='id' readonly='true' value=" + s + "></td/>");
				pw.println("</tr>");

				pw.println("<br><br><br>");
				pw.println("<table>");
				pw.println("<tr>");
				pw.println("<td><input type='submit' value='Log into an account'></td>");
				pw.println("</form>");
				pw.println("<form action='Values' method='post'>");
				pw.println("&nbsp &nbsp");
			
				pw.println("</form>");
				pw.println("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ------------------------>CMDB Database which is fixed

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' type='text/css' href='style.css'>");
		pw.println("</head>");
		pw.println("<body >");
		pw.println("<center>");
		pw.println("<font size='20'>");
		pw.println("</font>");
	
		pw.println("<table id='table1'>");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th> UserId </th>");
		pw.println(" <th data-th='Driver details'><span>First Name</span></th>");
		pw.println("<th> Last Name </th>");
		pw.println("<th> Date Of Birth </th>");
		pw.println("<th> Gender </th>");
		pw.println("<th> Relation </th>");
		pw.println("<th> Source </th>");
		pw.println("</tr>");
		Connection con1 = DBInfo1.con1;
		try {
			String str = "Select * from fixed where UserId=?";
			PreparedStatement ps = con1.prepareStatement(str);
			ps.setString(1, s1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String s = rs.getString("UserId");
				String s2 = rs.getString("FirstName");
				String s3 = rs.getString("LastName");
				String s4 = rs.getString("DateOfBirth");
				String s5 = rs.getString("Gender");
				String s6 = rs.getString("Relation");
				String s7 = rs.getString("Source");
				String s8 = rs.getString("GroupNo");
				pw.println("<tr>");
				pw.println("<td>" + s + "</td>");
				pw.println("<td>" + s2 + "</td>");
				pw.println("<td>" + s3 + "</td>");
				pw.println("<td>" + s4 + "</td>");
				pw.println("<td>" + s5 + "</td>");
				pw.println("<td>" + s6 + "</td>");
				pw.println("<td>" + s7 + "</td>");
				pw.println("</tr>");
				pw.println("<tr><td>GroupNo:" + s8 + "</td></tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ------------------------->CAIS Database which requires modification
		pw.println("<br/><br/><br/><br/>");
		
		pw.println("<center>");
		pw.println("<font size='20'>");
		pw.println("</font>");
		pw.println("<form action='Values' method='post'>");
		pw.println("<table id='table1'>");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th> UserId </th>");
		pw.println(" <th data-th='Driver details'><span>First Name</span></th>");
		pw.println("<th> Last Name </th>");
		pw.println("<th> Date Of Birth </th>");
		pw.println("<th> Gender </th>");
		pw.println("<th> Relation </th>");
		pw.println("<th> Source </th>");
		pw.println("</tr>");
		try {
			String str = "Select * from login where UserId=?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setString(1, s1);
			ResultSet rs = ps.executeQuery();
			count = 0;
			while (rs.next()) {
				++count;
				String s = rs.getString("UserId");
				String s2 = rs.getString("FirstName");
				String s3 = rs.getString("LastName");
				String s4 = rs.getString("DateOfBirth");
				String s5 = rs.getString("Gender");
				String s6 = rs.getString("Relation");
				String s7 = rs.getString("Source");
				String s8 = rs.getString("GroupNo");
				pw.println("<tr>");
				pw.println("<td><input type='text' name='userid" + count + "' readonly='true' value=" + s + "></td/>");
				pw.println("<td><input type='text' name='fname" + count + "' value=" + s2 + "></td>");
				pw.println("<td><input type='text' name='lname" + count + "' value=" + s3 + "></td>");
				pw.println("<td><input type='text' name='dob" + count + "' value=" + s4 + "></td>");
				pw.println("<td><input type='text' name='gender" + count + "' value=" + s5 + "></td>");
				pw.println(
						"<td><input type='text' name='relation" + count + "' readonly='true' value=" + s6 + "></td>");
				pw.println("<td><input type='text' name='source" + count + "' readonly='true' value=" + s7 + "></td>");
				pw.println("</tr>");
				pw.println("<tr><td>GroupNo:" + s8 + "</td></tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("<td><input type='submit' value='Update'></td></tr>");
		
		pw.println("</form>");
		pw.println("</thead>");
		pw.println("</center");
		pw.println("</html");
		
		pw.flush();
		pw.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter pw = response.getWriter();
		ArrayList<UserModel> userList = new ArrayList<>();
		for (int i = 1; i <= count; i++) {
			UserModel user = new UserModel();
			user.setuId(Integer.parseInt(request.getParameter("userid" + i)));
			user.setfName(request.getParameter("fname" + i));
			user.setlName(request.getParameter("lname" + i));
			user.setGender(request.getParameter("gender" + i));
			user.setDob(request.getParameter("dob" + i));
			user.setRelation(request.getParameter("relation" + i));
			user.setSource(request.getParameter("source" + i));
			userList.add(user);
			// user.setGroupNo(request.getParameter("source"+i));
		}

		pw.println("<html>");
		pw.println("<body bgcolor='grey'>");
		pw.println("<center>");
		Connection con = DBInfo.con;
		int[] status = null;
		try {
			String str = "Update login set FirstName=?,LastName=?,DateOfBirth=?,Gender=? where UserId=?";
			PreparedStatement ps = con.prepareStatement(str);
			for (UserModel u : userList) {
				ps.setString(1, u.getfName());
				ps.setString(2, u.getlName());
				ps.setDate(3, new Date(new SimpleDateFormat("yyyy-MM-dd").parse(u.getDob()).getTime()));
				ps.setString(4, u.getGender());
				ps.setInt(5, u.getuId());
				ps.addBatch();
			}
			status = ps.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (status != null) {
			response.sendRedirect("/Project/Values");
		} else {
			pw.println("<h2><font size=20><font color='black'>Content Not Updated</font></font></h2>");
			pw.println("<br><br>");
			pw.println("<a href=Value>Retry</a>");
		}
		pw.println("</center></body></html>");
	}

}
