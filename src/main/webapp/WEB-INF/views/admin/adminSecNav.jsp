<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<body>
		<table>
			<tr>
				<td>
					<a href="<c:url value="/admin/fieldtypes"/>"><button>FeldTypen</button></a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="<c:url value="/admin/areaeditor"/>"><button>AreaEditor</button></a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="<c:url value="/admin/buildingtypes"/>"><button>GebäudeTypen</button></a>
				</td>
			</tr>
		</table>
	</body>
</html>