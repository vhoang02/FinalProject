<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>

    <jsp:body>
        <main>
            <form method="post">
                <div class="card">
                    <h5 class="card-header">New Category</h5>
                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtCatName">Category</label>
                            <input name="CatName" type="text" class="form-control" id="txtCatName" autofocus
                                   placeholder="Lĩnh vực">
                        </div>
                    </div>
                    <div class="card-body">
                        <!-- form-group // -->
                        <div class="form-group">
                            <label for="parID" class="col-sm-3 control-label">Editor</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="parID" id="parID">
                                    <c:forEach items="${editor}" var="o">
                                        <option value="${o.user_id}">${o.second_name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer text-muted">
                        <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/Admin/Category"
                           role="button">
                            <i class="fa fa-backward" aria-hidden="true"></i>
                            Back
                        </a>
                        <button type="submit" class="btn btn-primary">
                            <i class="fa fa-check" aria-hidden="true"></i>
                            Save
                        </button>
                    </div>
                </div>
            </form>
        </main>


    </jsp:body>
</t:main_dash>