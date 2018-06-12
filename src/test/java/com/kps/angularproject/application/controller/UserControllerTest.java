package com.kps.angularproject.application.controller;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.kps.angularproject.application.config.TestDatabaseConfiguration;
import com.kps.angularproject.application.dao.hibernatepojo.User;
import com.kps.angularproject.application.dao.impl.UserDaoImpl;
import com.kps.angularproject.application.model.UserModel;
import com.kps.angularproject.application.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	@Mock
	private UserServiceImpl mockUserService;
	@Mock
	private UserDaoImpl mockUserDaoObject;

	@Autowired
	SessionFactory sessionFactory;

	@Before
	public void setup() {
		userController = new UserController();
		// userDaoObject = new UserDaoImpl();
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(mockUserDaoObject, "sessionFactory", sessionFactory);
		ReflectionTestUtils.setField(mockUserService, "userDaoObject", mockUserDaoObject);
		when(mockUserService.saveUserDetails(any(UserModel.class))).thenCallRealMethod();
		when(mockUserDaoObject.saveUserDetails(any(UserModel.class))).thenCallRealMethod();
		// when(mockUserService.saveUserDetails(any(UserModel.class))).thenCallRealMethod();
		System.out.println("setup done!!!!");
	}

	@Test
	public void testvalidate() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", "admin");
		map.put("password", "admin");
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
		mockMvc.perform(post("/validate").content(new Gson().toJson(map).getBytes())).andExpect(status().isOk());
	}

	@Test
	public void testCreateUser() throws Exception {
		UserModel userModel = new UserModel();
		userModel.setFirstName("Keshav");
		userModel.setLastName("Singh");
		userModel.setPassword("password");
		userModel.setEmail("abc@abc.com");

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
		mockMvc.perform(post("/createUser").content(new Gson().toJson(userModel).getBytes()))
				.andExpect(status().isOk());
		List<User> userList = sessionFactory.getCurrentSession().createCriteria(User.class.getName()).list();

		assertNotNull(userList);
		assertNotEquals(0, userList.size());
	}
}
