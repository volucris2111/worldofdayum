<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<html>
	<body>
		<form:form action="${pageContext.request.contextPath}/avatars/" method="POST" modelAttribute="avatar" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<table>
				<tr>
					<td>
						Name:
					</td>
					<td>
						 <form:input path="name"/>
					</td>
				</tr>
				<tr>
					<td>
						Geschlecht:
					</td>
					<td>
						 <form:select path="male">
						 	<form:option value="true">Männlich</form:option>
						 	<form:option value="false">Weiblich</form:option>
						 </form:select>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<form:button>Speichern</form:button>
					</td>
				</tr>
			</table>
		</form:form>
	</body>
</html>