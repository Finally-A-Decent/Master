<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Finally a Decent Error Page | 404</title>
</head>
<body>
<h1>Ermm... Page not found (404)</h1>
<p>The page you are looking for might have been removed, had its name changed, or is temporarily unavailable.</p>
<a href="<%= request.getContextPath() %>/">Return to Homepage</a>
</body>
</html>