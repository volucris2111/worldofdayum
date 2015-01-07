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
					Beruf
				</th>
				<th>
					&nbsp;
				</th>
				<th>
					&nbsp;
				</th>
			</tr>
			<c:forEach items="${avatarViews}" var="avatarView">
				<tr>
					<td>
						${avatarView.avatar.name}
					</td>
					<td>
						<c:choose>
							<c:when test="${avatarView.avatar.male}">
								${avatarView.avatarClass.nameMale}
							</c:when>
							<c:otherwise>
								${avatarView.avatarClass.nameFemale}
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/avatars/${avatarView.avatar.id}"><button>Details</button></a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/avatars/select/${avatarView.avatar.id}"><button>Auswählen</button></a>
					</td>
				</tr>		
			</c:forEach>
		</table>
	</body>
</html>