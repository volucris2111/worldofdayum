<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul id="menu">
	<c:if test="${not empty currentField.avatars}">
		<li class="ui-widget-header">Avatare</li>
		<c:forEach items="${currentField.avatars}" var="avatar">
			<li>${avatar.name}
				<ul>
					<li onclick="showAvatar('${avatar.id}')">Betrachten</li>
					<li>Brief</li>
					<li>Stehlen</li>
					<li>Angreifen</li>
				</ul>
			</li>
		</c:forEach>
	</c:if>
	<c:choose>
		<c:when test="${not empty currentField.building}">
			<li class="ui-widget-header">Gebäude</li>
		<li>Betreten</li>
		<li>Betrachten</li>
		</c:when>
		<c:otherwise>
			
		</c:otherwise>
	</c:choose>
</ul>
