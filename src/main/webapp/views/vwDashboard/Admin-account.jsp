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
            <div class="user">
              <div class="info">
                <img src="avt.jpg" width="40px" height="40px" alt="avatar">
                <div>
                  <h4>Lewis</h4>
                  <small>CEO Excerpt</small>
                </div>
              </div>
              <div class="contact">
                <span class="las la-user-circle"></span>
                <span class="las la-comment"></span>
                <span class="las la-envelope"></span>
              </div>
              <div class="edit">
                <button class="las la-edit" type="button"></button>
                <button class="las la-trash" type="button"></button>
              </div>
            </div>

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