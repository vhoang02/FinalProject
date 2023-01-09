<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>
  <jsp:body>
    <main>
      <div class="cards">
        <div class="card-singles">
          <div>
            <h1>54</h1>
            <span>User</span>
          </div>
          <div>
            <span class="las la-users"></span>
          </div>
        </div>
      </div>
      <br/>
      <div class="users">
        <div class="card">
          <div class="card-header">
            <h3>All users</h3>
            <button><span class="las la-plus">
                            </span>Add user</button>
          </div>
          <div class="card-body">
          <c:forEach items="${listUser}" var="acc">
            <div class="user">
              <div class="info">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="green" class="bi bi-person-circle" viewBox="0 0 16 16">
                  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                </svg>
                <div>
                  <h4>&nbsp; ${acc.name}</h4>
                  <small>&nbsp;${acc.second_name}</small>
                </div>
              </div>
              <div class="contact">
                <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Account/Download?id=${acc.user_id}" role="button">
                  <i class="las la-info"></i>
                </a>
                <a class="btn btn-outline-dark" href="mailto:${acc.email}" role="button">
                <i class="las la-envelope"></i>
                </a>
              </div>
              <div class="edit">
                <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Account/Edit?uID=${acc.user_id}" role="button">
                  <i class="las la-edit"></i>
                </a>
                <a href="${pageContext.request.contextPath}/Admin/Account/Delete?uID=${acc.user_id}" class="btn btn-outline-dark"><i class="las la-trash"></i></a>
              </div>
            </div>
          </c:forEach>
          </div>
          <div class="card-footer">
            <div class="pagination">
              <a href="#">«</a>
              <a href="#">1</a>
              <a class="active" href="#">2</a>
              <a href="#">3</a>
              <a href="#">4</a>
              <a href="#">5</a>
              <a href="#">6</a>
              <a href="#">»</a>
            </div>
          </div>
        </div>
      </div>
      </div>
    </main>
  </jsp:body>
</t:main_dash>