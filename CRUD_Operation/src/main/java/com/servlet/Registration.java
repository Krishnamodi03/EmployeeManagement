package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersistDao;
import com.entity.Employee;
import com.entity.Hobbies;
@WebServlet("/register")
public class Registration extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String[] hobbbies = req.getParameterValues("hobbies");
		String date = req.getParameter("dob");
		String designation = req.getParameter("designation");
		String address = req.getParameter("address");
		
		List<Hobbies> hob = new ArrayList<Hobbies>();
		for (String h : hobbbies) {
			Hobbies h1 = new Hobbies();
			h1.setName(h);
			hob.add(h1);
		}
		Employee e = new Employee();
		e.setName(name);
		e.setGender(gender);
		e.setHobbies(hob);
		e.setAddress(address);
		e.setDesignation(designation);
		e.setDate(date);
		
		PersistDao.addEmployee(e);
		
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, resp);
	}
}
