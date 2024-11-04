<%@ tag description="Reusable head content" pageEncoding="UTF-8" %>
<%@ attribute name="title" required="true" type="java.lang.String" %>

<head>
    <title>${title} | Finally a Decent</title>

    <link rel="stylesheet preconnect" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet preconnect" href="${pageContext.request.contextPath}/css/app.css">
</head>