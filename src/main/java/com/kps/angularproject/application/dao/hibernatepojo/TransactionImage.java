package com.kps.angularproject.application.dao.hibernatepojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="txnImage")
public class TransactionImage {
	private int imgId;
	private byte[] imgSrc;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	@Lob
	public byte[] getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(byte[] imgSrc) {
		this.imgSrc = imgSrc;
	}
}
