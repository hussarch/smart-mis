package com.hussar.mis.cas.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @DailyClockEntity.java
 * @author XiaoYi(hussarch@126.com)
 * Created on 2016年7月10日, ©2016 some rights reserved
 */
@Entity
@Table(name = "DAILY_CLOCK")
@DynamicInsert(true)
@DynamicUpdate(true)
public class DailyClockEntity{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private Integer id;
	
	@JoinColumn(name = "USER_ID", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CLOCK_IN_TIME", updatable=false)
	private Date clockInTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Date getClockInTime() {
		return clockInTime;
	}

	public void setClockInTime(Date clockInTime) {
		this.clockInTime = clockInTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((clockInTime == null) ? 0 : clockInTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		DailyClockEntity other = (DailyClockEntity) obj;
		if (clockInTime == null) {
			if (other.clockInTime != null)
				return false;
		} else if (!clockInTime.equals(other.clockInTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DailyClockEntity [id=" + id + ", user=" + user + ", clockInTime=" + clockInTime + "]";
	} 
	
}
