package cloud.sso.domain;

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
@Table(name = "user_pwd_info")
public class UserPwdInfo {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "ID")
//	private Long Id;
	@Id
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "LOGIN_PWD")
	private String loginPwd;
	
	@Column(name = "LOGIN_TYPE")
	private int loginType;
	
	@Column(name = "PWD_STATUS")
	private int pwdStatus;
	
	@Column(name = "VALIDATE")
	private Date valiDate;
	
	@Column(name = "LAST_SUCC_TIME")
	private Date lastSuccTime;
	
	@Column(name = "LAST_FAILURE_TIME")
	private Date lastFailureTime;
	
	@Column(name = "CRT_TIME")
	private Date crtTime;
	
	@Column(name = "LAST_UPD_TIME")
	private Date updTime;

//	public Long getId() {
//		return Id;
//	}
//
//	public void setId(Long id) {
//		Id = id;
//	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public int getPwdStatus() {
		return pwdStatus;
	}

	public void setPwdStatus(int pwdStatus) {
		this.pwdStatus = pwdStatus;
	}

	public Date getValiDate() {
		return valiDate;
	}

	public void setValiDate(Date valiDate) {
		this.valiDate = valiDate;
	}

	public Date getLastSuccTime() {
		return lastSuccTime;
	}

	public void setLastSuccTime(Date lastSuccTime) {
		this.lastSuccTime = lastSuccTime;
	}

	public Date getLastFailureTime() {
		return lastFailureTime;
	}

	public void setLastFailureTime(Date lastFailureTime) {
		this.lastFailureTime = lastFailureTime;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	
	
}
