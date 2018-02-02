/*
 * Copyright (C), 2015, IBM GBS China.
 * FileName: AcqServiceException.java
 * Author:   IBM
 * Date:     
 * Description:  收单中心异常  
 * History:     //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.exception;



/**
 * ssm异常
 * @author xjq
 */
public  class SsmException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 9010169518615393712L;

	private String code;
	private String msg;

	public SsmException() {
		super();
	}

	/**
	 * 构造方法
	 * @param msg 异常信息
	 */
	public SsmException(String msg) {
		super(msg);
	}

	/**
	 * 构造方法
	 * @param code 原因
	 */
	public SsmException(Throwable code) {
		super(code);
	}
	/**
	 * 构造方法
	 * @param code 原因
	 * @param msg 异常信息
	 */
	public SsmException(String msg, Throwable code) {
		super(msg,code);
		this.code = code.getMessage();
		this.msg = msg;
	}
	/**
	 * 构造方法
	 * @param code 原因
	 * @param msg 异常信息
	 */
	public SsmException(String msg, String code) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public  String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("***接口发生异常***异常代码：").append("{").append(code).append("}");
		sb.append("异常信息：").append("{").append(msg).append("}");;
		return  sb.toString();
	}
}
