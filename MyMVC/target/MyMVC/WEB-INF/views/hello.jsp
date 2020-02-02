<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>
<h2>Student Information</h2>
<spring:form modelAttribute="users" method="post" action="/hello">
    <spring:input path="name" size="20">ran</spring:input>
    <spring:input path="age" size="20"></spring:input>
</spring:form>
</body>

</html>