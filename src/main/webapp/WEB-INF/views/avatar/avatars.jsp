<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<body>
		<table>
			<tr>
				<th>
					Avatar
				</th>
				<th>
					&nbsp;
				</th>
				<th>
					&nbsp;
				</th>
			</tr>
			<c:forEach items="${avatars}" var="avatar">
				<tr>
					<td>
						${avatar.name}
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/avatars/${avatar.id}"><button>Details</button></a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/avatars/select/${avatar.id}"><button>Auswählen</button></a>
					</td>
				</tr>		
			</c:forEach>
		</table>
	</body>
</html>