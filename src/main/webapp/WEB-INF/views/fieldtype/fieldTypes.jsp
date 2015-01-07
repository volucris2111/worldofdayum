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
								Feldname
							</th>
							<th>
								Bild
							</th>
							<th>
								Begehbar
							</th>
							<th>
								Bewegungsdauer
							</th>
							<th>
								<a href="<c:url value="/admin/fieldtypes/?create"/>"><button type="button">Neu</button></a>
							</th>
						</tr>
						<c:forEach items="${fieldTypes}" var="fieldType">
							<tr>
								<td>
									${fieldType.name}
								</td>
								<td>
									<div style="background-image: url(../resources/images/terrain.png); background-position: -${fieldType.sheetPositionX}px -${fieldType.sheetPositionY}px; height: 130px; width: 130px;"></div>
								</td>
								<td>
									<c:choose>
										<c:when test="${fieldType.walkable}">
											Ja
										</c:when>
										<c:otherwise>
											Nein
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									${fieldType.movementSpeed}
								</td>
								<td>
									<a href="<c:url value="/admin/fieldtypes/${fieldType.id}/?edit"/>"><button type="button">Edit</button></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>