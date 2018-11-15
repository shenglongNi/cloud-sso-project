package cloud.sso.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@DynamicInsert
@DynamicUpdate
@Entity
@Table(name="user_info")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "USER_NAME")
	private String username;
	
	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "SEX")
	private Integer sex;
	
	@Column(name = "BIRTHDAY_DATE")
	private Date birthday;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "USER_STATUS")
	private String userStatus;
	
	@Column(name = "CRT_TIME")
	private Timestamp crtTime;
	
	@Column(name = "LST_UPD_TIME")
	private Timestamp lastUpdTime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Timestamp getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Timestamp crtTime) {
		this.crtTime = crtTime;
	}

	public Timestamp getLastUpdTime() {
		return lastUpdTime;
	}

	public void setLastUpdTime(Timestamp lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", mobile=" + mobile + ", sex=" + sex + ", birthday="
				+ birthday + ", email=" + email + ", userStatus=" + userStatus
				+ ", crtTime=" + crtTime + ", lastUpdTime=" + lastUpdTime + "]";
	}
	
	
}
	