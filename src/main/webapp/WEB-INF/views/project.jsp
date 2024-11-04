<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="projectShortId" scope="request" type="java.lang.String"/>
<jsp:useBean id="project" scope="request" type="info.preva1l.slave.master.models.projects.Project"/>

<t:head title="${project.name}"/>
<t:navigation />

<body>
    <h1>${project.name}</h1>
    <p>
        ${project.description}
    </p>
</body>