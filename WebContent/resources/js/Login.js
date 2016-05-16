window.onload = function() {
		var registerFrom = $("#resgiterform");
		var register = $("#register");
        var username = $("#username");
        var username_haserror = $(".has-error");
        var help_block = $(".help-block");
        var patt1 = /^(\w+)$/i;
        var submit = document.getElementById("submit");
        var visitor = $("#visitor");
        var registration = $("#registration");
        var have_account = $("#have_account");
        //�ο͵�¼
        visitor.click(function(){
            window.location = "Onepiece.html";
        });

        //��¼��֤
        submit.onclick = function(){
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var xhr = createXHR();
            xhr.onreadystatechange = function(){
                if(xhr.readyState==4){
                    if(xhr.status==200){
                        var getvalue = xhr.responseText;
                        if(getvalue == "1"){
                            location.href = "/webforphpck/loginshow.action";
                        }else{
                            alert("Password error!");
                        }
                    }
                }
            };
            xhr.open("post","/webforphpck/login.action?time="+new Date().getTime());
            xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
            xhr.send("name="+username+"&password="+password);
        };

        //�����Ч��
        username.attr("class","required form-control");
        username.bind("change keyup",function(){
            if(!patt1.test($(this).val())){
                username.attr("class","has-error required form-control");
            }else{
                username.attr("class","required form-control");
            }
            if($(this).val() == ""){
                help_block.css("display","block");
            }else{
                help_block.css("display","none");
            }
        });

        //�л�ע��
        registration.click(function(){
            $(".lcb-login-box-login").css("display","none");
            $(".lcb-login-box-registration").css("display","block");
        });
        have_account.click(function(){
            $(".lcb-login-box-login").css("display","block");
            $(".lcb-login-box-registration").css("display","none");
           /* $(".form-reg").val("");*/
        });
        	register.click(function register(){
        	var name = $("#regname").val();
        	var password = $("#regpassword").val();
        	var confirmpassword = $("#confirmpassword").val();
        	//参数校验
        	if(password != confirmpassword){
        		alert("两次密码不一致");
        	}else{
        		registerFrom.submit();
        	}
        });
    };



//����ajax����
function createXHR(){
    var xhr = null;
    try{
        xhr = new ActiveXObject("microsoft.xmlhttp");
    }catch(e){
        try{
            xhr = new XMLHttpRequest();
        }catch(e){
            window.alert("ajax in login.js error");
        }
    }
    return xhr;
}