package com.hussar.mis.cas.operatiion.dao.user;

import java.util.List;

import com.hussar.mis.cas.model.entity.OrganizationEntity;
import com.hussar.mis.cas.model.entity.UserEntity;
import com.hussar.mis.frm.dao.GenericDao;

public interface UserDao extends GenericDao<UserEntity>{
	
	UserEntity getUserEntity(String value);
	List<UserEntity> getUserEntityList(OrganizationEntity org);
	
}
