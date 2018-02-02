package com.constant;
/**
 * 响应码
 * @author xiejiaqiang
 *
 */
public enum ResponseCode {
	DEF_ERROR_CODE("S1000", "系统错误");
	  private String code;
	  private String msg;
	  
	  private ResponseCode(String code, String msg)
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
