<%@page import="model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 
 <% 
 /*
 session.setAttribute("statusMsg", "");
 System.out.println("Trying to process........");
 Appointment Aobj = new  Appointment();
 String stsMsh = "";
 //Insert.......................................

 if(request.getParameter("hidItemIDSave") == ""){
	 
	  stsMsh = Aobj.insertData(request.getParameter("Name"), request.getParameter("Nic"), request.getParameter("Phone"), request.getParameter("Hospital"), request.getParameter("Doctor"), request.getParameter("Date"), request.getParameter("Time"));
	  session.setAttribute("statusMsg", "Data Record Inserted");
	 
 }else{
	 
	 stsMsh = Aobj.updateData(request.getParameter("hidItemIDSave"),request.getParameter("Name"), request.getParameter("Nic"), request.getParameter("Phone"), request.getParameter("Hospital"), request.getParameter("Doctor"), request.getParameter("Date"), request.getParameter("Time"));
	 session.setAttribute("statusMsg", "Record Updated");
	 
 }
 //Delete........................................
 	
 if(request.getParameter("hidItemIdDelete")!= null){
	 
	 stsMsh = Aobj.deleteData(request.getParameter("hidItemIdDelete"));
	 session.setAttribute("statusMsg", " Record Deleted");
 }
 */
 %>       
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.5.0.min.js"></script> 
<script src="Components/main.js"></script> 

<meta charset="ISO-8859-1">
<title>Doctor</title>
</head>
<body>
<div class="container w-50 p-3" style="margin-top:50px;">
<div class="page-header">
  <h1 id="p" >Doctor </h1>
</div>
<br><br>


 <form id="form"  action="Doctor.jsp?" >
 
  <div class="form-group">
    <label for="email">Phone number :</label>
    <input type="text" class="form-control" id="Phone" name="Phone">
  </div>
  
  <div class="form-group">
    <label for="pwd">Doctor Address :</label>
    <input type="text" class="form-control" name="Address" id="Address">
  </div>
  
  <div class="form-group">
    <label for="pwd">Doctor Specialization:</label>
    <input type="text" class="form-control" name="Specialization"  id="Specialization">
  </div>
  

  <div class="form-group">
    <label for="pwd">Doctor Email:</label>
    <input type="text" class="form-control" id="Email" name="Email">
  </div>
  
    <div class="form-group">
    <label for="pwd">Doctor Name :</label>
    <input type="text" class="form-control" id="Name" name="Name">
  </div>
  
  <button type="button" id="btnSave" class="btn btn-primary">Insert Details</button>
  <input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value=""> 
</form> 
<br>
<div id="alertSuccess" class="alert alert-success"></div>   
<div id="alertError" class="alert alert-danger"></div>

<div id="divItemsGrid" style="margin-top:10px;">
		<% 
		
		Doctor Aobj2 = new  Doctor();
		out.print(Aobj2.readDocDetails());
		
		%> 
</div> 

</div>
		
</body>
</html>