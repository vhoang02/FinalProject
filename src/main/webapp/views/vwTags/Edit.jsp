<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="tag" scope="request" type="com.example.finalproject.beans.Tag"/>

<t:main>
  <jsp:body>
    <form action="" method="post">
      <div class="card">
        <h4 class="card-header">
          Tag
        </h4>
        <div class="card-body">
          <div class="form-group">
            <label for="txtTagID">#</label>
            <input type="text" class="form-control" id="txtTagID" name="tag_id" readonly value="${tag.tagID}">
          </div>
          <div class="form-group">
            <label for="txtTagName">Tag</label>
            <input type="text" class="form-control" id="txtTagName" name="value" autofocus value="${tag.val}">

          </div>
        </div>
        <div class="card-footer">
          <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/Admin/Tag/" role="button">
            <i class="fa fa-backward" aria-hidden="true"></i>
            List
          </a>
          <button type="submit" class="btn btn-danger" formaction="${pageContext.request.contextPath}/Admin/Tag/Delete">
            <i class="fa fa-trash-o" aria-hidden="true"></i>
            Delete
          </button>
          <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/Admin/Tag/Update">
            <i class="fa fa-check" aria-hidden="true"></i>
            Save
          </button>
        </div>
      </div>
    </form>
  </jsp:body>
</t:main>