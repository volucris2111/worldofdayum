<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<body>
		<table>
			<tr>
				<td>
					Name:
				</td>
				<td>
					 ${avatarView.avatar.name}
				</td>
			</tr>
			<tr>
				<td>
					Geschlecht:
				</td>
				<td>
					<c:choose>
							<c:when test="${avatarView.avatar.male}">
								Männlich
							</c:when>
							<c:otherwise>
								Weiblich
							</c:otherwise>
						</c:choose>
				</td>
			</tr>
			<tr>
				<td>
					Beruf:
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
			</tr>
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/avatars/select/${avatarView.avatar.id}"><button>Auswählen</button></a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/avatars/"><button>Zurück</button></a>
				</td>
			</tr>
		</table>
	</body>
</html>