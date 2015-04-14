<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<body>
		<table>
			<tr>
				<td valign="top">
					<jsp:include page="../admin/adminSecNav.jsp"></jsp:include>
				</td>
				<td>
					<c:url  value="/admin/buildingtypes" var="url" />
					<form:form action="${url}" method="POST" modelAttribute="buildingType">
					<form:hidden path="id"/>
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
								SheetPositionX:
							</td>
							<td>
								<form:input path="sheetPositionX"/>
							</td>
						</tr>
						<tr>
							<td>
								SheetPositionY:
							</td>
							<td>
								<form:input path="sheetPositionY"/>
							</td>
						</tr>
						<tr>
							<td>
								Benötigtes Feld:
							</td>
							<td>
								<form:select path="requiredFieldTypeId" items="${fieldTypes}" itemLabel="name" itemValue="id"></form:select>
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
				</td>
			</tr>
		</table>
	</body>
</html>