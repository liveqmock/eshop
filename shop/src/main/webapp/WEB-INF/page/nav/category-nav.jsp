<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="math" uri="http://www.shangtech.net/tags/math"%>
<div class="nav">
	<div class="main-nav">
		<jsp:include page="/WEB-INF/page/nav/top-nav.jsp"/>
	</div>
	<div class="category-nav">
		<ul>
		<c:forEach items="${categoryList}" var="category" varStatus="i">
			<li class="category-icon ${currentCategory.id eq category.id or currentCategory.parentId eq category.id ? 'cur' : ''} ${i.index eq 0 ? 'first-category-icon' : ''}">
				<c:if test="${not empty category.children}">
					<ul style="width:${60*math:ceil(fn:length(category.children)/2)}px;">
					<c:forEach items="${category.children}" var="child">
						<li class="${currentCategory.id eq child.id ? 'cur' : ''}">
							<c:if test="${not (currentCategory.id eq child.id)}">
							<a href="${ctx}/${currentTopCategory.code}/${category.code}/${child.code}/list">${child.name}</a>
							</c:if>
							<c:if test="${currentCategory.id eq child.id}">${child.name}</c:if>
						</li>
					</c:forEach>
					</ul>
				</c:if>
				<a href="${ctx}/${currentTopCategory.code}/${category.code}/list"><span></span><div class="category-name">${category.name}</div></a>
			</li>
		</c:forEach>
		</ul>
	</div>
</div>