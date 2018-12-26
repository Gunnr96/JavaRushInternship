<html>
<head><title>First JSP</title></head>
<body>
  <%
    PartService service = new PartService();
    out.println(service.getAll());
   %>
</body>
</html>