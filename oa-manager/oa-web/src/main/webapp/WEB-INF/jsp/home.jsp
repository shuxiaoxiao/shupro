<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>首页</title>
  </head>
  
  <body>
  	<%-- split:true,可缩动	collapsed:true,在初始化的时候折叠面板
  	iconCls:'icon-ok',添加图标
  	 --%>
    <div class="easyui-layout"  data-options="fit:true">
		<div data-options="region:'north'" style="height:50px">
			logo
			<div class="text-right">
				<a href="javascript:void(0);" class="easyui-menubutton" data-options="iconCls:'icon-ok',menu:'#menu-theme' " >更换皮肤</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" onclick="logout()" data-options="iconCls:'icon-clear' " >安全退出</a>
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
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="权限管理" style="padding:10px;" >
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="员工管理" fullTitle="权限管理 --员工管理" url="${path }/sysUser/init">员工管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="组织结构管理" fullTitle="权限管理 --组织结构管理" url="${path }/sysDept/init">组织结构管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="资源菜单管理" fullTitle="权限管理 --资源菜单管理" url="${path }/sysMenu/init">资源菜单管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="角色管理" fullTitle="权限管理 --角色管理" url="${path }/sysRole/init">角色管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="字典管理" fullTitle="权限管理 --字典管理" url="${path }/sysDictionary/init">字典管理</a>
					</p>
				</div>
				
				<div title="demo示例" style="padding:10px" data-options="selected:true">
					<%-- <iframe frameborder=0 style=width:100%;height:100% src='${path }/leftDemo' ></iframe> --%>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="LinkButton（按钮）" fullTitle="demo示例-按钮" url="${path }/initLinkButton">按钮</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="SwitchButton（开关按钮）" fullTitle="demo示例-开关按钮" url="${path }/initSwitchButton">开关按钮</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Panel（面板）" fullTitle="demo示例-面板" url="${path }/initPanel">面板</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="Panel-js（面板）" fullTitle="demo示例-面板-js" url="${path }/initPanel-js">面板-js</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Messager（消息窗口）" fullTitle="demo示例-消息窗口" url="${path }/initMessager">消息窗口</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Window（窗口）" fullTitle="demo示例-窗口" url="${path }/initWindow">窗口</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="Window-Style（窗口）" fullTitle="demo示例-窗口-Style" url="${path }/initWindow-style">窗口-Style</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Dialog（对话框窗口）" fullTitle="demo示例-对话框窗口" url="${path }/initDialog">对话框窗口</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="Dialog-js（对话框窗口）" fullTitle="demo示例-对话框窗口-js" url="${path }/initDialog-js">对话框窗口-js</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Dialog-form（表单）" fullTitle="demo示例-表单" url="${path }/initForm">表单</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="form-valide（表单验证）" fullTitle="demo示例-表单验证" url="${path }/initForm-valide">表单验证</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="form-file（件上传、下载）" fullTitle="demo示例-文件上传、下载" url="${path }/initForm-file">文件上传、下载</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="ComboBox（下拉列表框）" fullTitle="demo示例-下拉列表框" url="${path }/initComboBox">下拉列表框</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="ComboBox-js（下拉列表框）" fullTitle="demo示例-下拉列表框-js" url="${path }/initComboBox-js">下拉列表框-js</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="ComboBox-cascade（下拉列表框 级联）" fullTitle="demo示例-下拉列表框 级联" url="${path }/initComboBox-cascade">下拉列表框 级联</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="ComboGrid（数据表格下拉框）" fullTitle="demo示例-数据表格下拉框" url="${path }/initCombogrid">数据表格下拉框</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="ComboTree（树形下拉框）" fullTitle="demo示例-树形下拉框" url="${path }/initCombotree">树形下拉框</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="DataGrid（数据表格）" fullTitle="demo示例-数据表格" url="${path }/initGrid">数据表格</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="DataGrid-js（数据表格）" fullTitle="demo示例-数据表格-js" url="${path }/initGrid-js">数据表格-js</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Tree（树）" fullTitle="demo示例-树" url="${path }/initTree">树</a>
						<!--&nbsp;|&nbsp;--> |
						<a href="#" title="Tree-js（树）" fullTitle="demo示例-树-js" url="${path }/initTree-js">树-js</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="treeGrid（树形表格）" fullTitle="demo示例-树形表格" url="${path }/initTreegrid">树形表格</a>
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
	
	<script type="text/javascript">
		$(function(){
			var $menu = $('a[url]');
			var $mainTab = $('#mainTab');
			var $index_tabsMenu = $('#index_tabsMenu');
			
			/** 主tabs */
			$mainTab.tabs({
				fit : true,
				pill : true,//选中时是气泡模式
				onContextMenu : function(e, title) {
					e.preventDefault();
					$index_tabsMenu.menu('show', {
						left : e.pageX,
						top : e.pageY
					}).data('tabTitle', title);
				},
				//选中事件
				onSelect : function(title,index){
					/* console.log(title+','+index);
					console.log($menu.eq(index));
					console.log($menu.length); */
					//var fullTitle = '欢迎页面';
					if(index != 0){
						fullTitle = $menu.eq(index).attr('fullTitle');
						//console.log(fullTitle);
						changeTitle(fullTitle);
					}
				}
			});
			
			/** 左侧菜单点 击生成tabs */
			$menu.click(function(){
				var src = $(this).attr('url');
				var title = $(this).html();
				var fullTitle =  $(this).attr('fullTitle');
				
				if($mainTab.tabs('exists' ,title)){
					$mainTab.tabs('select',title);
				} else {
					$mainTab.tabs('add',{
					    title:title,
					    content:'<iframe frameborder=0 style="width:100%;height:99%" src='+ src +' ></iframe>',   
					    closable:true
					});
				}
				changeTitle(fullTitle);
			});
			
			/** 主tabs上的右键菜单 */
			$index_tabsMenu.menu({
				onClick : function(item) {
					var curTabTitle = $(this).data('tabTitle');
					var type = $(item.target).attr('title');

					if (type === 'refresh') {
						$mainTab.tabs('getTab', curTabTitle).panel('refresh');
						return;
					}

					if (type === 'close') {
						var t = $mainTab.tabs('getTab', curTabTitle);
						if (t.panel('options').closable) {
							$mainTab.tabs('close', curTabTitle);
						}
						return;
					}

					if(type === 'closeRightAll') {
			             var $tabs = $(".tabs li");  
			             for(var i = $tabs.length - 1; i >= 0; i--) {  
			                //获取所有可关闭的选项卡  
			                var tabTitle = $(".tabs-closable", $tabs[i]).text();
			                //从右往左，相等了就停止
			                if(tabTitle != curTabTitle) {  
			                	$mainTab.tabs("close", tabTitle);  
			                } else {  
			                    break;  
			                }
			             }
			        }
			          
			        if(type === 'closeLeftAll') {  
			             var $tabs = $(".tabs li");  
			             for(var i = 0; i < $tabs.length; i++) {  
			                //获取所有可关闭的选项卡  
			                var tabTitle = $(".tabs-closable", $tabs[i]).text();
			              	//从左往右，相等了就停止
			                if(tabTitle != curTabTitle) {  
			                	$mainTab.tabs("close", tabTitle);  
			                } else {  
			                    break;  
			                }  
			             }  
			        }  
			          
			        if(type === 'closeOther') {  
			             var $tabs = $(".tabs li");  
			             for(var i = 0; i < $tabs.length; i++) {  
			                //获取所有可关闭的选项卡  
			                var tabTitle = $(".tabs-closable", $tabs[i]).text();
			                if(tabTitle != curTabTitle) {
			                	$mainTab.tabs("close", tabTitle);  
			                }
			             }  
			        }  
			          
			        if(type === 'closeAll') {  
			             var $tabs = $(".tabs li");  
			             for(var i = 0; i < $tabs.length; i++) {  
			                //获取所有可关闭的选项卡  
			                var tabTitle = $(".tabs-closable", $tabs[i]).text();
		                	$mainTab.tabs("close", tabTitle);  
			             }  
			        }  

					/* var allTabs = $mainTab.tabs('tabs');
					var closeTabsTitle = [];

					$.each(allTabs, function() {
						var opt = $(this).panel('options');
						if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
							closeTabsTitle.push(opt.title);
						} else if (opt.closable && type === 'closeAll') {
							closeTabsTitle.push(opt.title);
						}
					});

					for ( var i = 0; i < closeTabsTitle.length; i++) {
						$mainTab.tabs('close', closeTabsTitle[i]);
					} */
				}
			});
			
		});
		
		//更改centerPanel的title
		function changeTitle(newTitle){
			$('#centerPanel').panel('setTitle',newTitle);
		}
		
		function logout(){
			$.messager.confirm('提示','确定要退出吗?',function(r){
	        	if(r){
		        	$.messager.progress({
			                title:'请稍后',
			                msg:'正在退出...'
			            });
		        	$.post('${path }/logout', function(result) {
		        			console.log(result);
		                    if(result.code == 200){
		                    	$.messager.progress('close');
		                        window.location.href = result.message;
		                    }
		                }, 'json');
	        	}
				
			});
		}
		
		//换肤
		//changeTheme = function(themeName) {
		 function changeTheme(themeName) {
			//获得<link id="easyuiTheme" ，，， />并对其进行修改
			var $easyuiTheme = $('#easyuiTheme');
			var url = $easyuiTheme.attr('href');
			var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
			$easyuiTheme.attr('href', href);
		
			//通过tabs引入目标页面的方式是：content:iframe，需要添加该部分
			var $iframe = $('iframe');
			if ($iframe.length > 0) {
				for ( var i = 0; i < $iframe.length; i++) {
					var ifr = $iframe[i];
					//外层页调用里层页的变量
					$(ifr).contents().find('#easyuiTheme').attr('href', href);
				}
			}
			
			//easyuiThemeName 保存7天
			$.cookie('easyuiThemeName', themeName, {
				expires : 7
			});
		}
		
		
	</script>
  </body>
</html>
