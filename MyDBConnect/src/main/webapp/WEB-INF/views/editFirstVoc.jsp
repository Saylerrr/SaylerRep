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
        <td>Vocabulary number:</td>
        <td>${numVoc}</td>
    </tr>
</table>
<form:form method = "POST" action = "/editFirstVoc">
    <table>
        <tr>
            <td><form:label path = "word_first">Word first</form:label></td>
            <td><form:input path="word_first"/></td>
        </tr>
        <tr>
            <td><form:label path = "word_second">Word second</form:label></td>
            <td><form:input path="word_second"/></td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>

</html>