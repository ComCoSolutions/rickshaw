<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'animate.css')}">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-4">
                <g:form name="loginForm" action="login" id="loginForm">
                    <fieldset>
                        <legend>Login Page</legend>
                        <div class="form-group">
                            <label for="loginID">Login ID:</label>
                            <g:textField name="loginID" id="loginID" class="form-control" placeholder="someone@somewhere.com"/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <g:passwordField name="password" id="password" class="form-control" />
                        </div>
                        <g:submitButton name="login" value="Login" class="btn btn-primary" id="submit"/>
                    </fieldset>
                </g:form>
                <div id="error" class="alert"></div>
            </div>
        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <g:javascript src="script.js" />
</body>
</html>
