package com.service;
import com.entity.po.Attachment;
import com.github.pagehelper.PageInfo;


public interface IAttachmentService {
	
	public  void insertAttachment(Attachment t) throws Exception;
	
	public PageInfo<Attachment> findAttachment(int page, int rows) throws Exception;
	
	public int countAttachment(Attachment t) throws Exception;
	
}
