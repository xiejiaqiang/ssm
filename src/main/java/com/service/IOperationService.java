package com.service;
import com.entity.po.Operation;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IOperationService {

	public PageInfo<Operation> findOperationPage(Operation t, int page, int rows) throws Exception;
	
	public List<Operation> findOperation(Operation t) throws Exception;

	public int countOperation(Operation t) throws Exception;

	public void addOperation(Operation t) throws Exception;

	public void updateOperation(Operation t) throws Exception;

	public void deleteOperation(Integer operationId) throws Exception;


}