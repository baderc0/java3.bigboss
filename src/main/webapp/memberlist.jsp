<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='styles/style.css' type='text/css' />
    <title>Member Management - List</title>
  </head>
  <body>
    <h3>List of Members</h3>
    <p style="text-align: right">[&emsp;${logInMember.membername}&emsp;|&emsp;<a href="logout">Logout</a>&emsp;]</p>
    <hr>
    <br>
    <form action="new" method="POST">
      <input type="submit" value="Add A New Member"/>
    </form>
    <br>    
    <form action="edit" method="POST">
      <table>
        <thead>
          <tr>
            <th></th>
            <th>ID</th>
            <th>Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Base Salary</th>
            <th>Bonus</th>
            <th>Employment Group</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="member" items="${listMember}">
            <tr>
              <td><input type="radio" name="id" value="${member.id}" /></td>
              <td><c:out value="${member.id}" /></td>
              <td><c:out value="${member.membername}" /></td>
              <td><c:out value="${member.password}" /></td>
              <td><c:out value="${member.email}" /></td>
              <td><c:out value="${member.basesalary}" /></td>
              <td><c:out value="${member.bonus}" /></td>
              <td><c:out value="${member.employmentgroup}" /></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <br>
      <input type="submit" value="Edit" name="button" />&emsp;
      <input type="submit" value="Delete" name="button" />
    </form>
    <br>
  </body>
</html>
