package com.kps.angularproject.application.dao.hibernatepojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "txnDetails")
public class TransactionsDetails {

	private int txnId;
	private int txnAmount;
	private TransactionType txnType;
	private User txnCreatedBy;
	private User txnDoneBy;
	private Date txnDate;
	private Date txnEntryDate;
	private Category category;
	private String txnDetails;
	private List<TransactionImage> txnImages;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getTxnId() {
		return txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	@Column
	public int getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(int txnAmount) {
		this.txnAmount = txnAmount;
	}

	@Column
	public TransactionType getTxnType() {
		return txnType;
	}

	public void setTxnType(TransactionType txnType) {
		this.txnType = txnType;
	}

	@ManyToOne
	public User getTxnCreatedBy() {
		return txnCreatedBy;
	}

	public void setTxnCreatedBy(User txnCreatedBy) {
		this.txnCreatedBy = txnCreatedBy;
	}

	@ManyToOne
	public User getTxnDoneBy() {
		return txnDoneBy;
	}

	public void setTxnDoneBy(User txnDoneBy) {
		this.txnDoneBy = txnDoneBy;
	}

	@Column
	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	@Column
	public Date getTxnEntryDate() {
		return txnEntryDate;
	}

	@ManyToOne
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column
	public String getTxnDetails() {
		return txnDetails;
	}

	public void setTxnDetails(String txnDetails) {
		this.txnDetails = txnDetails;
	}

	@OneToMany
	public List<TransactionImage> getTxnImages() {
		return txnImages;
	}

	public void setTxnImages(List<TransactionImage> txnImages) {
		this.txnImages = txnImages;
	}

	public void setTxnEntryDate(Date txnEntryDate) {
		this.txnEntryDate = txnEntryDate;
	}

	public enum TransactionType {
		CREDIT("CR"), DEBIT("DR");
		private String val;

		TransactionType(String val) {
			this.val = val;
		}

		public String getVal() {
			return this.val;
		}
	}
}
