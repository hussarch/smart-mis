package com.hussar.mis.cas.operatiion.dao.user;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hussar.mis.cas.models.entities.OrganizationEntity;
import com.hussar.mis.cas.models.entities.UserEntity;
import com.hussar.mis.frm.dao.GenericDaoImpl;

/**
 * @UserDaoImpl.java
 * @author XiaoYi(hussarch@126.com)
 * Created on 下午10:08:36 2014-12-22
 * ©2014, some rights reserved
 */
@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<UserEntity> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

	@Override
	public UserEntity getUserEntity(String value) {
		StringBuilder hql = new StringBuilder();
		hql.append("from UserEntity where name = ? or employeeId  = ? or email = ? or mobileNumber = ? ");
		Query query = getCurrentSession().createQuery(hql.toString());
		int i = 0;
		query.setString(i++, value);
		query.setInteger(i++, getValue(value));
		query.setString(i++, value);
		query.setString(i++, value);
        List<?> list = query.list();
		if(list == null || list.size() == 0){
			return null;
		}else{
			return (UserEntity) list.get(0);
		}
	}
	
	private int getValue(String value){
		if(StringUtils.isNumeric(value)){
			if(value.length() < 9){
				return Integer.parseInt(value);
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUserEntityList(OrganizationEntity org) {
		Query query = null;
		if(org == null){
			query = getCurrentSession().createQuery("from UserEntity where organization is null");
		}else{
			query = getCurrentSession().createQuery("from UserEntity where organization = ?");
			query.setParameter(0, org);
		}
		return query.list();
	}

}
