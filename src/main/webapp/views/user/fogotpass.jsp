<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password</title>
<%@ include file="/common/head.jsp"%>
</head>
<body>
    <%@ include file="/common/header.jsp"%>

    <div class="container-fluid tm-container-content tm-mt-60">
        <div class="container-fluid tm-mt-60">
            <div class="row tm-mb-50">
                <div class="col-lg-12 col-12 mb-5">
                    <h2 class="tm-text-primary mb-5 text-center">Login</h2>
                    <form id="login-form" action="login" method="POST"
                        class="tm-contact-form mx-auto">
                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control rounded-0"
                                placeholder="Email" required />
                        </div>
                         <!-- Changed id to "message" -->
                        <div class="form-group tm-text-right">
                            <button type="submit" id="sendButton" class="btn btn-primary">Send</button>
                        </div>
                        <h5 style="color: red;" id="message"></h5>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- container-fluid, tm-container-content -->
    <%@ include file="/common/footer.jsp"%>
</body>
<script type="text/javascript">
    $('#sendButton').click(function () {
        $('#message').text('');
        var email = $('#email').val();
        var formData = {'email': email};
        $.ajax({
            url: 'forgotPass',
            type: 'POST',
            data: formData,
            success: function(data) {
                $('#message').text('Mật khẩu đã được đặt lại, vui lòng đợi...'); // Changed id to match the id in the HTML
                setTimeout(function () {
                    window.location.href = 'http://localhost:8080/asmjava4/index';
                }, 5000); // Changed 5 * 1000 to 5000 for 5 seconds delay
            },
            error: function (xhr, status, error) {
                $('#message').text('Thông tin của bạn không đúng, vui lòng thử lại'); // Changed id to match the id in the HTML
            }
        });
    }); 
</script>

</html>
