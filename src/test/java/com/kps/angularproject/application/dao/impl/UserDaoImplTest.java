package com.kps.angularproject.application.dao.impl;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.kps.angularproject.application.config.TestDatabaseConfiguration;
import com.kps.angularproject.application.dao.hibernatepojo.User;
import com.kps.angularproject.application.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class UserDaoImplTest {
	@InjectMocks
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Before
	public void setup() {
		userDaoImpl = new UserDaoImpl();
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(userDaoImpl, "sessionFactory", sessionFactory);
	}
	
	@Test
	public void testSaveUser() {
		UserModel userModel = new UserModel();
		userModel.setFirstName("Keshav");
		userModel.setLastName("Singh");
		userModel.setPassword("password");
		userModel.setEmail("abc@abc.com");
		boolean userDaoOutput = userDaoImpl.saveUserDetails(userModel);

		//assert starting
		assertTrue(userDaoOutput);
		
		List<User> userList = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		assertNotNull(userList);
		assertNotEquals(0, userList.size());
		assertTrue(0 < userList.get(0).getUserId());
	}
}
