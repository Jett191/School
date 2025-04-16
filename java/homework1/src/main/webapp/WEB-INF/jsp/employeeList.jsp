<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>Employee List</title>
</head>
<body>
<!-- 显示所有员工 -->
<h2>Employee List</h2>
<table border="1">
  <tr>
    <th>empId</th>
    <th>deptId</th>
    <th>name</th>
    <th>salary</th>
  </tr>
  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.empId}</td>
      <td>${employee.deptId}</td>
      <td>${employee.name}</td>
      <td>${employee.salary}</td>
    </tr>
  </c:forEach>
</table>

<hr />

<!-- 添加员工 -->
<h3>Add a new Employee</h3>
<form action="${pageContext.request.contextPath}/employee/add" method="post">
  <p>
    <label for="deptId">Dept ID:</label>
    <input type="text" id="deptId" name="deptId" />
  </p>
  <p>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" />
  </p>
  <p>
    <label for="salary">Salary:</label>
    <input type="text" id="salary" name="salary" />
  </p>
  <p>
    <input type="submit" value="Add" />
  </p>
</form>

<hr />

<!-- 根据部门查询员工 -->
<h3>Query Employees by Department</h3>
<form action="${pageContext.request.contextPath}/employee/byDept" method="get">
  <label for="queryDeptId">Dept ID:</label>
  <input type="text" id="queryDeptId" name="deptId" />
  <input type="submit" value="Search" />
</form>

</body>
</html>
