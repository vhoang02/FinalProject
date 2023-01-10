<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Writer</title>
<t:main_writer>

    <jsp:body>
        <main>
            <form method="post">
                <div class="card">
                    <h5 class="card-header">New Article</h5>
                    <div class="card-body">
                        <div class="form-group">
                            <label for="tit">Title</label>
                            <input name="tit" type="text" class="form-control" id="tit" autofocus
                                   placeholder="Title of Article">
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="abstracts">Abstract</label>
                            <input name="abstr" type="text" class="form-control" id="abstracts" autofocus
                                   placeholder="Title of Article">
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <textarea name="cont" class="form-control" id="textAreaExample" rows="autofocus"></textarea>
                            <label class="form-label" for="textAreaExample">Content</label>
                        </div>
                    </div>

                    <div class="card-body">
                        <!-- form-group // -->
                        <div class="form-group">
                            <label for="catID" class="col-sm-3 control-label">Category</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="catID" id="catID">
                                    <c:forEach items="${category}" var="o">
                                        <option value="${o.cat_id}">${o.cat_name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <!-- form-group // -->
                        <div class="form-group">
                            <label for="pre" class="col-sm-3 control-label">Premium?</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="pre" id="pre">
                                    <option value="0">Standard</option>
                                    <option value="1">Premium</option>
                                </select>
                            </div>
                        </div>
                    </div>


                <div class="card-body">
                    <!-- form-group // -->
                    <div class="form-group">
                        <div>
                            <label for="txtTag">Tags</label>
                            <select id="txtTag" name="value" class="form-control " multiple="multiple">
                                <c:forEach items="${tags}" var="c">
                                    <option>${c.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>


                <div class="card-body">
                    <div class="form-group">
                        <label for="view">Status</label>
                        <input name="viewNum" value="100002" type="text" class="form-control"
                               id="view" autofocus readonly>
                    </div>
                </div>

                <div class="card-footer text-muted">
                    <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Writer/Project?wId=${authUser.user_id}"
                       role="button">
                        <i class="fa fa-backward" aria-hidden="true"></i>
                        Back
                    </a>
                    <button type="submit" class="btn btn-outline-dark">
                        <i class="fa fa-check" aria-hidden="true"></i>
                        Save
                    </button>
                </div>
                </div>
            </form>
        </main>
    </jsp:body>
</t:main_writer>