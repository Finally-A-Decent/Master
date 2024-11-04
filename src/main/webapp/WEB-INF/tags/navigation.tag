<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag description="The websites header" pageEncoding="UTF-8" %>
<%@ attribute name="currentPage" required="false" type="java.lang.String" %>
<%
    if (currentPage == null) currentPage = "";

    String active = "px-3 py-2 rounded-md bg-gray-800 hover:bg-gray-600 transition-colors duration-300 text-white flex items-center gap-1";
%>

<nav id="primary-nav" class="header w-screen top-0 left-0 bg-gray-100 flex items-center justify-between h-20 px-[10%]">
    <a href="${pageContext.request.contextPath}/" class="logo text-lg font-bold bg-gradient-to-br bg-clip-text text-transparent from-red-500 to-blue-500">Finally a Decent Developer</a>
    <div class="header-right flex h-full items-center gap-4">
<%--    Search Bar --%>
        <div class="mr-4% w-64 bg-gray-800 text-gray-300 rounded-2xl h-8 flex border border-gray-600"></div>
<%--    Nav  Links --%>
        <a class="<%= currentPage.equalsIgnoreCase("home") ? active : "" %>" href="${pageContext.request.contextPath}/">
            <i class="bi bi-house-fill"></i>
            Home
        </a>
        <a class="<%= currentPage.equalsIgnoreCase("projects") ? "active" : "" %>" href="${pageContext.request.contextPath}/projects/">Projects</a>
        <a class="<%= currentPage.equalsIgnoreCase("login") ? "active" : "" %>" href="${pageContext.request.contextPath}/login/">Login</a>
    </div>
</nav>