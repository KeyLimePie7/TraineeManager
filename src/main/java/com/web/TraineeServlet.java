package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Trainee;
import com.service.TraineeService;

/**
 * Servlet implementation class TraineeServlet
 */
@WebServlet("/TraineeServlet")
public class TraineeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TraineeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		TraineeService service=new TraineeService();
		PrintWriter pw=response.getWriter();
		if(action!=null && action.equals("Search")) {
			String empId=request.getParameter("empId");
			Trainee t=service.searchTrainee(Integer.parseInt(empId));
			pw.print("<h1 align='center'>Trainee Management Tool</h1>");
			pw.print("<hr>");
			if(t!=null) {
				pw.print("<table border='1' align='center' width='30%'>");
				pw.print("<tr><td>Trainee Id</td><td>"+t.getEmpId()+"</td></tr>");
				pw.print("<tr><td>Trainee Name</td><td>"+t.getName()+"</td></tr>");
				pw.print("<tr><td>LG Name</td><td>"+t.getLgName()+"</td></tr>");
				pw.print("<tr><td>Rating</td><td>"+t.getRating()+"</td></tr>");
				pw.print("<tr><td>Feedback</td><td>"+t.getFeedback()+"</td></tr>");
				pw.print("</table>");
				pw.print("<br><br>");
				pw.print("<form action='TraineeServlet'>");
				pw.print("<p align='center'><input type='hidden' name='empId' value='"+t.getEmpId()+"'></p>");				
				pw.print("<p align='center'><input type='submit' name='action' value='Delete'></p>");
				pw.print("</form>");
				pw.print("<p align='center'><a href='TraineeServlet?action=Delete&empId="+t.getEmpId()+"'>Delete</a></p>");	
			} else {
				pw.print("<p align='center'><font color='red'>No trainee found!!!</font></p>");
				pw.print("<p align='center'><a href='search.html'>Back</a></p>");	
			}
		} else if(action!=null && action.equals("Delete")) {
			String empId=request.getParameter("empId");
			System.out.println("EmpId="+empId);
			boolean b=service.deleteTrainee(Integer.parseInt(empId));
			pw.print("<h1 align='center'>Trainee Management Tool</h1>");
			pw.print("<hr>");
			if(b==true) {
				pw.print("<p align='center'><font color='green'>Trainee with id="+empId+" has been deleted.</font></p>");
				pw.print("<p align='center'><a href='search.html'>Back</a></p>");				
			} else {
				pw.print("<p align='center'><font color='red'>Trainee deletion failed!!!</font></p>");
				pw.print("<p align='center'><a href='search.html'>Back</a></p>");
			}
		}
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
