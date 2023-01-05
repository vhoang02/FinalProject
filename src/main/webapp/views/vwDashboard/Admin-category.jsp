<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>
  <jsp:body>
    <main>
      <div class="cards">
        <div class="card-singles">
          <div>
            <h1>79</h1>
            <span>Projects</span>
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
              <h3>All Projects</h3>
              <button><span class="las la-plus">
                Add Category
              </span></button>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table width="100%">
                  <thead>
                  <tr>
                    <td>Category ID</td>
                    <td>Category Name</td>
                    <td>Parent ID</td>
                    <td>Edit</td>
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
                      <button class="las la-edit"></button>
                      <button class="las la-trash"></button>
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