<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>

    <jsp:body>
        <main>
            <form method="post">
                <div class="card">
                    <h5 class="card-header">Edit Category</h5>
                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtCatID">#</label>
                            <input name="CatID" value="${category.cat_id}" type="text" class="form-control"
                                   id="txtCatID" readonly>
                        </div>
                    </div>
                        <div class="form-group">
                        <div class="form-group">
                            <label for="txtCatName">Category</label>
                            <input name="CatName" value="${category.cat_name}" type="text" class="form-control"
                                   id="txtCatName" autofocus placeholder="Laptop">
                        </div>
                    </div>
                    <div class="card-body">
                        <!-- form-group // -->
                        <div class="form-group">
                            <label for="parID" class="col-sm-3 control-label">Editor</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="parID" id="parID">
                                    <option value="${oldEditor.user_id}">${oldEditor.name}</option>
                                    <c:forEach items="${listE}" var="o">
                                        <option value="${o.user_id}">${o.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer text-muted">
                        <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Category"
                           role="button">
                            Back
                        </a>
                        <button type="submit" class="btn btn-outline-dark"
                                formaction="${pageContext.request.contextPath}/Admin/Category/Update">
                            Save
                        </button>
                    </div>
                </div>
            </form>
        </main>


    </jsp:body>
</t:main_dash>