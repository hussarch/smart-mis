package com.hussar.mis.cas.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hussar.mis.cas.model.Gender;
import com.hussar.mis.frm.entity.BasicEntity;

/**
 * @UserInfo.java
 * @author XiaoYi(hussarch@126.com) Created on 下午7:22:54 2014-12-20 ©2014, some
 *         rights reserved
 */
@Entity
@Table(name = "USER")
@DynamicInsert(true)
@DynamicUpdate(true)
public class UserEntity extends BasicEntity {
	
	@Column(name="USER_NAME", length=32, nullable=false)
	private String name;
	
	@Column(name="EMPLOYEE_ID", nullable=true)
	private Integer employeeId;
	
	@Column(name="EMAIL", length=64, nullable=true)
	private String email;
	
	@Column(name="MOBILE_NUMBER", length=32, nullable=true)
	private String mobileNumber;
	
	@Column(name="EXTENSION_NUMBER", nullable=true)
	private Integer phoneNumber;

	@Column(name="GENDER", nullable=true)
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.MALE;
	
	@Column(name="PASSWORD", length=32, nullable=true)
	private String password;
	
	@Column(name="JOIN_DATE", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	
	@JoinColumn(name = "ORGANIZATION_ID", nullable = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private OrganizationEntity organization;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
    	return gender;
    }

	public void setGender(Gender gender) {
    	this.gender = gender;
    }

	public Date getJoinDate() {
    	return joinDate;
    }

	public void setJoinDate(Date joinDate) {
    	this.joinDate = joinDate;
    }

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (gender != other.gender)
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}


}
