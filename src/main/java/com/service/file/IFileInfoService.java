package com.service.file;

import com.alibaba.fastjson.JSONArray;
import com.entity.po.file.TFileInfo;

import java.util.List;
import java.util.Map;

public interface IFileInfoService {


	public TFileInfo findFileInfo(Long id) throws Exception;

	public Integer countFileInfo(TFileInfo t) throws Exception ;

	public List<TFileInfo> findFileInfo(TFileInfo t) throws Exception ;

	public void deleteFileInfo(Long id) throws Exception ;

	public void deleteFileInfoByBatchNo(String  batchNo) throws Exception ;

	public void addFileInfo(TFileInfo t) throws Exception ;

	public void updateFileInfo(TFileInfo t) throws Exception;

	public List<TFileInfo> findFileInfoByBathNo(String batchNo) throws Exception;
}
