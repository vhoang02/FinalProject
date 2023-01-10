<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:main_edit>

  <jsp:body>
    <main>
      <form method="post">
        <div class="card">
          <h5 class="card-header">Detail Article</h5>

          <div class="card-body">
            <div class="form-group">

              <label for="artID">Article ID</label>
              <input name="artID" type="text" value="${dtl.articles_id}" class="form-control" id="artID" autofocus
                     placeholder="Title of Article" readonly>
            </div>
          </div>
          <div class="card-body">
            <div class="form-group">

              <label for="tit">Title</label>
              <input name="tit" type="text" value="${dtl.title}" class="form-control" id="tit" autofocus
                     placeholder="Title of Article" readonly>
            </div>
          </div>

          <div class="card-body">
            <div class="form-group">

              <label for="txtPubDate">Publish Date</label>
                <%--<input type="text"  value="<fmt:formatDate type="both" dateStyle="short"
                        timeStyle="short" value="${dtl.publish_date}"/>" class="form-control" id="txtPubDate" name="PubDate" readonly>--%>
              <input type="text"  value="${dtl.publish_date}" class="form-control" id="txtPubDate" name="PubDate" readonly>

            </div>
          </div>

          <div class="card-body">
            <div class="form-group">
              <label for="vview">Views</label>
              <input name="viewNum" value="${dtl.views}" type="text" class="form-control"
                     id="vview" readonly>
            </div>
          </div>


          <div class="card-body">
            <div class="form-group">
              <div class="form-outline">
                <textarea name="abstr" class="form-control" id="abstr" rows="autofocus" readonly>${dtl.abstracts}</textarea>
                <label class="form-label" for="abstr">Absstract</label>
              </div>
            </div>
          </div>


          <div class="card-body">
            <div class="form-group">
              <div class="form-outline">
                <textarea name="cont" class="form-control" id="textAreaExample" rows="autofocus" readonly>${dtl.content}</textarea>
                <label class="form-label" for="textAreaExample">Content</label>
              </div>
            </div>
          </div>


          <div class="card-body">
            <!-- form-group // -->
            <div class="form-group">
              <label for="CATEID" class="col-sm-3 control-label">Category</label>
              <input name="CATEID" value="${dtl.categories_id}" type="text" class="form-control" id="CATEID" readonly>
            </div>
          </div>

          <div class="card-body">
            <!-- form-group // -->
            <div class="form-group">

              <c:choose>
                <c:when test="${dtl.premium == true}">

                  <i class="las la-star"></i>
                  Premium

                </c:when>
                <c:otherwise>

                  <i class="lar la-star"></i>
                  Standard

                </c:otherwise>
              </c:choose>
            </div>
          </div>

          <div class="card-body">
            <!-- form-group // -->
            <div class="form-group">
              <label for="wID" class="col-sm-3 control-label">Writer</label>
              <input name="wID" value="${dtl.writer_id}" type="text" class="form-control" id="wID" readonly>
            </div>
          </div>

          <div class="card-body">
            <div class="form-group">
              <c:choose>
                <c:when test="${dtl.status == 100001}">
                  <td>
                    <i class="las la-check-circle"></i>
                    Public
                  </td>
                </c:when>
                <c:otherwise>
                  <td>
                    <i class="las la-exclamation-circle"></i>
                    Draft
                  </td>
                </c:otherwise>
              </c:choose>
            </div>
          </div>

          <c:choose>
            <c:when test="${dtl.status == 100001}">
              <div class="card-footer text-muted">
                <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Editor/Project?eId=${authUser.user_id}"
                   role="button">
                  <i class="fa fa-backward" aria-hidden="true"></i>
                  Back
                </a>
              </div>
            </c:when>
            <c:otherwise>
              <div class="card-footer text-muted">
                <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Editor/Project?eId=${authUser.user_id}"
                   role="button">
                  <i class="fa fa-backward" aria-hidden="true"></i>
                  Back
                </a>
                <button type="submit" class="btn btn-outline-dark" formaction="${pageContext.request.contextPath}/Editor/Project/Public?eId=${authUser.user_id}">
                  <i class="fa fa-check" aria-hidden="true"></i>
                  Public
                </button>
              </div>
            </c:otherwise>
          </c:choose>


        </div>
      </form>
    </main>


  </jsp:body>
</t:main_edit>