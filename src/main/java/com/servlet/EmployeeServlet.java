package com.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.EmployeeDAO;
import com.entity.Employee;
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private EmployeeDAO emp;
	public void init() {
		emp = new EmployeeDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);
		
		try
		{
			emp.registerEmployee(employee);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		response.sendRedirect("EmployeeDetails.jsp");
	}
}
