package com.flywet.platform.bi.services.intf;

import java.util.List;

import org.pentaho.di.repository.IUser;

import com.flywet.platform.bi.core.exception.BIException;
import com.flywet.platform.bi.delegates.enums.AuthorizationObjectCategory;
import com.flywet.platform.bi.delegates.enums.PermissionCategory;
import com.flywet.platform.bi.delegates.vo.Role;
import com.flywet.platform.bi.delegates.vo.User;

public interface BIUserDelegate {
	public List<User> getAllUser() throws BIException;

	public User getCurrentUser() throws BIException;

	public User getAnomyous() throws BIException;

	public User getUserById(long uid) throws BIException;

	public User getUserByLogin(String login) throws BIException;

	public void delUser(long uid) throws BIException;

	public void saveUser(User user) throws BIException;

	public void relateToRole(long uid, List<Long> roleIds) throws BIException;

	public List<Role> getRelateRoles(long uid) throws BIException;

	public IUser convetToKettleUser(User user);

	public User convetToBIUser(IUser iuser);

	public boolean authenticate(AuthorizationObjectCategory cate, long id)
			throws BIException;

	public boolean authenticate(AuthorizationObjectCategory cate, long id,
			PermissionCategory permission) throws BIException;

	public boolean authenticate(long uid, AuthorizationObjectCategory cate,
			long id) throws BIException;

	public boolean authenticate(long uid, AuthorizationObjectCategory cate,
			long id, PermissionCategory permission) throws BIException;
}
