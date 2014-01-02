<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:if test="${page.hasPreviousPage()}">
	<spring:url value="" var="prev">
		<spring:param name="q" value="${query}" />
		<spring:param name="page" value="${page.number - 1}"></spring:param>
		<spring:param name="size" value="${page.size}"></spring:param>
	</spring:url>
	<a href="${prev}">prev &lt;</a>
</c:if>
<c:forEach var="index" begin="1" end="${page.totalPages}">
	<c:choose>
		<c:when test="${(index-1) == page.number}">
			<span><strong>${index}</strong></span>
		</c:when>
		<c:otherwise>
			<spring:url value="" var="next">
				<spring:param name="q" value="${query}" />
				<spring:param name="page" value="${index-1}"></spring:param>
				<spring:param name="size" value="${page.size}"></spring:param>
			</spring:url>
			<a href="${next}">${index}</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<c:if test="${page.hasNextPage()}">
	<spring:url value="" var="next">
		<spring:param name="q" value="${query}" />
		<spring:param name="page" value="${page.number + 1}"></spring:param>
		<spring:param name="size" value="${page.size}"></spring:param>
	</spring:url>
	<a href="${next}">&gt; next</a>
</c:if>