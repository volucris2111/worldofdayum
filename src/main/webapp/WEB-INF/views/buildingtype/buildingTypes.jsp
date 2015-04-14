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
								Gebäudename
							</th>
							<th>
								Bild
							</th>
							<th>
								<a href="<c:url value="/admin/buildingtypes/?create"/>"><button type="button">Neu</button></a>
							</th>
						</tr>
						<c:forEach items="${buildingTypes}" var="buildingTypes">
							<tr>
								<td>
									${buildingTypes.name}
								</td>
								<td>
									<div style="background-image: url(../resources/images/building.png); background-position: -${buildingTypes.sheetPositionX}px -${buildingTypes.sheetPositionY}px; height: 130px; width: 130px;"></div>
								</td>
								<td>
									<a href="<c:url value="/admin/buildingtypes/${buildingTypes.id}/?edit"/>"><button type="button">Edit</button></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>