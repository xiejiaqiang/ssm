package com.entity.vo;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统更新日志
 * @author xjq
 */
public class UpdateLogVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long  id;
	/**
	 * 操作人
	 */
	private String username;
	/**
	 * 时间
	 */
	private String createtime;
	/**
	 * 版本号
	 */
	private String versionsNo;
	/**
	 * 详细
	 */
	private List<String> content;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	/**
	 * 操作人
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 操作人
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 时间
	 */
	public String getCreatetime() {
		return createtime;
	}
	/**
	 * 时间
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * 版本号
	 */
	public String getVersionsNo() {
		return versionsNo;
	}
	/**
	 * 版本号
	 */
	public void setVersionsNo(String versionsNo) {
		this.versionsNo = versionsNo;
	}
	/**
	 * 详细
	 */
	public List<String> getContent() {
		return content;
	}
	/**
	 * 详细
	 */
	public void setContent(List<String> content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("UpdateLogVO{");
		sb.append("id=").append(id);
		sb.append(", username='").append(username).append('\'');
		sb.append(", createtime='").append(createtime).append('\'');
		sb.append(", versionsNo='").append(versionsNo).append('\'');
		sb.append(", content=").append(content);
		sb.append('}');
		return sb.toString();
	}
}
