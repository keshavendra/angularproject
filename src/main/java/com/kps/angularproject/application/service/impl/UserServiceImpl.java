package com.kps.angularproject.application.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kps.angularproject.application.dao.TransactionDAO;
import com.kps.angularproject.application.dao.UserDao;
import com.kps.angularproject.application.model.TransactionModel;
import com.kps.angularproject.application.model.UserModel;
import com.kps.angularproject.application.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TransactionDAO txnDaoObject;
	
	@Autowired
	private UserDao userDaoObject;
	
	public void validateUser(Map user, HttpServletRequest request) {
		String userName = user.get("email").toString();
		String password = user.get("password").toString();
		if (!(userName.equals("admin") && password.equals("admin"))) {
			throw new RuntimeException("Invalid user");
		}
	}

	public List getUserDetails() {
		UserModel ud1 = new UserModel();
		ud1.setEmail("john@example.com");
		ud1.setFirstName("John");
		ud1.setLastName("Doe");
		UserModel ud2 = new UserModel();
		ud2.setEmail("vicky@gmail.com");
		ud2.setFirstName("vicky");
		ud2.setLastName("Ray");
		UserModel ud3 = new UserModel();
		ud3.setEmail("abc@yahoo.co.in");
		ud3.setFirstName("abc");
		ud3.setLastName("greg");
		UserModel ud4 = new UserModel();
		ud4.setFirstName("xyz");
		ud4.setEmail("xyz@gmail.com");
		ud4.setLastName("Bard");
		return Arrays.asList(ud1, ud2, ud3, ud4);
	}

	public boolean saveUserDetails(UserModel userModel) {
		return userDaoObject.saveUserDetails(userModel);
	}

	public void createTransaction(TransactionModel txnModelObject) {
		txnDaoObject.addTransaction(txnModelObject);
	}

}
