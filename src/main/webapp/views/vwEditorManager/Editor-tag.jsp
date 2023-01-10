<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_edit>
  <jsp:body>
    <main>
      <div class="cards">
        <div class="card-singles">
          <div>
            <h1>${count}</h1>
            <span>Tags</span>
          </div>
          <div>
            <span class="las la-clipboard-list"></span>
          </div>
        </div>
      </div>

      <div class="recent-grid">
        <div class="projects">
          <div class="card">
            <div class="card-header">
              <h3>All Tags</h3>
              <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Editor/Tag/Add" role="button"><span class="las la-plus">
                Add Tag
              </span></a>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table width="100%">
                  <thead>
                  <tr>
                    <td>Tag ID</td>
                    <td>Tag Value</td>
                    <td>&nbsp</td>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${tags}" var="c">
                    <tr>
                      <td>${c.tag_id}</td>
                      <td>${c.value}</td>
                      <td>
                        &nbsp
                      </td>
                    </tr>
                  </c:forEach>

                  </tbody>
                </table>
              </div>
            </div>

          </div>

        </div>
      </div>

      <div class="recent-grid">
        <div class="projects">
          <div class="card">
            <div class="card-header">
              <h3>Tag in article</h3>

            </div>
            <c:choose>
            <c:when test="${ltag.size() == 0}">
              <div class="card-body">
                <p class="card-text">Không có dữ liệu.</p>
              </div>
            </c:when>
            <c:otherwise>
            <div class="card-body">
              <div class="table-responsive">
                <table width="100%">
                  <thead>
                  <tr>
                    <td>ID</td>
                    <td>Tag ID</td>
                    <td>Article ID</td>
                    <td>Delete</td>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${ltag}" var="c">
                    <tr>
                      <td>${c.tag_articles_id}</td>
                      <td>${c.tagsArti_id}</td>
                      <td>${c.articlesTag_id}</td>
                      <td>
                        <a href="${pageContext.request.contextPath}/Editor/Tag/Delete?TagID=${c.tag_articles_id}" class="btn btn-outline-dark"><i class="las la-trash"></i></a>
                      </td>
                    </tr>
                  </c:forEach>

                  </tbody>
                </table>
              </div>
            </div>
            </c:otherwise>
            </c:choose>
          </div>

        </div>
      </div>
    </main>
  </jsp:body>
</t:main_edit>