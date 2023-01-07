<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>

  <jsp:body>
    <main>
      <form method="post">
        <div class="card">
          <h5 class="card-header">Edit Tag</h5>
          <div class="card-body">
            <div class="form-group">
              <label for="TagID">#</label>
              <input name="TagID" value="${Tagg.tag_id}" type="text" class="form-control"
                     id="TagID" readonly>
            </div>
            <div class="card-body">
            <div class="form-group">
              <label for="TagVal">Category</label>
              <input name="TagVal" value="${Tagg.value}" type="text" class="form-control"
                     id="TagVal" autofocus placeholder="Laptop">
            </div>
          </div>

          <div class="card-footer text-muted">
            <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Tag"
               role="button">
              <i class="fa fa-backward" aria-hidden="true"></i>
              Back
            </a>
            <button type="submit" class="btn btn-outline-dark"
                    formaction="${pageContext.request.contextPath}/Admin/Tag/Update">
              <i class="fa fa-check" aria-hidden="true"></i>
              Save
            </button>
          </div>
        </div>
      </form>
    </main>


  </jsp:body>
</t:main_dash>