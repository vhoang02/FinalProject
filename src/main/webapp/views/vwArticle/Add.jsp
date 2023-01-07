<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Home</title>
<t:main>
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
                            <label for="txtPubDate">Publish Date</label>
                            <input type="text" class="form-control" id="txtPubDate" name="PubDate">
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="view">Views</label>
                            <input name="viewNum" value="0" type="text" class="form-control"
                                   id="view" autofocus placeholder="views">
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
                            <label class="form-label" for="textAreaExample">Message</label>
                        </div>
                    </div>

                    <div class="card-body">
                        <!-- form-group // -->
                        <div class="form-group">
                            <label for="catID" class="col-sm-3 control-label">Category</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="catID" id="catID">
                                    <option value="${oldEditor.user_id}">${oldEditor.name}</option>
                                    <c:forEach items="${listE}" var="o">
                                        <option value="${o.user_id}">${o.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <!-- form-group // -->
                        <div class="form-group">
                            <label for="catID" class="col-sm-3 control-label">Premium</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="catID" id="catID">
                                    <option value="${oldEditor.user_id}">${oldEditor.name}</option>
                                    <c:forEach items="${listE}" var="o">
                                        <option value="0">false</option>
                                        <option value="1">true</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <!-- form-group // -->
                        <div class="form-group">
                            <label for="wID" class="col-sm-3 control-label">Writer</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="wID" id="wID">
                                    <option value="${oldEditor.user_id}">${oldEditor.name}</option>
                                    <c:forEach items="${editor}" var="o">
                                        <option value="${o.user_id}">${o.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="view">Status</label>
                            <input name="viewNum" value="0" type="text" class="form-control"
                                   id="view" autofocus placeholder="views">
                        </div>
                    </div>

                    <div class="card-footer text-muted">
                        <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Category"
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
</t:main>