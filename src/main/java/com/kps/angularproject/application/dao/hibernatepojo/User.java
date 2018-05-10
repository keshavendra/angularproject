package com.kps.angularproject.application.dao.hibernatepojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserTbl")
public class User {

	private int userId;
	private UserName userName;
	private String userPassword;
	private UserDetails userDetails;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Embedded
	public UserName getUserName() {
		return userName;
	}

	public void setUserName(UserName userName) {
		this.userName = userName;
	}

	@Column
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Embedded
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Embeddable
	public static class UserName {
		private String firstName;
		private String lastName;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}

	@Embeddable
	public static class UserDetails {
		private String userEmailId;
		private String userMobileNumber;

		public String getUserEmailId() {
			return userEmailId;
		}

		public void setUserEmailId(String userEmailId) {
			this.userEmailId = userEmailId;
		}

		public String getUserMobileNumber() {
			return userMobileNumber;
		}

		public void setUserMobileNumber(String userMobileNumber) {
			this.userMobileNumber = userMobileNumber;
		}
	}

}
