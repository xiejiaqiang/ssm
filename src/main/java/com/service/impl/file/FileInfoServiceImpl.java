package com.service.impl.file;

import com.dao.file.FileInfoMapper;
import com.entity.po.file.TFileInfo;
import com.service.file.IFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FileInfoService")
public class FileInfoServiceImpl implements IFileInfoService {

	@Autowired
	FileInfoMapper fileInfoMapper;

	public List<TFileInfo> findFileInfo(TFileInfo t) throws Exception {
		return fileInfoMapper.select(t);
	};
	public List<TFileInfo> findFileInfoByBathNo(String batchNo) throws Exception {
		TFileInfo t = new TFileInfo();
		t.setBatchNo(batchNo);
		return fileInfoMapper.select(t);
	};

	public Integer countFileInfo(TFileInfo t) throws Exception {
		return fileInfoMapper.selectCount(t);
	};

	public void addFileInfo(TFileInfo t) throws Exception {
		fileInfoMapper.insert(t);
	};

	public void updateFileInfo(TFileInfo t) throws Exception {
		fileInfoMapper.updateByPrimaryKeySelective(t);
	}


	public void deleteFileInfo(Long id) throws Exception {
		fileInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteFileInfoByBatchNo(String batchNo) throws Exception {
		TFileInfo t = new TFileInfo();
				t.setBatchNo(batchNo);
		fileInfoMapper.delete(t);
	};

	public TFileInfo findFileInfo(Long id) {
		return fileInfoMapper.selectByPrimaryKey(id);
	};
}
