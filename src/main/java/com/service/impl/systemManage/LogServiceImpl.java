package com.service.impl.systemManage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.entity.po.systemManage.Log;
import com.service.systemManage.ILogService;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dao.systemManage.LogMapper;
import com.entity.po.Example.systemManage.LogExample;
import com.entity.po.Example.systemManage.LogExample.Criteria;
import com.util.StringUtil;

@Service("logService")
public class LogServiceImpl implements ILogService {
	
	@Autowired
	LogMapper logMapper;
	@Override
	public void insertLog(Log t) throws Exception {
		logMapper.insert(t);
	};
	@Override
	public PageInfo<Log> pageLogCreateBetween(String start, String end, Log log, int pageNum, int pageSize, String ordername, String order) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		ordername = StringUtil.isNotEmpty(ordername)?ordername:"userid";
		order = StringUtil.isNotEmpty(order)?order:"desc";
		LogExample logexample = new LogExample();
		logexample.setOrderByClause(ordername+" "+order);
		Criteria criteria = logexample.createCriteria();
		if(StringUtil.isNotEmpty(log.getModule())){
			criteria.andModuleLike("%"+ log.getModule()+"%");
		}
		if(StringUtil.isNotEmpty(log.getOperation())){
			criteria.andOperationLike("%"+ log.getOperation()+"%");
		}
		if(StringUtil.isNotEmpty(log.getUsername())){
			criteria.andUsernameEqualTo(log.getUsername());
		}
		List<String> list = new ArrayList<String>();
		list.add("0");
		criteria.andModuleNotIn(list);
		Calendar cal = Calendar.getInstance();
        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1900-01-01 00:00:00");
        cal.setTime(startDate);
		Date startTime = cal.getTime();
		Date endTime = new Date();
		if(StringUtil.isNotEmpty(start)){
				startTime = DateUtil.ParseTime(start, "yyyy-MM-dd HH:mm:ss");
		}
		if(StringUtil.isNotEmpty(end)){
			endTime = DateUtil.ParseTime(end, "yyyy-MM-dd HH:mm:ss");
		}
		criteria.andCreatetimeBetween(startTime, endTime);
		List<Log> logs = logMapper.selectByExample(logexample);
		PageInfo<Log> pageInfo = new PageInfo<Log>(logs);
		return pageInfo;
	};
	@Override
	public int countLog(Log t) throws Exception {
		return logMapper.selectCount(t);
	};
	@Override
	public void deleteLog(long l) throws Exception {
		logMapper.deleteByPrimaryKey(l);
	};
	@Override
	public void truncateLog() throws Exception {
		logMapper.truncateTable();
	}

	@Override
	public List<Log> sortQueryLog(String sortName, String sort, Log log) {
		LogExample logexample = new LogExample();
		if(StringUtil.isNotEmpty(sortName)){
			logexample.setOrderByClause(sortName+" "+sort);
		}
		Criteria criteria = logexample.createCriteria();
		if(StringUtil.isNotEmpty(log.getModule())){
			criteria.andModuleEqualTo(log.getModule());
		}
		if(StringUtil.isNotEmpty(log.getOperation())){
			criteria.andOperationEqualTo(log.getOperation());
		}
		if(StringUtil.isNotEmpty(log.getUsername())){
			criteria.andUsernameEqualTo(log.getUsername());
		}
		if(StringUtil.isNotEmpty(log.getIp())){
			criteria.andIpEqualTo(log.getIp());
		}
		if(log.getLogid()!=null){
			criteria.andLogidEqualTo(log.getLogid());
		}
		List<Log> logs = logMapper.selectByExample(logexample);
		return logs;
	}

	public List<Log> findLog(Log log) {
		return logMapper.select(log);
	};
}
