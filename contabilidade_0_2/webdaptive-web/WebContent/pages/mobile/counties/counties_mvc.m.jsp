<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
	response.setContentType("text/html; charset=iso-8859-1");
	response.setHeader("Cache-Control", "no-cache, private, must-revalidate, max-stale=0, post-check=0, pre-check=0 no-store"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <title></title>
  <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
</head>
<body>
<div data-role="page" id="counties_mvc.m">
  <div data-theme="b" data-role="header">
    <h1>Counties MVC</h1>
    <a href="../pages/mobile/wd_main.m.jsp#samples" rel="external" data-icon="back" data-iconpos="left" data-direction="reverse" class="ui-btn-right">Back</a></div>
    <div data-role="content">
        <div class="ui-grid-a">
            <div class="ui-block-a ui-bar-b">County ID</div>
            <div class="ui-block-b ui-bar-b">County Description</div>
		 	<c:forEach items="${countyResponse.getCounties()}" var="county" varStatus="loop">
				<div class="ui-block-a ${loop.index % 2 == 0 ? 'ui-bar-c' : 'ui-bar-f'}"><c:out value="${county.id}" /></div>
				<div class="ui-block-b ${loop.index % 2 == 0 ? 'ui-bar-c' : 'ui-bar-f'}"><c:out value="${county.description}" /></div>
		 	</c:forEach>
        </div>
    </div>
</div>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
</body>
</html>
