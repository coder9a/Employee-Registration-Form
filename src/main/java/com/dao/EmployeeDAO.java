package com.dao;
import com.conn.*;
import com.entity.Employee;

import java.io.*;
import java.sql.*;

import javax.servlet.http.HttpServlet;


public class EmployeeDAO extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public int registerEmployee(Employee emp) throws ClassNotFoundException
	{
		int result = 0;
		try
		{
			String sql = "insert into myemp (first_name, last_name, email, password, address, contact) values (?,?,?,?,?,?)";
			Connection con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getPassword());
			ps.setString(5, emp.getAddress());
			ps.setString(6, emp.getContact());
			
			result = ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		return result;
	}
}
