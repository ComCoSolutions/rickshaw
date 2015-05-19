$(function () {
    $("#submit").click(function () {
        var $loginID = $("#loginID");
        var $password = $("#password").val().length;

        if (validateLoginID() && validatePassword()) {
            $("#error").show().html("Thank you").removeClass("alert-danger").addClass("alert-success");
            return true;
        } else {
            return false;
        }

        function validateLoginID() {
            if ($loginID == "") {
                $("#error").show().append("Login ID cannot be blank<br>").addClass("alert-danger animated bounceInDown");
                return false;
            } else {
                return true;
            }
        }

        function validatePassword() {
            if ($password < 6 || $password > 8) {
                $("#error").show().append("Please check password length<br>").addClass("alert-danger animated bounceInDown");
                return false;
            } else {
                return true;
            }
        }

    });
});
