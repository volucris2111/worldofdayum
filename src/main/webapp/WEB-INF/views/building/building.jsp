<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<table>
	<tr>
		<td>
		</td>
	</tr>
	<tr>
		<td>
			Besitzer:
		</td>
	</tr>
	<tr>
		<td>
			${buildingView.ownerAvatar.name}
		</td>
	</tr>
</table>

<script type="text/javascript">
$(function() {
	 $( "#dialog" ).dialog( "option", "title", "${buildingView.buildingType.name} (${buildingView.field.positionX}/${buildingView.field.positionY})");	
})
</script>