<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>

  <jsp:body>
    <main>
      <form method="post">
        <div class="card">
          <h5 class="card-header">New Tag</h5>
          <div class="card-body">
            <div class="form-group">
              <label for="TagVal">Tag value</label>
              <input name="TagVal" type="text" class="form-control" id="TagVal" autofocus
                     placeholder="Thẻ Tag">
            </div>
          </div>
          <div class="card-footer text-muted">
            <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Tag"
               role="button">
              Back
            </a>
            <button type="submit" class="btn btn-outline-dark">
              Save
            </button>
          </div>
        </div>
      </form>
    </main>


  </jsp:body>
</t:main_dash>