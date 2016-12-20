package com.shupro.oa.admin.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shupro.oa.admin.dao.SysLogMapper;
import com.shupro.oa.admin.model.SysLog;
import com.shupro.oa.admin.service.SysLogService;
import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;

@Service
public class SysLogServiceImpl extends AbstractService<SysLog> implements SysLogService {
	
	@Autowired
	private SysLogMapper sysLogMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysLog> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

}
