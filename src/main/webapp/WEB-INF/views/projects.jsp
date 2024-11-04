<%@ page import="info.preva1l.slave.master.registries.Projects" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:head title="Projects"/>
<t:navigation currentPage="projects" />

<h1 class="text-3xl">Projects list bla bla</h1>

<div id="projects-container" class="flex gap-4 flex-wrap p-12">
    <c:forEach items="${Projects.toList()}" var="project">
        <t:project-card project="${project}"/>
    </c:forEach>
</div>