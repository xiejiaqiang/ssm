package com.dao;

import com.base.dao.BaseMapper;
import com.entity.po.Log;

public interface LogMapper extends BaseMapper<Log> {

	void truncateTable();
}