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
					<table>
						<tr>
							<th>
								Klasse
							</th>
							<th>
								<a href="${pageContext.request.contextPath}/admin/avatarclasses/?create"><button type="button">Neu</button></a>
							</th>
						</tr>
						<c:forEach items="${avatarClasses}" var="avatarClass">
						<tr>
							<td>
								${avatarClass.nameMale}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/admin/avatarclasses/${avatarClass.id}/?edit"><button type="button">Edit</button></a>
							</td>
						</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>