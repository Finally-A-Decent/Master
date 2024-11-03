<%@ tag description="The websites header" pageEncoding="UTF-8" %>
<%@ attribute name="currentPage" required="false" type="java.lang.String" %>
<% if (currentPage == null) currentPage = ""; %>

<style><%@include file="/WEB-INF/css/header.css"%></style>

<nav id="primary-nav" class="header">
    <a href="${pageContext.request.contextPath}/" class="logo">Finally a Decent Developer</a>
    <div class="header-right">
        <a class="<%= currentPage.equalsIgnoreCase("home") ? "active" : "" %>" href="${pageContext.request.contextPath}/">Home</a>
        <a class="<%= currentPage.equalsIgnoreCase("projects") ? "active" : "" %>" href="${pageContext.request.contextPath}/projects/">Projects</a>
        <a class="<%= currentPage.equalsIgnoreCase("login") ? "active" : "" %>" href="${pageContext.request.contextPath}/login/">Login</a>
    </div>
</nav>