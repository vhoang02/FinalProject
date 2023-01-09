<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>
    <jsp:body>
        <main>
            <form method="post">
                <div class="card">
                    <h5 class="card-header">Edit User</h5>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtID">User ID</label>
                            <input name="txtID" value="${user.user_id}" type="text" class="form-control" id="txtID" autofocus readonly>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtUser">Username</label>
                            <input name="txtUser" value="${user.username}" type="text" class="form-control" id="txtUser" autofocus readonly>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtPass">Password</label>
                            <input name="txtPass" type="text" class="form-control" id="txtPass" autofocus
                                   placeholder="New Password">
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtName">Name</label>
                            <input name="txtName" value="${user.name}" type="text" class="form-control" id="txtName" autofocus>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <div class="form-group">
                                <label for="txtIssue">Issue at</label>
                                <input type="text" value="${begin}" class="form-control" id="txtIssue" name="txtIssue" readonly>
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtExp">Expiration</label>
                            <input name="txtExp" value="${user.expiration}" type="text" class="form-control" id="txtExp" autofocus>
                        </div>
                    </div>

                    <div class="card-body">
                        <!-- form-group // -->
                        <div class="form-group">
                            <label for="txtRole">Role</label>
                            <div>
                                <select class="form-control" name="txtRole" id="txtRole">
                                    <option value="${user.role}">${rol}</option>
                                    <option value="${0}">Admin</option>
                                    <option value="${1}">Editor</option>
                                    <option value="${2}">Writer</option>
                                    <option value="${3}">Reader</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtSec">Second name</label>
                            <input name="txtSec" value="${user.second_name}" type="text" class="form-control" id="txtSec" autofocus>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <div class="form-group">
                                <label for="txtDob">Day of birth</label>
                                <input type="text" value="${birthD}" class="form-control" id="txtDob" name="txtDob" readonly>
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtEmail">Email</label>
                            <input name="txtEmail" value="${user.email}" type="text" class="form-control" id="txtEmail" autofocus
                                   placeholder="Email">
                        </div>
                    </div>


                    <div class="card-footer text-muted">
                        <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Account"
                           role="button">
                            <i class="fa fa-backward" aria-hidden="true"></i>
                            Back
                        </a>
                        <button type="submit" class="btn btn-outline-dark" formaction="${pageContext.request.contextPath}/Admin/Account/Update">
                            <i class="fa fa-check" aria-hidden="true"></i>
                            Save
                        </button>
                    </div>
                </div>
            </form>
        </main>


    </jsp:body>
</t:main_dash>