<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String uname=request.getParameter("uname");
String pwd=request.getParameter("pwd");

if(uname.equals("") && uname.length()==0 || pwd.equals("") && pwd.length()==0){

out.println("Provide Credentials");
return;

}

if(uname.equals("raja") && pwd.equals("rani"))
out.println("Valid Credentials");
else
out.println("Invalid Creadentials");

 %>
