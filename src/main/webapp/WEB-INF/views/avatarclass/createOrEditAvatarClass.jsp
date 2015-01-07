<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
	<body>
		<table>
			<tr>
				<td valign="top">
					<jsp:include page="../admin/adminSecNav.jsp"></jsp:include>
				</td>
				<td>
					<c:url value="/admin/avatarclasses" var="url" />
					<form:form action="${url}" method="POST" modelAttribute="avatarClass" >
					<form:hidden path="id"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<table>
						<tr>
							<td>
								Männliche Bezeichnung:
							</td>
							<td>
								<form:input path="nameMale"/>
							</td>
						</tr>
						<tr>
							<td>
								Weibliche Bezeichnung:
							</td>
							<td>
								<form:input path="nameFemale"/>
							</td>
						</tr>
						<tr>
							<td>
								Starterklasse:
							</td>
							<td>
								<form:checkbox path="starterClass"/>
							</td>
						</tr>
						<tr>
							<td>
								Fähigkeiten:
							</td>
							<td>
								<table id="skills">
									<tr>
										<th>
											Fähigkeit
										</th>
										<th>
											Exp
										</th>
										<th>
											Spezialisert
										</th>
									</tr>
									<c:forEach items="${avatarClass.skills}" var="skill" varStatus="skillStatus">
										<tr>
											<td>
												<form:select path="skills[${skill.key}].skill" onchange="changeSkill(this)">
													<form:options items="${skills}" itemLabel="name"/>
												</form:select>
											</td>
											<td>
												<form:input path="skills[${skill.key}].exp"/>
											</td>
											<td>
												<form:checkbox path="skills[${skill.key}].specialized"/>
											</td>
											<td><button type="button" onclick="removeSkill(this)">-</button></td>
										</tr>
									</c:forEach>
								</table>
								<button type="button" onclick="addSkill()">+</button>
							</td>
						</tr>
						<tr>
							<td>
								Beschreibung:
							</td>
							<td>
								<form:input path="description"/>
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
			function addSkill()
			{
				var tableRow = "";
				tableRow = "<tr><td><select name='' onchange='changeSkill(this)'>" + getSkillDropdownOptions() + "</select></td><td><input name='' type='text' value='0'></td><td><input name='' type='checkbox' value='true'><input type='hidden' name='' value='on'></td><td><button type='button' onclick='removeSkill(this)'>-</button></td></tr>";
				$("#skills").append(tableRow);
			}
			
			function removeSkill(skill)
			{
				$(skill).closest("tr").remove();
			}
			
			function changeSkill(dropdown)
			{
				var jDropdown = $(dropdown);
				var parentTr = jDropdown.closest("tr");
				jDropdown.attr("name", "skills[" + jDropdown.val() +"].skill");
				var jInputs = parentTr.children("td").children("input");
				jInputs.attr("name", "skills[" + jDropdown.val() +"].exp");
				jInputs.next().attr("name", "skills[" + jDropdown.val() +"].specialized");
				jInputs.next().attr("name", "_skills[" + jDropdown.val() +"].specialized");
			}
			
			function getSkillDropdownOptions()
			{
				var options = "<option value=''></option>";
				<c:forEach items="${skills}" var="skillOption">
				options = options + "<option value='${skillOption}'>${skillOption.name}</option>"	
				</c:forEach>
				return options;
			}
		</script>
	</body>
</html>

