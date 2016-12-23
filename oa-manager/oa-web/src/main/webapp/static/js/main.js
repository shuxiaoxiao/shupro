var rootPath = $('#rootPath').attr('href');

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
//				    href: src,
//				    bodyCls:"content",
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
	        	$.post(rootPath + '/logout', function(result) {
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
	
	/**更改密码*/
	function initResetPwd(){
		//清空表单
		$('#resetPwdForm').form('clear');
		//如果上面的表单清空不好用,则换成jq的表单清空
		//$('#fm').get(0).reset();
		
		//显示
		$('#resetPwdDialog').dialog('open').dialog('setTitle','更改密码');
	    
	}
	
	function saveResetPwd(){
		$('#resetPwdForm').form('submit',{
	        url: rootPath + '/sysUser/resetPwd',
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
	        	var result = JSON.parse(result);//Json对象
	        	//var result = $.parseJSON(result);//jq对象
	       	 	$.messager.progress('close');
	       	 	if (result.code == 200){
		        	$('#resetPwdDialog').dialog('close');
		        	$.messager.alert('提示', result.message);
	            }else{
	            	$.messager.alert('警告',result.message);
	            }
	        }
		 });
	}

