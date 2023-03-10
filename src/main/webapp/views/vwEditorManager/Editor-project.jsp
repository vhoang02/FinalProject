<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_edit>
  <jsp:body>
    <main>
      <div class="card-group">
        <div class="card">
          <div class="card-singles">
            <div>
              <h1>${countArt}</h1>
              <span>Articles</span>
            </div>
            <div>
              <span class="las la-clipboard-list"></span>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-singles">
            <div>
              <h1>${countCat}</h1>
              <span>Category</span>
            </div>
            <div>
              <span class="las la-clipboard-list"></span>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-singles">
            <div>
              <h1>${coutDraft}</h1>
              <span>Draft</span>
            </div>
            <div>
              <span class="las la-clipboard-list"></span>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-singles">
            <div>
              <h1>${countPub}</h1>
              <span>Public </span>
            </div>
            <div>
              <span class="las la-clipboard-list"></span>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-singles">
            <div>
              <h1>${countPubPre}</h1>
              <span>Premium</span>
            </div>
            <div>
              <span class="las la-clipboard-list"></span>
            </div>
          </div>
        </div>

      </div>

      <div class="recent-grid">
        <div class="projects">
          <div class="card">
            <div class="card-header">
              <h3>All Articles</h3>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table width="100%">
                  <thead>
                  <tr>
                    <td>Article ID</td>
                    <td>Category ID</td>
                    <td>Article Tittle</td>
                    <td>Writer ID</td>
                    <td>Status</td>
                    <td>Edit</td>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${allart}" var="p">
                    <tr>
                      <td>${p.articles_id}</td>
                      <td>${p.categories_id}</td>
                      <td>${p.title}</td>
                      <td>${p.writer_id}</td>
                      <c:choose>
                        <c:when test="${p.status == 100001}">
                          <td>
                            <span class="status pink"></span>
                            Pub
                          </td>
                        </c:when>
                        <c:otherwise>
                          <td>
                            <span class="status purple"></span>
                            Dr
                          </td>
                        </c:otherwise>
                      </c:choose>
                      <td>
                        <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Editor/Project/Detail?id=${p.articles_id}&eId=${authUser.user_id}" role="button">
                          <i class="las la-info"></i>
                        </a>
                        <a href="${pageContext.request.contextPath}/Editor/Project/Delete?id=${p.articles_id}&eId=${authUser.user_id}" class="btn btn-outline-dark" role="button"><i class="las la-trash"></i></a>
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
    </main>
  </jsp:body>
</t:main_edit>