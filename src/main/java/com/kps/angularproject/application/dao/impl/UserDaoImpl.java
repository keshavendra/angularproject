package com.kps.angularproject.application.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kps.angularproject.application.dao.UserDao;
import com.kps.angularproject.application.dao.hibernatepojo.User;
import com.kps.angularproject.application.model.UserModel;

@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveUserDetails(UserModel userModel) {
		User user = new User();
		User.UserName userName = new User.UserName();
		userName.setFirstName(userModel.getFirstName());
		userName.setLastName(userModel.getLastName());
		User.UserDetails userDetails = new User.UserDetails();
		userDetails.setUserMobileNumber(userModel.getPhoneNumber());
		userDetails.setUserEmailId(userModel.getEmail());
		user.setUserName(userName);
		user.setUserDetails(userDetails);
		user.setUserPassword(userModel.getPassword());
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
