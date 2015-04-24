<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<table>
	<tr>
		<td valign="top">
			<jsp:include page="../admin/adminSecNav.jsp"></jsp:include>
		</td>
		<td>
			<c:url  value="/admin/skills" var="url" />
			<form:form action="${url}" method="POST" modelAttribute="skill">
			<form:hidden path="id"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<table>
				<tr>
					<td>
						Name:
					</td>
					<td>
						<form:input path="name"/>
					</td>
				</tr>
				<tr>
					<td>
						Type:
					</td>
					<td>
						<form:select path="skillType" items="${skillTypes}"/>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<table>
						<tr>
							<td>
								Stufe
							</td>
							<td>
								EP Schwelle
							</td>
						</tr>
						<c:if test="${not empty skill.advancePointsThresholds}">
							<c:forEach items="${skill.advancePointsThresholds}" var="advancePointsThreshold" varStatus="advancePointsThresholdStatus">
								<tr>
									<td>
										${advancePointsThresholdStatus.index + 1}
									</td>
									<td>
										<input class="treshold" id="advancePointsThreshold${advancePointsThresholdStatus.index}" name="advancePointsThresholds[${advancePointsThresholdStatus.index}]" value="${advancePointsThreshold}"/>
									</td>
								</tr>
							</c:forEach>
						</c:if>
						<tr>
							<td>
								<button id="addTresholdButton">+</button>
							</td>
							<td>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp; 
					</td>
					<td>
						<form:button>Speichern</form:button>
					</td>
				</tr>
			</table>
			</form:form>
		</td>
	</tr>
</table>
<script type="text/javascript">
$(function(){
	var index = ${fn:length(skill.advancePointsThresholds)};
	$("#addTresholdButton").click(function(){
		$("#addTresholdButton").parent().parent().before("<tr><td>" + (index+1) + "</td><td><input class='treshold' onchange='sortValues()' id='advancePointsThreshold" + (index) + "' name='advancePointsThresholds[" + (index)+ "]'/></td></tr>");
		index++;
		return false;
	});
	$(".treshold").change(function(){
		sortValues();
	});
})

function sortValues()
{
	var values = []; 
	$(".treshold").each(function(index, input){ 
		values[index] = $(input).val();
	});
	values.sort(sortNumber);
	$(values).each(function(index, value){
		$("#advancePointsThreshold" + index).val(value);
	});	
}

function sortNumber(a,b) {
    return a - b;
}
</script>