package com.constant;
/**
 * 响应码
 * @author xiejiaqiang
 *
 */
public enum ModuleTypeCode {
	SYSTEM_UPDATE_LOG_CODE("0", "系统更新记录"),
	INSERT_LOG_CODE("1", "增加"),
	DELETE_LOG_CODE("2", "删除"),
	UPDATE_LOG_CODE("3", "修改"),
	QUERY_LOG_CODE("4", "查询"),
	EXT_LOG_CODE("5", "退出"),
	LOGIN_LOG_CODE("6", "登录");
	  private String code;
	  private String msg;

	  private ModuleTypeCode(String code, String msg)
	  {
	    this.code = code;
	    this.msg = msg;
	  }
	  
	  public String getCode()
	  {
	    return this.code;
	  }
	  
	  public String getMsg()
	  {
	    return this.msg;
	  }
}
