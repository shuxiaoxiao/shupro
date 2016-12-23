<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>登录页</title>
  </head>
  
  <body>
  <form method="post" id="loginForm">
		<div class="easyui-panel" title="Login to system" style="width:400px;padding:30px 70px 20px 70px">
			<div style="margin-bottom:10px;">
				<input class="easyui-textbox" name="loginName" style="width:100%;height:40px;line-height:40px;padding:12px" 
				data-options="required: true,prompt:'请输入账号',iconCls:'icon-man',iconWidth:38" />
			</div>
			<div style="margin-bottom:10px">
				<input class="easyui-textbox" type="password" name="password" style="width:100%;height:40px;padding:12px" 
				data-options="required: true,prompt:'请输入密码',iconCls:'icon-lock',iconWidth:38" />
			</div>
			<div style="margin-bottom:20px;text-align: right;">
				<input type="checkbox" name="rememberMe" checked="checked" /> 记住我
			</div>
			
			<div>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;"
					onclick="submitForm()">
					<span style="font-size:14px;">登 录</span>
				</a>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$(function(){
			var $loginForm = $('#loginForm');
			
			// 登录
            $loginForm.form({
                url:'${path }/login',
                onSubmit : function() {
                	var isValid = $(this).form('validate');
    				if(isValid){
    					$.messager.progress({
    							title:'请稍后',
    			                msg:'数据保存中...'
    						});
    				 }
    	            return isValid;
                },
                success:function(result){
                    //console.log(typeof result);
                    //console.log(result);
                	//关闭
                	$.messager.progress('close');
                    //由于返回的数据是String类型
                    result = $.parseJSON(result);
                    if (result.code == 200) {
                    	window.location.href='${path }' + result.message;
                    	
                    }else{
                         $.messager.show({
                            title:'提示',
                            msg:'<div class="light-info"><div class="light-tip icon-tip"></div><div>'+ result.message +'</div></div>',
                            showType:'show'
                        });
                    }
                }
            });
			
            //console.log('执行'+ (window.parent != window));
			//解决ifream session超时后调整登录页面的bug 【临时方案】
         	if (window.parent != window){
          		window.top.location.href = location.href;
          	}
			
		});
		
		function submitForm(){
			//$loginForm.submit();
			$('#loginForm').submit();
        }
        function clearForm(){
        	//$loginForm.form('clear');
        	$('#loginForm').form('clear');
        }
        //回车登录
        function enterlogin(){
            if (event.keyCode == 13){
                event.returnValue=false;
                event.cancel = true;
              //$loginForm.submit();
				$('#loginForm').submit();
            }
        }
		
	</script>
  </body>
</html>
