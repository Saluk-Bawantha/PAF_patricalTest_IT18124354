package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;

/**
 * Servlet implementation class AppointmentApi
 */
@WebServlet("/DoctorAPI")
public class DoctorAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Doctor Aobj = new Doctor();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String	output = Aobj.insertDocDetails(request.getParameter("Phone"), request.getParameter("Address"), request.getParameter("Specialization"), request.getParameter("Email"), request.getParameter("Name"));
	response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	Map paras = getParasMap(request);	
	String	 output = Aobj.updateDocDetails(paras.get("hidItemIDSave").toString(),paras.get("Phone").toString(), paras.get("Address").toString().replace("+", " ").replace("%2C", ",").replace("%3A", ":"), paras.get("Specialization").toString().replace("+", " ").replace("%2C", ",").replace("%3A", ":"),paras.get("Email").toString().replace("+", " ").replace("%2C", ",").replace("%3A", ":"),paras.get("Name").toString().replace("+", " ").replace("%2C", ",").replace("%3A", ":"));
	response.getWriter().write(output);
	
	}


	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		Map paras = getParasMap(request);
		String output = Aobj.deleteDocDetails((String) paras.get("Appoid".toString()));
		response.getWriter().write(output);
		
		
	}
	
	private static Map getParasMap(HttpServletRequest request) { 
		
		Map<String, String> map = new HashMap<String, String>(); 
		
		try  {   
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");   
			String queryString = scanner.hasNext() ?          
			scanner.useDelimiter("\\A").next() : "";  
			scanner.close(); 
			
			String[] params = queryString.split("&"); 
			
			for (String param : params) {
				String[] p = param.split("=");    
				map.put(p[0], p[1]); 
			}
		}
		catch (Exception e) {
			
			
		}
		
		return map; 
	}
	

}
