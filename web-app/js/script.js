$(function () {
    $("#submit").click(function () {
        var $loginID = $("#loginID").val();
        var $password = $("#password").val().length;
        var $error = $("#error");
        var errorMessage = "";

        if ($loginID == "") {
            errorMessage += "<p>Login ID cannot be blank</p>";
            console.log(errorMessage);
        }

        if ($password < 6 || $password > 8) {
            errorMessage += "<p>Please check the password length</p>";
            console.log(errorMessage);
        }

        if (errorMessage == "") {
            $error.show().html("<p>Thank you!</p>").removeClass("alert-danger").addClass("alert-success animated bounceInUp");
            return false;
        } else {
            $error.show().html(errorMessage).addClass("alert-danger animated bounceInUp");
            return false;
        }

    });
});
