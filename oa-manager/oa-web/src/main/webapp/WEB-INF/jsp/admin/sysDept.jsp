<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
	<title>组织结构管理</title>
	<%@ include file="/commons/basejs.jsp" %>
  </head>
  
  <body>
    <div class="easyui-layout" data-options="fit:'true' ">
		<div data-options="region:'north',split:true " style="height:40px;padding: 3px;">
			<!--部门编号：<input type="text" id="query_deptid" />&nbsp;
			-->
			部门名称：<input type="text" id="query_name" />&nbsp;
			<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search' " onclick="searchData();">查询</a>
		</div>
		<div data-options="region:'center' ">
			<table id="sysDeptGrid"></table>
		</div>
		
		<!-- 表单(放在layout里面，放在外面会影响grid的高度) -->
		<div id="dlg" class="easyui-dialog" style="width:450px;height:360px;" 
			data-options="closed:true, modal:true, buttons:'#dlg-buttons' ">
	    	<form id="fm" method="post" novalidate>
	    		<input id="id" name="id" type="hidden">
	    		<table class="form-table">
		    		<tr>
		    			<td class="form-td-left"> 部门id:</td>
		    			<td><input class="easyui-textbox form-input" name="deptid" 
		    				data-options="missingMessage: '请填写部门id' " maxlength="50" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 部门名称:</td>
		    			<td><input class="easyui-textbox form-input" name="name" 
		    				data-options="missingMessage: '请填写部门名称' " maxlength="50" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 父id:</td>
		    			<td><input class="easyui-textbox form-input" name="pid" 
		    				data-options="missingMessage:'请填写父id' " maxlength="50" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 层级:</td>
		    			<td><input class="easyui-textbox form-input" name="levels" 
		    				data-options="missingMessage:'请填写层级' " maxlength="2" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 创建时间:</td>
		    			<td><input class="easyui-datebox form-input" name="createtime" 
		    				data-options="missingMessage:'请填写创建时间' " maxlength="" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 描述:</td>
		    			<td><input class="easyui-textbox form-input" name="description" 
		    				data-options="missingMessage:'请填写描述' " maxlength="3000" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 排序号:</td>
		    			<td><input class="easyui-numberbox form-input" name="sotid" 
		    				data-options="missingMessage:'请填写排序号' " maxlength="" />
		    			</td>
		    		</tr>
		    		<!-- <tr>
		    			<td class="form-td-left"> 节点状态:</td>
		    			<td><input class="easyui-textbox form-input" name="state" 
		    				data-options="" maxlength="10" missingMessage="请填写节点状态，'open' 或 'closed'" />
		    			</td>
		    		</tr> -->
		    		<tr>
		    			<td class="form-td-left"> 状态:</td>
		    			<td><input class="easyui-textbox form-input" name="isenable" 
		    				data-options="missingMessage:'请填写状态' " maxlength="1" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 部门类型:</td>
		    			<td><input class="easyui-textbox form-input" name="type" 
		    				data-options="missingMessage:'请填写部门类型' " maxlength="20" />
		    			</td>
		    		</tr>
		    	</table>
	        </form>
	        <div id="dlg-buttons">
		        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="save()" style="width:90px">保存</a>
		        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#dlg').dialog('close');" style="width:90px">取消</a>
		    </div>
	    </div>
	</div>
	
