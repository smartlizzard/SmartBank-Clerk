<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ACCOUNT NO</title>
</head>
<body>
${msg}
<form action="accNoDtls">

<p>WELCOME :</p>
ACCOUNT NO :<input type="text" name="accNo"/><br/>
 <select name="accType">
  <!-- <option value="select">select</option> -->
  <option value="savings">savings</option>
  <option value="primary">primary</option>
</select>
<br/><br/>  
<input type="submit" value="SEARCH"/>  

</form>
</body>
</html>