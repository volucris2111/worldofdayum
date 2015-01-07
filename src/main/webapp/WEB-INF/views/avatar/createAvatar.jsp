<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<html>
	<body>
		<form:form action="${pageContext.request.contextPath}/avatars/" method="POST" modelAttribute="avatar" >
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
						Geschlecht:
					</td>
					<td>
						 <form:select path="male" onchange="switchGender()" id="genderSelect">
						 	<form:option value="true">Männlich</form:option>
						 	<form:option value="false">Weiblich</form:option>
						 </form:select>
					</td>
				</tr>
				<tr>
					<td>
						Beruf:
					</td>
					<td>
						 <form:select path="avatarClassId" items="${avatarClasses}" itemLabel="nameMale" itemValue="id" id="avatarClassMale"/>
						 <form:select path="avatarClassId" items="${avatarClasses}" itemLabel="nameFemale" itemValue="id" id="avatarClassFemale"/>
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
		<script type="text/javascript">
			$(function() {
				switchGender();
			});
		
			function switchGender()
				{
					var male = $("#genderSelect").val() == 'true';
					var avatarClassFemaleSelect = $("#avatarClassFemale");
					var avatarClassMaleSelect = $("#avatarClassMale");
					if(male)
					{
						avatarClassFemaleSelect.hide();
						avatarClassFemaleSelect.prop("disabled", "disabled");
						avatarClassMaleSelect.show();
						avatarClassMaleSelect.prop("disabled", false);
					}
					else
					{	
						avatarClassMaleSelect.hide();
						avatarClassMaleSelect.prop("disabled", "disabled");
						avatarClassFemaleSelect.show();
						avatarClassFemaleSelect.prop("disabled", false);
					}
				}
		</script>
	</body>
</html>