<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="/webforphpck/resources/css/bootstrap.min.css" rel="stylesheet">
<!--<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
-->
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
<link href="/webforphpck/resources/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
<link href="/webforphpck/resources/css/bootstrap.min.css" rel="stylesheet">
<script src="/webforphpck/resources/js/fileinput.js" type="text/javascript"></script>
<script src="/webforphpck/resources/js/fileinput_locale_zh.js" type="text/javascript"></script>

</head>
<body>

<div class="container-fluid" id="LG">

	<div class="col-md-10">
		<div class="row-fluid">
			<div class="span12">
				<ul class="breadcrumb">
					<li>
						<a href="#">主页</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">类目</a> <span class="divider">/</span>
					</li>
					<li class="active">
						主题
					</li>
				</ul>
				<h3 class="text-center">
					php代码规范检测
				</h3>
			</div>
		</div>
	</div>
	<div class="col-md-2">
		<% 
			if(session.getAttribute("name") != null ){
		%>
		<h4>您好，<%=session.getAttribute("name")%></h4>
		<% 
			}else{
		%>		
		<h4>游客请先登入</h4>
		<%
			}
		%>
	</div>	
	<!-- Large modal -->

	<div class="row-fluid">		
			<div class="col-md-8" >
				<div class="checkbox">
	  		 		<label><a href="/webforphpck/download.action">下载</a></label>
				</div>	
			<table class="table">
		        <thead>
		          <tr>
		            <th>选择</th>
		            <th>文件名</th>
		            <th>创建者</th>
		            <th>时间</th>
		          </tr>
		        </thead>
		        <tbody>
		          <tr>
		            <td><label>1.<input type="checkbox" value=""></label></td>
		            <td>showController.txt</td>
		            <td>李狗蛋</td>
		            <td>2016.5.7</td>
		          </tr>
		        </tbody>
		    </table>
			<nav>
			  <ul class="pager">
			    <li class="previous disabled"><a href="#"><span aria-hidden="true">&larr;</span> Older</a></li>
			    <li class="next"><a href="#">Newer <span aria-hidden="true">&rarr;</span></a></li>
			  </ul>
			</nav>      			
			</div>
		<div class="col-md-4">				
			<form enctype="multipart/form-data">
			
				<div class="form-group">
					<input id="file-1" name="checkfile" type="file" multiple class="file" data-min-file-count="1">
				</div>
			
			</form>
		</div>
	</div>
</div>
<!-- Large modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Large modal</button>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      ...
    </div>
  </div>
</div>

<!-- Small modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      ...
    </div>
  </div>
</div>
</body>
<script>
  	
    $("#file-1").fileinput({
		//language: 'zh',
        uploadUrl: '/webforphpck/docheck.action', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['php', 'png', 'gif', 'doc', 'docx'],
        overwriteInitial: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        
	});
   
</script>
</html>