<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>
  <jsp:body>
    <main>
      <div class="cards">
        <div class="card-singles">
          <div>
            <h1>${count}</h1>
            <span>Category</span>
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
              <h3>All Category</h3>
              <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Category/Add" role="button"><span class="las la-plus">
                Add Category
              </span></a>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table width="100%">
                  <thead>
                  <tr>
                    <td>Category ID</td>
                    <td>Category Name</td>
                    <td>Parent ID</td>
                    <td>Edit|Delete</td>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${categories}" var="c">
                  <tr>
                    <td>${c.cat_id}</td>
                    <td>${c.cat_name}</td>
                    <td>
                        ${c.parent_id}
                    </td>
                    <td>
                      <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Category/Edit?id=${c.cat_id}" role="button">
                        <i class="las la-edit"></i>
                      </a>
                      <a href="${pageContext.request.contextPath}/Admin/Category/Delete?CatID=${c.cat_id}" class="btn btn-outline-dark"><i class="las la-trash"></i></a>
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
</t:main_dash>