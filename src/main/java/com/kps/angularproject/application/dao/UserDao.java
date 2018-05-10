package com.kps.angularproject.application.dao;

import com.kps.angularproject.application.model.UserModel;

public interface UserDao {
	public boolean saveUserDetails(UserModel userModel);
}
