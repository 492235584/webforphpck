<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/webforphpck/resources/js/jquery2.0.0.min.js"></script>
<link href="/webforphpck/resources/css/bootstrap.min.css" rel="stylesheet">
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
		<div class ="row">
		您好，<%=session.getAttribute("name")%>
		<button id="checkoutbutton" type="button" class="btn btn-danger">注销</button>
		</div>
		<% 
			}else{
		%>		
		<h4>游客请先登入</h4><button id="loginbutton" type="button" class="btn btn-primary">登入</button>
		<%
			}
		%>
	</div>	
	<!-- Large modal -->

	<div class="row-fluid">		
			<div class="col-md-8" >
				<button id="txtdownloadbutton" type="button" class="btn btn-primary">下载选中</button>
				<table class="table">
			        <thead>
			          <tr>
			            <th>选择</th>
			            <th>文件名</th>
			            <th>创建时间</th>
			          </tr>
			        </thead>
			        <tbody>				
						<c:forEach items="${list }" var ="his" varStatus="status">
						<tr>
							<th><input type="checkbox" class="checkbox" /><p hidden="true">${his.path}</p></th>
				            <th><a href="">${his.name}</a></th>
				            <th>${his.createtime}</th>
						</tr>	            
						</c:forEach>
			        </tbody>
			    </table>
				<nav>
				  <ul class="pagination">
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <%
				    
				    	for(int i = 0; i < ((Integer)request.getAttribute("count")); i++){
				    		int pagenum = 0;
					    	if(i % 5 == 0){
					    		pagenum = (i / 5) + 1;
								String html = "<li><a class=\"txt-php-show\" href=\"/webforphpck/check/showlist.action?pagenum="+ pagenum +"\">"+ pagenum +"</a></li>";
						    	out.write(html);
					    	}
				    	}
				    %>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
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
        uploadUrl: '/webforphpck/check/docheck.action', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['php', 'png', 'gif', 'doc', 'docx'],
        overwriteInitial: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        
	});
    
    $("#txtdownloadbutton").click(function() {
    	var data = [];
    	$(":checked").each(function(){
    	  data.push( $(this).next().text() );
    	});
    	location.href = "/webforphpck/check/download.action?checkfiles="+data;  	
    });
</script>
</html>