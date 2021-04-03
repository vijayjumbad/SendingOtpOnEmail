package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "OTP_GEN")
@Entity
public class OtpEntity {
	
	@GeneratedValue
	@Id
	private Integer otpId;
	private String otp;
	public Integer getOtpId() {
		return otpId;
	}
	public void setOtpId(Integer otpId) {
		this.otpId = otpId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "OtpEntity [otpId=" + otpId + ", otp=" + otp + "]";
	}

	
	

}
