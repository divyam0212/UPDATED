<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name="moviedetail" action="DispVenue" method="post">
	<input type="hidden" name="cityId" value="${cityId }">
	<input type="hidden" name="movieId" value="${movieId }">
	<input type="date" name="bookDate">
	<label>Select Language</label>
	<select name="languageId">
		<c:forEach items="${languageList }" var="language">
			<option value="${language.languageId }">${language.languageName}</option>
		</c:forEach>
	</select>
	<input type="submit" name="submit" value="EXPLORE">
</form>
</body>
</html>