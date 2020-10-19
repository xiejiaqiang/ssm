package com.dao.systemManage;

import com.base.dao.BaseMapper;
import com.entity.po.systemManage.Log;

public interface LogMapper extends BaseMapper<Log> {

	void truncateTable();
}