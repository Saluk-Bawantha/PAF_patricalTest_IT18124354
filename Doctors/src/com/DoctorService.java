package com;

import model.Doctor;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Appoint")

public class DoctorService {
	
	
	
	
	Doctor DoctorObj = new Doctor();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	 {
	 return DoctorObj.readDocDetails();
		//return "Hello";
	 }
	

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem
	(
	 @FormParam("Phone") String Phone, //`DID`,`Phone`,`Address`,`Specialization`,`Email`,`Name`
	 @FormParam("Address") String Address,
	 @FormParam("Specialization") String Specialization,
	 @FormParam("Email") String Email,
	
	 @FormParam("Name") String Name)
	
	{
		 String output = DoctorObj.insertDocDetails(Phone, Address, Specialization, Email, Name);
		return output;
		}
		
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDocDetails(String itemData)
	{
		//Convert the input string to a JSON object
		 JsonObject DoctorObj = new JsonParser().parse(itemData).getAsJsonObject();
		 //Read the values from the JSON object
		 String DID = DoctorObj.get("DID").getAsString();
		 String Phone = DoctorObj.get("Phone").getAsString();
		 String Address = DoctorObj.get("Address").getAsString();
		 String Specialization = DoctorObj.get("Specialization").getAsString();
		 String Email = DoctorObj.get("Email").getAsString();
		 String Name = DoctorObj.get("Name").getAsString();
		
		 
		 String output = this.DoctorObj.updateDocDetails(DID,Phone,Address,Specialization,Email,Name);
		
		return output;
		
		
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(itemData, " ", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String DID = doc.select("DID").text();
	 String output = DoctorObj.deleteDocDetails(DID);
	return output;
	}
	
		
	
	
	

}
