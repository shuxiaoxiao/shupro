<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>Basic ComboBox（下拉列表框）</title>
  </head>
  
  <body>
  	 <div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert($('#language').combobox('getValue'))">GetValue</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#language').combobox('disable')">Disable</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#language').combobox('enable')">Enable</a>
	</div>
	<%--属性解释
	valueField : 值名称绑定到该下拉列表框
  	textField ：字段名称绑定到该下拉列表框
  	formatter : 渲染行
  	 --%>
  	<div style="margin:20px 0;">
  		<!-- 火狐显示有兼容问题 -->
		<input id="language" name="language" />
  	</div>
	
	<script type="text/javascript">
		//select2combo
		var $combobox = $('#language');
		$(function(){
			$combobox.combobox({
				url : '${path}/sysDictionary/select2combo/1',
				valueField: 'value',
		        textField: 'name',
		        formatter: function(row){
		        	var str = '<span style="font-weight:bold">' + row.name + '</span><br/>' +
					'<span style="color:#888">' + row.descs + '</span>';
					return str;
		        }
			});
			
		});
	</script>
  </body>
</html>
