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
								Fähigkeit
							</th>
							<th>
								Type
							</th>
							<th>
								<a href="<c:url value="/admin/skills/?create"/>"><button type="button">Neu</button></a>
							</th>
						</tr>
						<c:forEach items="${skills}" var="skill">
							<tr>
								<td>
									${skill.name}
								</td>
								<td>
									${skill.skillType}
								</td>
								<td>
									<a href="<c:url value="/admin/skills/${skill.id}/?edit"/>"><button type="button">Edit</button></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>