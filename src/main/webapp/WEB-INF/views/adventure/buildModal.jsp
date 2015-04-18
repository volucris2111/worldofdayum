<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
function built(buildingTypeId)
{
	$.ajax({
        url: '${pageContext.request.contextPath}/adventure/build/' + buildingTypeId + "/",
        type: "POST",
        data: $("#test").serialize(),
        success: function(data) {
        	$( "#dialog" ).html(data);
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader("X-Ajax-call", "true");
        },
	});
}
</script>
<table>
	<c:forEach items="${buildingTypes}" var="buildingType">
		<tr>
			<td>
				${buildingType.name}<button onclick="built('${buildingType.id}')">Bauen</button>
			</td>
		</tr>
	</c:forEach>
</table>
<form id="test">
</form>
<script type="text/javascript">
$(function() {
	 $( "#dialog" ).dialog( "option", "title", "Bauen");	
	
})
</script>