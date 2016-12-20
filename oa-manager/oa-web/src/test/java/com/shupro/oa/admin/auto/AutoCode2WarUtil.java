package com.shupro.oa.admin.auto;

import com.shupro.core.auto.AutoCreateClassUtil;
import com.shupro.core.auto.AutoModel;

/**
 * 命名规范，数据库的字段名按照Java类的属性来命名<br>
 * 如sys_user表中userType、phoneNum
 * @author shu
 *
 */
public class AutoCode2WarUtil {
	
	public static void main(String[] args) {
		
		String diver = "com.mysql.jdbc.Driver"; 
		String jdbcUrl = "jdbc:mysql://localhost:3306/myoa?useUnicode=true&characterEncoding=UTF-8"; 
		String username = "root"; 
		String password = "root"; 
		String databaseName = "myoa";
		String tableName = "sys_role"; 
		String appPackagePrefix = "com.shupro.oa"; 
		String appName = "admin"; 
		String sourceRoot = "src/main/java";
		String jspPath = "src/main/webapp/WEB-INF/jsp";
		
		AutoModel autoModel = new AutoModel(diver, jdbcUrl, username, password, 
				databaseName, tableName, sourceRoot, jspPath, appPackagePrefix,appName);
		
		AutoCreateClassUtil.generate2EasyuiWar(autoModel);
		
//		autoModel.setTableName("sys_user");
//		AutoCreateClassUtil.generate2EasyuiWar(autoModel);
//		autoModel.setTableName("sys_dept");
//		AutoCreateClassUtil.generate2EasyuiWar(autoModel);
//		autoModel.setTableName("sys_role");
//		AutoCreateClassUtil.generate2EasyuiWar(autoModel);
		autoModel.setTableName("sys_menu");
		AutoCreateClassUtil.generate2EasyuiWar(autoModel);
		autoModel.setTableName("sys_dictionary");
		AutoCreateClassUtil.generate2EasyuiWar(autoModel);
		
	}
	
}