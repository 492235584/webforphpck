<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Onepiece</title>
    <link type="text/css" rel="stylesheet" href="/webforphpck/resources/css/Login.css" />
    <script type="text/javascript" src="/webforphpck/resources/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="/webforphpck/resources/js/Login.js"></script>
</head>
<body class="lcb-login">
		<div class="lcb-login-main">
			<h1 class="lcb-login-logo">Login</h1>
			<div class="lcb-login-boxes">
				<form class="lcb-login-box lcb-login-box-login validate" action="" method="post">
					<h2 class="lcb-login-box-head">login</h2>
					<div class="form-group">
						<div class="jvFloat">
							<input class="required form-control has-error" placeholder="Username" name="name" type="text" id="username" />
							<span class="help-block" >This field is required.</span>
						</div>
					</div>
					<div class="form-group">
						<div class="jvFloat">
							<input class="required form-control" placeholder="Password" name="password" type="password" id="password" />
						</div>
					</div>
					<div class="lcb-login-box-bottom">
						<div class="links pull-left" id="registration">register</div>
						<button id="submit" class="btn-info btn btn-lg pull-right" type="button">login</button>
						<button class="btn-info btn btn-lg pull-right" type="button" id="visitor">visitor</button>
					</div>
				</form>
				<form id="resgiterform" class="lcb-login-box lcb-login-box-registration validate" action="/webforphpck/login/register.action" method="post" style="display:none;">
					<h2 class="lcb-login-box-head">register</h2>
					<div class="form-group">
						<div class="jvFloat">
							<input class="form-control" type="text" id="regname" name="name" placeholder="Username" />
						</div>
					</div>
					<div class="form-group">
						<div class="jvFloat">
							<input class="form-control" type="text" id="regpassword" name="password" placeholder="Password" />
						</div>
					</div>
					<div class="form-group">
						<div class="jvFloat">
							<input class="form-control" type="text" id="confirmpassword" placeholder="Confirm Password" />
						</div>
					</div>
					<div class="lcb-login-box-bottom">
						<div class="links pull-left" id="have_account">existing account</div>
						<button class="btn-info btn btn-lg pull-right" id="register" type="button" >register</button>
					</div>
				</form>
			</div>
		</div>
</body>
</html>