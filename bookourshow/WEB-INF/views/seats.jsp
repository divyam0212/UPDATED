<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- ${allSeatList }
${bookedSeatList } --%>
	<c:set var="i" value="0"></c:set>
	<form method="post" action="SeatController">
	
	<%-- <input type="hidden" name="cityId" value="${cityId }">
	<input type="hidden" name="languageId" value="${languageId }">
	<input type="hidden" name="movieId" value="${movieId }">
	<input type="hidden" name="timingId" value="${timingId }"> --%>
	
	<input type="hidden" name="venueScheduleId" value="${venueScheduleId }">
	<input type="hidden" name="bookDate" value="${bookDate }">
	
		<c:forEach items="${allSeatList }" var="seat">
			<c:set var="isChecked" scope="session" value="${5 }" />
			<c:forEach items="${bookedSeatList }" var="bookedseat">
				<c:if test="${seat eq bookedseat }">
					<c:set var="isChecked" value="${10 }" />
				</c:if>
			</c:forEach>
			<input type="checkbox" name="seats" value="${seat}"<c:if test="${isChecked eq 10 }">checked="checked"</c:if>>${seat}
				<c:set var="i" value="${i + 1}"></c:set>
				<c:if test="${i eq 5 }">
					<br>
					<c:set var="i" value="0"></c:set>
				</c:if>
				<c:if test="${i ne 5 }">
					<br>
					<c:set var="i" value="${i + 1 }"></c:set>
				</c:if>
				<c:set var="isChecked" value="${15 }"/>
		</c:forEach>
	<input type="submit" name="submit" value="BOOK SEATS">
	${bookedSeatList} 
	</form>
</body>
</html>