<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='styles/style.css' type='text/css' />
    <title>Member Management - Member</title>
  </head>
  <body> 
    <h3>
      <c:if test="${member != null}">Edit Member</c:if>
      <c:if test="${member == null}">Add New Member</c:if>
    </h3>
    <p style="text-align: right">[   ${logInMember.membername}   |   <a href="logout">Logout</a>   ]</p>
    <hr>
    <c:if test="${member != null}"><form action="update" method="post" style="display: inline;"></c:if>
    <c:if test="${member == null}"><form action="insert" method="post" style="display: inline;"></c:if>
    <c:if test="${member != null}"><input type="hidden" name="id" value="<c:out value='${member.id}'/>" /></c:if>
      <label>Member Name: </label> <input type="text" value="<c:out value='${member.membername}' />" name="name" required><br>
      <label>Password: </label> <input type="text" value="<c:out value='${member.password}' />" name="password" required><br>
      <label>Member Email: </label> <input type="email" value="<c:out value='${member.email}' />" name="email" required><br>
      <label>Base Salary: </label> <input type="number" min="0" step="any" value="<c:out value='${member.basesalary}' />" name="basesalary" required><br>
      <label>Bonus: </label> <input type="number" min="0" step="any" value="<c:out value='${member.bonus}' />" name="bonus" required><br>
      <label>Employment Group: </label>      
      <select name="employmentgroup" required>
        <option></option>
        <c:forEach var="group" items="${employmentgroupList}"> 
          <option <c:if test="${member.employmentgroup == group.groupname}">selected="true"</c:if>>
            <c:out value="${group.groupname}" />
          </option>
        </c:forEach>
      </select>
      <br>
      <input type="submit" value="Save"  name="button" />
    </form>
    <form action="list" method="post" style="display: inline;">
      <input type="submit" value="Cancel"  name="button" /> 
    </form>
  </body>
</html>
