package com.kps.angularproject.application.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.kps.angularproject.application.model.TransactionModel;
import com.kps.angularproject.application.model.UserModel;
import com.kps.angularproject.application.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ResponseEntity validate(@RequestBody String userString, HttpServletRequest request) {
		Map user = new Gson().fromJson(userString, Map.class);
		userService.validateUser(user, request);
		return new ResponseEntity(HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ResponseEntity<List> userDetails() {
		List userDetails = userService.getUserDetails();
		return new ResponseEntity<List>(userDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
	public ResponseEntity createTransaction(@RequestBody String requestDetails, HttpServletRequest request) {
		TransactionModel txnObject = new Gson().fromJson(requestDetails, TransactionModel.class);
		userService.createTransaction(txnObject);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody String requestDetails, HttpServletRequest request) {
		UserModel userModel = new Gson().fromJson(requestDetails, UserModel.class);
		userService.saveUserDetails(userModel);
		return new ResponseEntity(HttpStatus.OK);
	}
}
