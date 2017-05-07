package com.hussar.mis.cas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hussar.mis.frm.entity.BasicEntity;

/**
 * @ManagerEntity.java
 * @author XiaoYi(hussarch@126.com)
 * Created on 2015-2-6, ©2015 some rights reserved
 */
@Entity
@Table(name = "MANAGER")
@DynamicInsert(true)
@DynamicUpdate(true)
public class ManagerEntity extends BasicEntity{
	
	@Column(name="TITLE", length=64, nullable=false)
	private String title;
	
	@Column(name="TYPE", nullable=true, length = 32)
	private String type;
	
	@JoinColumn(name = "USER_ID", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user;
	
	@JoinColumn(name = "SUPER_MANAGER_ID", nullable = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private ManagerEntity superManager;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ManagerEntity getSuperManager() { 
		return superManager;
	}

	public void setSuperManager(ManagerEntity superManager) {
		this.superManager = superManager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((superManager == null) ? 0 : superManager.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ManagerEntity other = (ManagerEntity) obj;
		if (superManager == null) {
			if (other.superManager != null)
				return false;
		} else if (!superManager.equals(other.superManager))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
		return "ManagerEntity [title=" + title + ", type=" + type + ", user=" + user + ", superManager=" + superManager + "]";
	}

}
