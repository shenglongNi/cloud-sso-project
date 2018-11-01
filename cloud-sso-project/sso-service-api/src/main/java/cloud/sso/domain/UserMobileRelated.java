package cloud.sso.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_mobile_related")
public class UserMobileRelated {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "CREATE_TIME")
	private Date createTime;
	
	@Column(name = "UPDATE_TIME")
	private Date updTime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

	@Override
	public String toString() {
		return "UserMobileRelated [userId=" + userId + ", mobile=" + mobile + ", createTime=" + createTime
				+ ", updTime=" + updTime + "]";
	}

}
