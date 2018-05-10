package com.kps.angularproject.application.dao.hibernatepojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	private int catId;
	private String catName;
	private String catDetails;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	@Column
	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Column
	public String getCatDetails() {
		return catDetails;
	}

	public void setCatDetails(String catDetails) {
		this.catDetails = catDetails;
	}

}
