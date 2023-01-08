<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:main_dash>

    <jsp:attribute name="js">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"
        integrity="sha512-AIOTidJAcHBH2G/oZv9viEGXRqDNmfdPVPYOYKGy3fti0xIplnlgMHUGfuNRzC6FkzIo0iIxgFnr9RikFxK+sw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    $('#txtIssue').datetimepicker({
        format: 'd/m/Y',
        timepicker: false,
        mask: true
    });

    $('#txtDob').datetimepicker({
        format: 'd/m/Y',
        timepicker: false,
        mask: true
    });


</script>
  </jsp:attribute>
    <jsp:body>
        <main>
            <form method="post">
                <div class="card">
                    <h5 class="card-header">New User</h5>
                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtUser">Username</label>
                            <input name="txtUser" type="text" class="form-control" id="txtUser" autofocus
                                   placeholder="User">
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtPass">Password</label>
                            <input name="txtPass" type="text" class="form-control" id="txtPass" autofocus
                                   placeholder="Pass">
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtName">Name</label>
                            <input name="txtName" type="text" class="form-control" id="txtName" autofocus
                                   placeholder="Real name">
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <div class="form-group">
                                <label for="txtIssue">Issue at</label>
                                <input type="text" class="form-control" id="txtIssue" name="txtIssue">
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtExp">Expiration</label>
                            <input name="txtExp" type="text" class="form-control" id="txtExp" autofocus
                                   placeholder="Number of Days remaining">
                        </div>
                    </div>

                    <div class="card-body">
                        <!-- form-group // -->
                        <div class="form-group">
                            <label for="txtRole" class="col-sm-3 control-label">Role</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="txtRole" id="txtRole">
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
                            <input name="txtSec" type="text" class="form-control" id="txtSec" autofocus
                                   placeholder="2nd name">
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <div class="form-group">
                                <label for="txtDob">Day of birth</label>
                                <input type="text" class="form-control" id="txtDob" name="txtDob">
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="txtEmail">Email</label>
                            <input name="txtEmail" type="text" class="form-control" id="txtEmail" autofocus
                                   placeholder="Email">
                        </div>
                    </div>


                    <div class="card-footer text-muted">
                        <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Admin/Account"
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
</t:main_dash>