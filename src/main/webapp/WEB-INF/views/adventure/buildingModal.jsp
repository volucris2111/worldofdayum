<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${not empty buildingForView}">
		
	</c:when>
	<c:otherwise>
		Gebäude konnte nicht gefunden werden!
	</c:otherwise>
</c:choose>


