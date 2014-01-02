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
</head>
<body>
	<jsp:include page="../fragments/searchbox.jsp"></jsp:include>
	<hr />
	<c:choose> 
		<c:when test="${fn:length(page.content) == 0}">
			<div class="ui-state-highlight ui-corner-all" style="margin-top: 5px; padding: 0 .7em;">
				<p>
					<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
					Sorry, no match found for <strong>'${query}'</strong>.
				</p>
			</div>
		</c:when>
		<c:otherwise>
			<div style="margin-top: 5px; padding: 0 .7em;">
				<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
				Found ${page.totalElements} item(s).
			</div>
			<br />		
			<fmt:setLocale value="en_US"/>	
			<c:forEach var="item" items="${page.content}" varStatus="status">
				<div class="ui-widget-content ui-corner-all" style="margin-top: .5em; padding-left: .5em; background: ${status.index %2==0 ?'#eee':'#fff'}">
					<h3><a href="<c:url value="/product/${item.id}" />">${item.name}</a></h3>
					<c:if test="${fn:length(item.features) > 0}">${item.features[0]} <br /></c:if>
					<c:if test="${item.price != null}">Price: <fmt:formatNumber value="${item.price}" type="currency"/><br /></c:if>
					Available: ${item.available?"yes":"no"}<br />
					<br />
					<c:forEach var="highlight" items="${page.getHighlights(item) }" varStatus="highlightStatus">
					${highlight.getSnipplets()}
					</c:forEach>
				</div>
			</c:forEach>
			<br />
			<jsp:include page="../fragments/pager.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
</body>