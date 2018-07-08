package com.kps.angularproject.application.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.kps.angularproject.application.config.TestDatabaseConfiguration;
import com.kps.angularproject.application.model.UserModel;
import com.kps.angularproject.application.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	@Mock
	private UserService mockUserService;

	@Autowired
	SessionFactory sessionFactory;
	
	MockMvc mockMvc;

	@Before
	public void setup() {
		userController = new UserController();
		MockitoAnnotations.initMocks(this);
		when(mockUserService.saveUserDetails(any(UserModel.class))).thenReturn(true);
		when(mockUserService.getUserDetails()).thenReturn(new ArrayList());
		mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
	}

	@Test
	public void testvalidate() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", "admin");
		map.put("password", "admin");
//		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
		mockMvc.perform(post("/validate").content(new Gson().toJson(map).getBytes())).andExpect(status().isOk());
	}

	@Test
	public void testCreateUser() throws Exception {
		UserModel userModel = new UserModel();
		userModel.setFirstName("Keshav");
		userModel.setLastName("Singh");
		userModel.setPassword("password");
		userModel.setEmail("abc@abc.com");
		mockMvc.perform(post("/createUser").content(new Gson().toJson(userModel).getBytes()))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testUserDetails() {
		try {
			mockMvc.perform(get("/details")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
