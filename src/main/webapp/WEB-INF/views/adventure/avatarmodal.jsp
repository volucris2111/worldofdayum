<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${not empty avatarForView}">
		<table>
			<tr>
				<td>
					Name:
				</td>
				<td>
					${avatarForView.name}
				</td>
			</tr>
			<tr>
				<td>
					Geschlecht:
				</td>
				<td>
					<c:choose>
						<c:when test="${avatarForView.male}">
							Männlich
						</c:when>
						<c:otherwise>
							Weiblich
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		Avatar konnte nicht gefunden werden!
	</c:otherwise>
</c:choose>


