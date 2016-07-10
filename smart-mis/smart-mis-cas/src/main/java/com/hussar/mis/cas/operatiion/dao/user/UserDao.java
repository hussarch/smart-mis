package com.hussar.mis.cas.operatiion.dao.user;

import java.util.List;

import com.hussar.mis.cas.models.entities.OrganizationEntity;
import com.hussar.mis.cas.models.entities.UserEntity;
import com.hussar.mis.frm.dao.GenericDao;

public interface UserDao extends GenericDao<UserEntity>{
	
	UserEntity getUserEntity(String value);
	List<UserEntity> getUserEntityList(OrganizationEntity org);
	
}