<script type="text/javascript">

	var $grid = $('#sysDeptGrid');
	/**
	 * 查询用户
	 */
	function searchData(){

		$grid.datagrid('load',{
			//'deptid': $('#query_deptid').val(),
			'name': $('#query_name').val()
		});
	}
	
	$(function(){
		
		$grid.datagrid({
			idField:'id' ,		//只要创建数据表格 就必须要加 ifField
			fit:true ,//填充父容器
			fitColumns:true ,  //自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
			striped: true , //隔行变色特性 
			loadMsg: '数据正在加载,请耐心的等待...' ,
			rownumbers:true ,
			pagination: true , //启用分页
			//singleSelect:true , //单选模式 
			url:'${path}/sysDept/list', 
			/* 返回Result类型时
			loadFilter: function(result){
				//重新过滤数据
				if(result.code == 200){
					return result.data;
				}
			}, */
		    columns:[[
		        {field:'ck', width:50, checkbox: true},
				{field:'deptid',title:'部门id'},    
				{field:'name',title:'部门名称'},    
				{field:'pid',title:'父id'},    
				{field:'levels',title:'层级'},    
				{field:'createtime',title:'创建时间'},    
				{field:'description',title:'描述'},    
				{field:'sotid',title:'排序号'},    
				{field:'state',title:'节点状态'},    
				{field:'isenable',title:'状态'},    
				{field:'type',title:'部门类型'}
		    ]] ,
		    toolbar:[{
	    		text:'新 增' ,
				iconCls:'icon-add' , 
				handler:function(){
	    			initAdd();
				}
		    },{
		    	text:'修 改' ,
				iconCls:'icon-edit' , 
				handler:function(){
					initEdit();
				}
		     },{
		    	text:'删 除' ,
				iconCls:'icon-remove' , 
				handler:function(){
		    		del();
				}
		    }]
		});
	});
	
	var url='';//表单提交url
	
	/**增加*/
	function initAdd(){
		//清空表单
		$('#fm').form('clear');
		//如果上面的表单清空不好用,则换成jq的表单清空
		//$('#fm').get(0).reset();
		
		//显示
		$('#dlg').dialog('open').dialog('setTitle','新增表单');
	    url='save';
	}
	
	/**修改*/
	function initEdit(){
		var row = $grid.datagrid('getSelected');
	    if (row){
	        $('#dlg').dialog('open').dialog('setTitle','修改表单');
	        //数据回显
	        $('#fm').form('load',row);
	        url='update';
	    }else{
	    	$.messager.alert('警告','请选择一行操作数据，且只能选择一行！');    
	    }
	}
	
	/**表单保存(含新增和修改)*/
	function save(){
		$('#fm').form('submit',{
	        url: '${path}/sysDept/' + url,
	        onSubmit: function(param){
	       		var isValid = $(this).form('validate');
				if(isValid){
					$.messager.progress({
							title:'请稍后',
			                msg:'数据保存中...'
						});
				 }
	            return isValid;
	        },
	        success: function(result){
	       	 	$.messager.progress('close');
	        	//var result = JSON.parse(result);//Json对象
	        	var result = $.parseJSON(result);//jq对象
	            if (result.code == 200){
		        	$('#dlg').dialog('close');
		        	$grid.datagrid('reload');
	            }else{
	            	$.messager.alert('警告',result.message);
	            }
	        }
		 });
	}
	
	/**删除*/
	function del(){
		//此处是getSelections(返回所有被选中的行)
		var row = $grid.datagrid('getSelections');
		
		if(row.length <=0){
			$.messager.show({
				title:'提示信息!',
				msg:'至少选择一行记录进行删除!'
			});
		} else {
	        $.messager.confirm('提示','确定要删除此信息?',function(r){
	        	if(r){
		        	$.messager.progress({
			                title:'请稍后',
			                msg:'正在删除...'
			            });
	        		var ids = '';
	        		for(var i = 0; i < row.length; i++){
						ids += row[i].id + ',' ;
					}
					ids = ids.substring(0 , ids.length-1);
		            $.ajax({
		            	url:'${path}/sysDept/delete',
		            	type: 'post',
		            	data: {"ids" : ids},
		            	dataType:"json",
		        		success:function(result){
		        			$.messager.progress('close');
		        			if (result.code == 200){
		                    	$grid.datagrid('reload');
		                    	//清空idField(避免删除后在进行修改操作的bug)
								$grid.datagrid('unselectAll');
		                    }else{
		                    	$.messager.alert('警告',result.message);
		                    }
		        		},
		        		error:function(request,msg){
		        			$.messager.progress('close');
		        			$.messager.alert('警告','删除失败' + msg);
		        		}
		            });
	        	}
	        });
		}
	}
	
</script>

  </body>
</html>
