<%@ page import="info.preva1l.slave.master.registries.Projects" %>
<jsp:useBean id="projectShortId" scope="request" type="java.lang.String"/>
<jsp:useBean id="project" scope="request" type="info.preva1l.slave.master.models.projects.Project"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${projectShortId}</title>
</head>
<body>
    <h1>${project.name}</h1>
    <p>
        ${project.description}
    </p>

    <%= Projects.FADAH.getPrice() %>
</body>
</html>
