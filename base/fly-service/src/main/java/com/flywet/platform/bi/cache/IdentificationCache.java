package com.flywet.platform.bi.cache;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.flywet.platform.bi.delegates.vo.Role;
import com.flywet.platform.bi.delegates.vo.User;

public class IdentificationCache {

	private static Map<Long, SoftReference<User>> USER_CACHE = new ConcurrentHashMap<Long, SoftReference<User>>();
	private static Map<String, Long> USER_LOGIN_ID_CACHE = new ConcurrentHashMap<String, Long>();
	private static Map<Long, SoftReference<Role>> ROLE_CACHE = new ConcurrentHashMap<Long, SoftReference<Role>>();

	public static final long ANOMYOUS_ROLE_ID = 0L;

	public static final long ANOMYOUS_USER = 0L;

	/**
	 * 用户缓存操作
	 * 
	 * @param id
	 * @param u
	 */
	public static void putUserCache(User u) {
		USER_CACHE.put(u.getId(), new SoftReference<User>(u));
		USER_LOGIN_ID_CACHE.put(u.getLogin(), u.getId());
	}

	public static User matchUserCache(Long id) {
		SoftReference<User> ref = USER_CACHE.get(id);
		if (ref != null) {
			if (ref.get() == null) {
				clearUserCache(id);
				return null;
			}
			return ref.get();
		}
		return null;
	}

	public static User matchUserCache(String login) {
		Long id = USER_LOGIN_ID_CACHE.get(login);
		if (id != null) {
			SoftReference<User> ref = USER_CACHE.get(id);
			if (ref != null) {
				if (ref.get() == null) {
					clearUserCache(id);
					return null;
				}
				return ref.get();
			}
		}

		return null;
	}

	public static void clearUserCache(Long id) {
		SoftReference<User> ref = USER_CACHE.remove(id);
		User u = ref.get();
		if (u != null) {
			USER_LOGIN_ID_CACHE.remove(u.getLogin());
		}
	}

	public static void clearUserCache() {
		USER_CACHE.clear();
		USER_LOGIN_ID_CACHE.clear();
	}

	/**
	 * 角色缓存操作
	 * 
	 * @param id
	 * @param r
	 */
	public static void putRoleCache(Role r) {
		ROLE_CACHE.put(r.getRid(), new SoftReference<Role>(r));
	}

	public static Role matchRoleCache(Long id) {
		SoftReference<Role> ref = ROLE_CACHE.get(id);
		if (ref != null) {
			if (ref.get() == null) {
				clearRoleCache(id);
				return null;
			}
			return ref.get();
		}
		return null;
	}

	public static void clearRoleCache(Long id) {
		ROLE_CACHE.remove(id);
	}

	public static void clearRoleCache() {
		ROLE_CACHE.clear();
	}

	public static void clearAllCache() {
		clearUserCache();
		clearRoleCache();
	}
}
