package com.service.mdse;
import com.entity.po.mdse.TMdsePrice;

import java.util.List;

public interface IMdsePriceService {


	public TMdsePrice findMdsePrice(Long id) throws Exception;

	public List<TMdsePrice> findMdsePrice(TMdsePrice t) throws Exception ;

	public Integer countMdsePrice(TMdsePrice t) throws Exception ;

	public Integer deleteMdsePrice(Long id) throws Exception ;

	public Integer addMdsePrice(TMdsePrice t) throws Exception ;

	public Integer updateMdsePrice(TMdsePrice t) throws Exception;

	public TMdsePrice findMdsePriceByMdseNo(String mdseNo) throws Exception;

	// 通过商品编号判断是否存在，（不能重复）
	public boolean existMdsePriceWithMdseNo(String mdseNo)throws Exception ;
	// 无效 待找原因
	public void deleteByMdseNos(List<Long> ids)throws Exception ;
	// 无效
	public void deleteByMdseNo(String mdseNo)throws Exception ;
}
