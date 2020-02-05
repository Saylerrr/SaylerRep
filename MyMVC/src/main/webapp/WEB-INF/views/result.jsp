<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>
<h2>Submitted Student Information</h2>
<table>
    <tr>
        <td>Word first:</td>
        <td>${word_first}</td>
    </tr>
    <tr>
        <td>Word second:</td>
        <td>${word_second}</td>
    </tr>
</table>
</body>

</html>