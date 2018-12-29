<%@ page language="java" contentType="text/html;charset=ISO-8859-1" %>
<%@ page import="jspclass.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
	<title>BashanL4</title>

	<%!
		Regimex regimex = new Regimex();

		int currentDay = regimex.getDay();
		int currentMonth = regimex.getMonth() + 1;
		int currentYear = regimex.getYear();

		int currentHours = regimex.getHours();
		int currentMinutes = regimex.getMinutes();
		int currentSeconds = regimex.getSeconds();

		protected String salutation(int hours) {
			String result = "Good ";
			if (hours > 0 && hours <= 5) {
				result += "night";
			} else if (hours > 5 && hours <= 12) {
				result += "morning";
			} else if (hours > 12 && hours <= 17) {
				result += "afternoon";
			} else {
				result += "evening";
			}
			return result; 
		}

		protected int getPageByHour(int hours) {
			if (hours > 0 && hours <= 5) {
				return 0; 
			} else if (hours > 5 && hours <= 12) {
				return 1; 
			} else if (hours > 12 && hours <= 17) {
				return 2; 
			} else {
				return 3; 
			}
		}

		protected String getTime() {
			return String.valueOf(currentHours) + ":" +
				String.valueOf(currentMinutes) + ":" +
				String.valueOf(currentSeconds);
		}

		protected String getDate() {
			return String.valueOf(currentDay) + "." + 
				String.valueOf(currentMonth) + "." +
				String.valueOf(currentYear);
		}

		protected String getDate(int raw) {
			return String.valueOf(currentDay + raw) + "." + 
				String.valueOf(currentMonth) + "." +
				String.valueOf(currentYear);
		}
	%>
</head>
	<body>
		<p>
			<%= salutation(currentHours) %>
			<br>
			Now: <%= getTime() %>
		</p>
		<hr>
		<p>
			<table border="1">
				<tr>
					<td width="100px"><b>xx.dd.yyyy</b></td>
					<td width="100px"><b>Day of Week</td>
				</tr>
				<tr>
					<td width="100px"><%= getDate(0) %></td>
					<td width="100px"><%= regimex.getDayByDate(currentDay, currentMonth, currentYear) %></td>
				</tr>
				<tr>
					<td width="100px"><%= getDate(1) %></td>
					<td width="100px"><%= regimex.getDayByDate(currentDay + 1, currentMonth, currentYear) %></td>
				</tr>
				<tr>
					<td width="100px"><%= getDate(2) %></td>
					<td width="100px"><%= regimex.getDayByDate(currentDay + 2, currentMonth, currentYear) %></td>
				</tr>
				<tr>
					<td width="100px"><%= getDate(3) %></td>
					<td width="100px"><%= regimex.getDayByDate(currentDay + 3, currentMonth, currentYear) %></td>
				</tr>
				<tr>
					<td width="100px"><%= getDate(4) %></td>
					<td width="100px"><%= regimex.getDayByDate(currentDay + 4, currentMonth, currentYear) %></td>
				</tr>
				<tr>
					<td width="100px"><%= getDate(5) %></td>
					<td width="100px"><%= regimex.getDayByDate(currentDay + 5, currentMonth, currentYear) %></td>
				</tr>
				<tr>
					<td width="100px"><%= getDate(6) %></td>
					<td width="100px"><%= regimex.getDayByDate(currentDay + 6, currentMonth, currentYear) %></td>
				</tr>
			</table>
		</p>
		<hr>
		<p>
			<b>Use %Include%</b>
			<br>
			<%
			switch(getPageByHour(currentHours)) {
				case 0:
			%>
					<%--<%@include file="night.jsp"%>--%>
					<%--<jsp:include page="night.jsp"></jsp:include>--%>
					<jsp:forward page="night.jsp"></jsp:forward>
			<%
					break;
				case 1:
			%>
					<%--<%@include file="morning.jsp"%>--%>
					<jsp:include page="morning.jsp"></jsp:include>
					<%--<jsp:forward page="morning.jsp"></jsp:forward>--%>
			<%
					break;
				case 2:
			%>
					<jsp:include page="afternoon.jsp"></jsp:include>
					<%--<jsp:forward page="afternoon.jsp"></jsp:forward>--%>
					<%--<jsp:include page="/AfternoonServlet"/>--%>
			<%
					break;
				case 3:
			%>
					<%--<%@include file="evening.jsp"%>--%>
					<jsp:include page="evening.jsp"></jsp:include>
					<%--<jsp:forward page="evening.jsp"></jsp:forward>--%>
			<%
					break;
			}
			%>
		</p>
		<hr>
		<form action="SecondServlet">
			<a href="SecondServlet">Go to SecondServlet</a>
		</form>
		<form action="SecondServlet" method="get">
			<input type="submit" name="press" value="Request to servlet" size="20"/>
		</form>

	</body>
</html> 