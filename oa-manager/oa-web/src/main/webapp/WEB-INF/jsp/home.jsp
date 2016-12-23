<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>首页</title>
  </head>
  
  <body>
  	
    <div class="easyui-layout"  data-options="fit:true">
		<div data-options="region:'north'" style="height:50px">
			logo
			<div class="text-right">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-lock' " onclick="initResetPwd()" >更改密码</a>
				<a href="javascript:void(0);" class="easyui-menubutton" data-options="iconCls:'icon-ok',menu:'#menu-theme' " >更换皮肤</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-clear' " onclick="logout()" >安全退出</a>
			</div>
			<div id="menu-theme" style="width:120px; display: none;">
				<div onclick="changeTheme('black')">黑色</div>
				<div onclick="changeTheme('bootstrap')">bootstrap</div>
				<div onclick="changeTheme('default')">淡蓝色</div>
				<div onclick="changeTheme('gray')">灰色</div>
				<div onclick="changeTheme('material')">原料灰</div>
				<div onclick="changeTheme('metro')">地下灰</div>
				<div onclick="changeTheme('cupertino')">灰色(库比蒂诺)</div>
				<div onclick="changeTheme('dark-hive')">亮黑色</div>
				<div onclick="changeTheme('pepper-grinder')">胡椒色</div>
				<div onclick="changeTheme('sunny')">阳光色</div>
			</div>
			
		</div>
		<div data-options="region:'south'" style="height:30px;">
			copyright
		</div>
		<div data-options="region:'west',split:true,title:'West'" style="width:15%;">
			<!-- <ul id="menuTree"></ul> -->
			<%--a标签定义时 href="javascript:void(0);"会存在问题，直接跳转了，换成href="javascript:void(0);" --%>
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="权限管理" style="padding:10px;" data-options="selected:true" >
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="员工管理" fullTitle="权限管理 --员工管理" url="${path }/sysUser/init">员工管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="组织结构管理" fullTitle="权限管理 --组织结构管理" url="${path }/sysDept/init">组织结构管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="资源菜单管理" fullTitle="权限管理 --资源菜单管理" url="${path }/sysMenu/init">资源菜单管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="角色管理" fullTitle="权限管理 --角色管理" url="${path }/sysRole/init">角色管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="字典管理" fullTitle="权限管理 --字典管理" url="${path }/sysDictionary/init">字典管理</a>
					</p>
				</div>
				
				<div title="demo示例" style="padding:10px" >
					<%-- <iframe frameborder=0 style=width:100%;height:100% src='${path }/leftDemo' ></iframe> --%>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="LinkButton（按钮）" fullTitle="demo示例-按钮" url="${path }/initLinkButton">按钮</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="SwitchButton（开关按钮）" fullTitle="demo示例-开关按钮" url="${path }/initSwitchButton">开关按钮</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="Panel（面板）" fullTitle="demo示例-面板" url="${path }/initPanel">面板</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="Panel-js（面板）" fullTitle="demo示例-面板-js" url="${path }/initPanel-js">面板-js</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="Messager（消息窗口）" fullTitle="demo示例-消息窗口" url="${path }/initMessager">消息窗口</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="Window（窗口）" fullTitle="demo示例-窗口" url="${path }/initWindow">窗口</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="Window-Style（窗口）" fullTitle="demo示例-窗口-Style" url="${path }/initWindow-style">窗口-Style</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="Dialog（对话框窗口）" fullTitle="demo示例-对话框窗口" url="${path }/initDialog">对话框窗口</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="Dialog-js（对话框窗口）" fullTitle="demo示例-对话框窗口-js" url="${path }/initDialog-js">对话框窗口-js</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="Dialog-form（表单）" fullTitle="demo示例-表单" url="${path }/initForm">表单</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="form-valide（表单验证）" fullTitle="demo示例-表单验证" url="${path }/initForm-valide">表单验证</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="form-file（件上传、下载）" fullTitle="demo示例-文件上传、下载" url="${path }/initForm-file">文件上传、下载</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="ComboBox（下拉列表框）" fullTitle="demo示例-下拉列表框" url="${path }/initComboBox">下拉列表框</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="ComboBox-js（下拉列表框）" fullTitle="demo示例-下拉列表框-js" url="${path }/initComboBox-js">下拉列表框-js</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="ComboBox-cascade（下拉列表框 级联）" fullTitle="demo示例-下拉列表框 级联" url="${path }/initComboBox-cascade">下拉列表框 级联</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="ComboGrid（数据表格下拉框）" fullTitle="demo示例-数据表格下拉框" url="${path }/initCombogrid">数据表格下拉框</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="ComboTree（树形下拉框）" fullTitle="demo示例-树形下拉框" url="${path }/initCombotree">树形下拉框</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="DataGrid（数据表格）" fullTitle="demo示例-数据表格" url="${path }/initGrid">数据表格</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="DataGrid-js（数据表格）" fullTitle="demo示例-数据表格-js" url="${path }/initGrid-js">数据表格-js</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="Tree（树）" fullTitle="demo示例-树" url="${path }/initTree">树</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="javascript:void(0);" title="Tree-js（树）" fullTitle="demo示例-树-js" url="${path }/initTree-js">树-js</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="javascript:void(0);" title="treeGrid（树形表格）" fullTitle="demo示例-树形表格" url="${path }/initTreegrid">树形表格</a>
					</p>
				</div>
			</div>
		</div>
		<div data-options="region:'east',split:true,title:'East',collapsed:true " style="width:15%;">
			聊天
		</div>
		<div id="centerPanel" data-options="region:'center',title:'欢迎页面' ">
			<div id="mainTab">
	    		<div title="欢迎页面" style="padding:20px;">
	    			<%--直接将整个页面嵌入 --%>
	    			<iframe frameborder=0 style="width:100%;height:99%;" src='${path }/welcome' ></iframe>
	    		</div>
	    	</div> 
		</div>
		
		<!-- 表单(放在layout里面，放在外面会影响grid的高度) -->
		<div id="resetPwdDialog" class="easyui-dialog" style="width:450px;height:200px;" 
			data-options="closed:true, modal:true, left:300, top:150, buttons:'#dlg-buttons' ">
	    	<form id="resetPwdForm" method="post">
	    		<input id="id" name="id" type="hidden" value="${userInfo.id }">
	    		<table class="form-table">
		    		<tr>
		    			<td class="form-td-left"> 新密码:</td>
		    			<td><input class="easyui-textbox form-input" name="pwd" id="pwd"
		    				data-options="missingMessage:'请填写密码', required:true " maxlength="50" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 确认密码:</td>
		    			<%--情况特殊 validType 被拿出来了--%>
		    			<td><input class="easyui-textbox form-input" name="againPwd" 
		    				data-options="missingMessage:'请填写密码', required:true " validType="eqPwd['#pwd']" maxlength="50" />
		    			</td>
		    		</tr>
		    	</table>
	        </form>
	        <div id="dlg-buttons">
		        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveResetPwd()" style="width:90px">保存</a>
		        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#resetPwdDialog').dialog('close');" style="width:90px">取消</a>
		    </div>
	    </div>
	</div>
	
	<div id="index_tabsMenu" style="width: 120px; display: none;">
		<!-- <div title="refresh" data-options="iconCls:'transmit'">刷新</div>
		<div class="menu-sep"></div> -->
		<div title="close" data-options="iconCls:'delete'">关闭</div>
		<div title="closeLeftAll" data-options="iconCls:'delete'">关闭左边所有</div>
		<div title="closeRightAll" data-options="iconCls:'delete'">关闭右边所有</div>
		<div title="closeOther" data-options="iconCls:'delete'">关闭其他</div>
		<div title="closeAll" data-options="iconCls:'delete'">关闭所有</div>
	</div>
	
	<script type="text/javascript" src="${staticPath }/js/main.js" ></script>
  </body>
</html>
