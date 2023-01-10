<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_writer>
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
              <span>Public</span>
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
              <h3>All my Articles</h3>
              <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Writer/Project/Add" role="button"><span class="las la-plus">
                Add Article
              </span></a>
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
</t:main_writer>