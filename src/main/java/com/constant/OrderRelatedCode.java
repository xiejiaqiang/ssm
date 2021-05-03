package com.constant;
/**
 * 响应码
 * @author xiejiaqiang
 *
 */
public enum OrderRelatedCode {
	ORDER_STATUS_0("0", "待支付"),
	ORDER_STATUS_1("1", "已付款"),
	ORDER_STATUS_2("2", "已发货"),
	ORDER_STATUS_3("3", "已收货"),
	ORDER_STATUS_4("4", "退款中"),
	ORDER_STATUS_5("5", "已退款"),
	ORDER_STATUS_99("99", "已取消"),
	ORDER_TYPE_0("0", "其它"),
	ORDER_TYPE_1("1", "天猫"),
	ORDER_TYPE_2("2", "京东"),
	ORDER_TYPE_3("3", "淘宝"),
	ORDER_TYPE_4("4", "拼多多");
	  private String code;
	  private String msg;

	  private OrderRelatedCode(String code, String msg)
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
