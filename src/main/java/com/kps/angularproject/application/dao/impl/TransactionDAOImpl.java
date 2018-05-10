package com.kps.angularproject.application.dao.impl;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kps.angularproject.application.dao.TransactionDAO;
import com.kps.angularproject.application.dao.hibernatepojo.Category;
import com.kps.angularproject.application.dao.hibernatepojo.TransactionsDetails;
import com.kps.angularproject.application.dao.hibernatepojo.User;
import com.kps.angularproject.application.model.TransactionModel;

@Component
public class TransactionDAOImpl implements TransactionDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addTransaction(TransactionModel txnObject) {
		Session session = sessionFactory.openSession();
		TransactionsDetails txnODetailsObject = new TransactionsDetails();
		Category cat = session.get(Category.class, Integer.parseInt(txnObject.getTxnCategory()));
		txnODetailsObject.setCategory(cat);
		txnODetailsObject.setTxnAmount(txnObject.getTxnAmount());
		txnODetailsObject.setTxnDate(txnObject.getTxnDate());
		User user = session.get(User.class, Integer.parseInt(txnObject.getTxnDoneBy()));
		txnODetailsObject.setTxnCreatedBy(user);
		txnODetailsObject.setTxnDoneBy(user);
		txnODetailsObject.setTxnEntryDate(new Date());
		txnODetailsObject.setTxnDetails(txnObject.getTxnDetails());
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(txnODetailsObject);
		tx.commit();
	}

}
