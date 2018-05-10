package com.kps.angularproject.application.model;

import java.util.Date;

public class TransactionModel {
	private Date txnDate;
	private String txnDoneBy;
	private String txnAddedBy;
	private String txnCategory;
	private String txnDetails;
	private int txnAmount;

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	public String getTxnDoneBy() {
		return txnDoneBy;
	}

	public void setTxnDoneBy(String txnDoneBy) {
		this.txnDoneBy = txnDoneBy;
	}

	public String getTxnAddedBy() {
		return txnAddedBy;
	}

	public void setTxnAddedBy(String txnAddedBy) {
		this.txnAddedBy = txnAddedBy;
	}

	public String getTxnCategory() {
		return txnCategory;
	}

	public void setTxnCategory(String txnCategory) {
		this.txnCategory = txnCategory;
	}

	public String getTxnDetails() {
		return txnDetails;
	}

	public void setTxnDetails(String txnDetails) {
		this.txnDetails = txnDetails;
	}

	public int getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(int txnAmount) {
		this.txnAmount = txnAmount;
	}
}
