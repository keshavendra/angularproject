package com.kps.angularproject.application.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kps.angularproject.application.model.TransactionModel;
import com.kps.angularproject.application.model.UserModel;

public interface UserService {
	public void validateUser(Map user, HttpServletRequest request);
	public List getUserDetails();
	public boolean saveUserDetails(UserModel userModel);
	public void createTransaction(TransactionModel txnModelObject);
}
