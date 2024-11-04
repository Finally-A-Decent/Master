<%@ page import="info.preva1l.slave.master.registries.Projects" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:head title="Projects"/>
<t:navigation currentPage="projects" />

<h1>Projects list bla bla</h1>

<div id="projects-container">
    <c:forEach items="${Projects.toList()}" var="project">
        <div class="project">
            <img src="${pageContext.request.contextPath}/content/logos/${project.getShortId()}.png" alt="Project Logo">
            <h4 id="project-name">${project.getName()}</h4>
            <div id="btn-container">
                <a id="info-btn" class="project-btn">Info</a>
                <a id="docs-btn" class="project-btn">Docs</a>
            </div>
        </div>
    </c:forEach>
</div>