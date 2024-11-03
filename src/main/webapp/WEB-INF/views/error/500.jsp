<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Finally a Decent Error Page | 500</title>
</head>
<body>
<h1>Something went wrong (500)</h1>
<p>We're sorry, but something went wrong on our end. Please try again later.</p>
<a href="<%= request.getContextPath() %>/">Return to Homepage</a>
</body>
</html>