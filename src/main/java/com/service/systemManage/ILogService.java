package com.service.systemManage;
import com.entity.po.systemManage.Log;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ILogService {

	public void insertLog(Log t) throws Exception;

	public PageInfo<Log> pageLogCreateBetween(String start, String end, Log log, int pageNum, int pageSize, String ordername, String order) throws Exception;

	public int countLog(Log t) throws Exception;

	public void deleteLog(long l) throws Exception;

	public void truncateLog() throws Exception;

	public List<Log> sortQueryLog(String sortName, String sort, Log log);

	public Log queryLoginByUserNameLimit1(String userName);
}
