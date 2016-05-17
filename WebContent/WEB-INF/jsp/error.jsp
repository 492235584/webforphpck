<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/webforphpck/resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	出现异常:${message}点击重新登入
	<button id="returnloign" type="button" class="btn btn-primary">点击重新登入</button>
</body>
<script type="text/javascript">
	$("#returnloign").click(function(){
		location.href("/webforphpck/login.jsp");
	});

</script>
</html>