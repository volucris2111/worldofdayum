<%@ page language="java" buffer="none" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<a href="${pageContext.request.contextPath}/account/"><button>Account</button></a>
<a href="${pageContext.request.contextPath}/adventure/"><button>Abenteuer</button></a>
<a href="${pageContext.request.contextPath}/avatars/"><button>Avatare</button></a>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="${pageContext.request.contextPath}/admin/"><button>Admin</button></a>
</sec:authorize>