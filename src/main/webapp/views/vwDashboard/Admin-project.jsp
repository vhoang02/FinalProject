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
                Add projects
              </span></button>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table width="100%">
                  <thead>
                  <tr>
                    <td>Project Tittle</td>
                    <td>Department</td>
                    <td>Status</td>
                    <td>Edit</td>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>UI/UX Design</td>
                    <td>UI team</td>
                    <td>
                      <span class="status purple"></span>
                      review
                    </td>
                    <td>
                      <button class="las la-edit"></button>
                      <button class="las la-trash"></button>
                    </td>
                  </tr>
                  <tr>
                    <td>Web development</td>
                    <td>Frontend</td>
                    <td>
                      <span class="status pink"></span>
                      in progess
                    </td>
                    <td>
                      <button class="las la-edit"></button>
                      <button class="las la-trash"></button>
                    </td>
                  </tr>
                  <tr>
                    <td>Web development</td>
                    <td>Backend</td>
                    <td>
                      <span class="status orange"></span>
                      pending
                    </td>
                    <td>
                      <button class="las la-edit"></button>
                      <button class="las la-trash"></button>
                    </td>
                  </tr>
                  </tbody>
                </table>
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