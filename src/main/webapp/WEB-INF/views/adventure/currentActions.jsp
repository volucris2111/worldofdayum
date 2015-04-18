<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul id="menu">
	<li class="ui-widget-header">${currentField.fieldType.name}</li>
	<li class="ui-state-disabled">Verstecken</li>
	<c:if test="${not empty currentField.avatars}">
		<li class="ui-widget-header">Avatare</li>
		<c:forEach items="${currentField.avatars}" var="avatar">
			<li>${avatar.name}
				<ul>
					<li onclick="showAvatar('${avatar.id}')">Betrachten</li>
					<li class="ui-state-disabled">Brief</li>
					<li class="ui-state-disabled">Stehlen</li>
					<li class="ui-state-disabled">Angreifen</li>
				</ul>
			</li>
		</c:forEach>
	</c:if>
	<li class="ui-widget-header">Gebäude</li>
	<c:choose>
		<c:when test="${not empty currentField.building}">
			<li class="ui-state-disabled">Betreten</li>
			<li onclick="showBuilding('${currentField.building.id}')">Betrachten</li>
		</c:when>
		<c:otherwise>
			<li onclick="build()">Bauen</li>
		</c:otherwise>
	</c:choose>
</ul>
