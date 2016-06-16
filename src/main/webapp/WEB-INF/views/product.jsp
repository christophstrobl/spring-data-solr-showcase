<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<html lang="us">
<head>
	<jsp:include page="../fragments/meta.jsp"></jsp:include>
	<script>
    $(function() {
        $( "#accordion" ).accordion();
    });
    </script>
</head>
<body>
	<jsp:include page="../fragments/searchbox.jsp"></jsp:include>
	<hr />
	<div style="margin-top: 5px; padding: 0 .7em;">
		<a href="javascript:history.back()">&lt;&lt; Back to List</a>
	</div>
	<br />	
	
	<div id="accordion">
		<h3>
			${product.name}
			<c:forEach var="i" begin="1" end="${product.popularity}"><span title="${product.popularity} stars" class="ui-icon ui-icon-star" style="float:right">&nbsp;</span></c:forEach>
		</h3>
		<div>
			<p>
				<c:if test="${fn:length(product.features) > 0}">
					<c:forEach var="feature" items="${product.features}">	
						${feature} <br />
					</c:forEach>
					<br />
				</c:if>
				<c:if test="${product.price != null}">Price: <fmt:formatNumber value="${product.price}" type="currency"/><br /></c:if>
				Available: ${product.available?"yes":"no"}<br />
			</p>
		</div>
		<c:if test="${product.location != null}">
			<h3>Store</h3>
			<div>
				<p>
					<img ismap="ismap" height="220" src="http://maps.googleapis.com/maps/api/staticmap?markers=color:green|${product.location.x},${product.location.y}&zoom=12&size=200x200&sensor=false" />
				</p>
			</div>
		</c:if>
	</div>	
</body>