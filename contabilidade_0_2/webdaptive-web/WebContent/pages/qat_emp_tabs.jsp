<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
<%
	response.setContentType("text/html; charset=utf-8");
	response.setHeader("Cache-Control", "no-cache, private, must-revalidate, max-stale=0, post-check=0, pre-check=0 no-store"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div id="qatmvctabsEmp">
	<ul>
		<sec:authorize access="hasAnyRole('ROLE_DOMAIN USERS', 'ROLE_DOMAIN ADMINS')">
	        <li><a href="../empresa/fetchEmpresasByRequestBAS" title="qatmvctab-1"><span>Empresa</span></a></li>
		</sec:authorize>
	</ul>
	<ul>
		<sec:authorize access="hasAnyRole('ROLE_DOMAIN USERS', 'ROLE_DOMAIN ADMINS')">
	        <li><a href="../empresa/addEmpresasByRequestBAS" title="qatmvctab-2"><span>add Empresa</span></a></li>
		</sec:authorize>
	</ul>
	<div class="tabscontent">
		<sec:authorize access="hasAnyRole('ROLE_DOMAIN USERS', 'ROLE_DOMAIN ADMINS')">
			<div id="qatmvctab-1"></div>
		</sec:authorize>
	</div>
	<div class="tabscontent">
		<sec:authorize access="hasAnyRole('ROLE_DOMAIN USERS', 'ROLE_DOMAIN ADMINS')">
			<div id="qatmvctab-2"></div>
		</sec:authorize>
	</div>
</div>
<script type="text/javascript" src="../commons/scripts/util/wd_tabs_actions.js"></script>
</body>
</html>
