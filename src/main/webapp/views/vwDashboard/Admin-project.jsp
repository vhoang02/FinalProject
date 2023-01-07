<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>
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
                            <span>Draft Article</span>
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
                            <span>Public Article</span>
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
                            <span>Premium Public Articles</span>
                        </div>
                        <div>
                            <span class="las la-clipboard-list"></span>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-singles">
                        <div>
                            <h1>${countDraftPre}</h1>
                            <span>Premium Draft Articles</span>
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
                                        <td>Article ID</td>
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
                                                <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Project/Detail?id=${p.articles_id}" role="button">
                                                    <i class="las la-edit"></i>
                                                </a>
                                                <a href="${pageContext.request.contextPath}/Admin/Project/Delete?id=${p.articles_id}" class="btn btn-outline-dark"><i class="las la-trash"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>

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