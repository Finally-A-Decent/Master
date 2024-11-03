<%@ tag description="The websites header" pageEncoding="UTF-8" %>
<%@ attribute name="currentPage" required="false" type="java.lang.String" %>
<% if (currentPage == null) currentPage = ""; %>

<div style="background: <%= currentPage.equalsIgnoreCase("home") ? "aqua" : "red" %>; width: 100px; height: 100px;">

</div>