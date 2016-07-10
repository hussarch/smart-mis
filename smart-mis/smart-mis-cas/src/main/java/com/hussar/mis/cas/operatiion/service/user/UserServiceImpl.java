package com.hussar.mis.cas.operatiion.service.user;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hussar.mis.cas.models.entities.OrganizationEntity;
import com.hussar.mis.cas.models.entities.UserEntity;
import com.hussar.mis.cas.operatiion.dao.user.UserDao;
import com.hussar.mis.frm.common.domain.PagingCountBean;
import com.hussar.mis.frm.exceptions.ErrorType;
import com.hussar.mis.frm.exceptions.InvalidParamException;

/**
 * @UserServiceImpl.java
 * @author XiaoYi(hussarch@126.com) Created on 下午10:49:12 2014-12-22 ©2014, some
 *         rights reserved
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserEntity getUserEntity(String value) {
		return userDao.getUserEntity(value);
	}
	
	@Override
	public UserEntity getUserEntity(int id){
		return userDao.queryById(id);
	}

	@Override
	public void addUser(UserEntity user) {
		validateParam(user);
		user.setCreatedDate(new Date());
		userDao.insert(user);
	}

	@Override
	public void updateUser(UserEntity user) {
		validateParam(user);
		user.setUpdatedDate(new Date());
		userDao.update(user);
	}
	
	private void validateParam(UserEntity user){
		if(checkExist("name", String.class, user.getName(), user.getId())){
			throw new InvalidParamException(ErrorType.INVALID_PARAM, "该姓名已注册");
		}else if(checkExist("email", String.class, user.getEmail(), user.getId())){
			throw new InvalidParamException(ErrorType.INVALID_PARAM, "该邮箱地址已注册");
		}else if(checkExist("mobileNumber", String.class, user.getMobileNumber(), user.getId())){
			throw new InvalidParamException(ErrorType.INVALID_PARAM, "该手机号已注册");
		}else if(checkExist("employeeId", Integer.class, user.getEmployeeId(), user.getId())){
			throw new InvalidParamException(ErrorType.INVALID_PARAM, "该员工号已注册");
		}
	}

	@Override
	public boolean checkExist(String fieldName, Class<?> clazz, Object value, Integer id){
		if(value == null){
			return false;
		}
		if(id == null){
			return userDao.checkExist(fieldName, clazz, value);
		}else{
			return userDao.checkExist(fieldName, clazz, value, id);
		}
	}
	
	@Override
	public void deleteUser(int userId) {
		userDao.deleteById(userId);
	}

	@Override
	public List<UserEntity> getUserEntityList(String condition, int page, int pageSize) {
		return userDao.pagedQuery(getQueryCondition(condition), page, pageSize);
	}

	private String getQueryCondition(String condition) {
		StringBuilder subSql = new StringBuilder();
		if(StringUtils.isNotEmpty(condition)){
			subSql.append(" name like '%").append(condition).append("%' or ");
			subSql.append(" englishName like '%").append(condition).append("%' or ");
			subSql.append(" employeeId like '%").append(condition).append("%' or ");
			subSql.append(" email like '%").append(condition).append("%' or ");
			subSql.append(" skypeId like '%").append(condition).append("%'");
		}
		return subSql.toString();
	}

	@Override
	public PagingCountBean getPagingCountBean(String condition, int currentPage, int pageSize) {
		int totalRecordCount = userDao.queryCount(getQueryCondition(condition));
		return new PagingCountBean(totalRecordCount, currentPage, pageSize);
	}

	@Override
	public List<UserEntity> getUserEntityList(OrganizationEntity org) {
		return userDao.getUserEntityList(org);
	}

}
