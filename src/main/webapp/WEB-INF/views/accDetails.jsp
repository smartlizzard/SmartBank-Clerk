<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ACCOUNT DETAILS</title>
</head>
<body>
<h2>ACCOUNT DETAILS:</h2>
<table border="1" id="planTable">
		<thead>
			<tr>
				<td>NAME</td>
				<td>ACCOUNT NO</td>
				<td>BALANCE</td>
				<td>ACCOUNT TYPE</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${account}" var="acc">
				<tr>
					<td><c:out value="${name}" /></td>
					<td><c:out value="${acc.accountNumber}" /></td>
					<td><c:out value="${acc.accountBalance}" /></td>
					<td><c:out value="${accType}"></c:out></td>
						
				</tr>
			</c:forEach>
		</tbody>
</table>
<br/>
<a href="/">Search Again</a>
<br/><br/>
<h1>DO TRANSACTION</h1>
<form:form action="txByBank" method="POST" modelAttribute="baseAcc">
<p>ACCOUNT NO</p>
<form:input path="accNo" id="accNo" readonly="true" />
<p>ENTER AMOUNT</p>
<form:input path="balance" id="balance" />
<p>SELECT OPERATION</p> 
        DEPOSITE <form:radiobutton path="operation" value="deposite"/>  
        WITHDRAW <form:radiobutton path="operation" value="withdraw"/>
        
 <br/> <br/> <br/>       
	<input type="submit" value="SUBMIT" /> 
</form:form>
</body>
<br/>
</html>