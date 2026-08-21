package com.rays.preparedstatement.bankaccount;

import java.util.Iterator;
import java.util.List;

import com.rays.preparedstatement.patient.PatientBean;

public class TestBankAccountModel {

	public static BankAccountModel model = new BankAccountModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();

		testSearch();
	}

//	---------------------------------------Create------------------------------------------------
	private static void testCreate() throws Exception {
		model.create();
	}

//	---------------------------------------Insert------------------------------------------------
	private static void testInsert() throws Exception {
		BankAccountBean bean = new BankAccountBean();

//		bean.setAccountNumber(1);
//	    bean.setAccountHolderName("Aarav Sharma");
//	    bean.setAccountType("Savings");
//	    bean.setBalance(25000);
//	    bean.setBranchName("Indore");

//		bean.setAccountNumber(2);
//		bean.setAccountHolderName("Riya Verma");
//		bean.setAccountType("Current");
//		bean.setBalance(45000);
//		bean.setBranchName("Bhopal");

//		 bean.setAccountNumber(3);
//		    bean.setAccountHolderName("Aditya Patel");
//		    bean.setAccountType("Savings");
//		    bean.setBalance(32000);
//		    bean.setBranchName("Ujjain");

//		bean.setAccountNumber(4);
//		bean.setAccountHolderName("Neha Jain");
//		bean.setAccountType("Current");
//		bean.setBalance(55000);
//		bean.setBranchName("Indore");

//		bean.setAccountNumber(5);
//		bean.setAccountHolderName("Rahul Singh");
//		bean.setAccountType("Savings");
//		bean.setBalance(18000);
//		bean.setBranchName("Dewas");

//		bean.setAccountNumber(6);
//		bean.setAccountHolderName("Ananya Gupta");
//		bean.setAccountType("Savings");
//		bean.setBalance(67000);
//		bean.setBranchName("Bhopal");

//		bean.setAccountNumber(7);
//	    bean.setAccountHolderName("Vivek Mehta");
//	    bean.setAccountType("Current");
//	    bean.setBalance(38000);
//	    bean.setBranchName("Indore");

//		bean.setAccountNumber(8);
//		bean.setAccountHolderName("Pooja Sharma");
//		bean.setAccountType("Savings");
//		bean.setBalance(29000);
//		bean.setBranchName("Ratlam");

//		bean.setAccountNumber(9);
//		bean.setAccountHolderName("Karan Joshi");
//		bean.setAccountType("Current");
//		bean.setBalance(72000);
//		bean.setBranchName("Ujjain");

//		bean.setAccountNumber(10);
//		bean.setAccountHolderName("Sneha Agarwal");
//		bean.setAccountType("Savings");
//		bean.setBalance(41000);
//		bean.setBranchName("Dewas");

		bean.setAccountNumber(11);
		bean.setAccountHolderName("Manish Yadav");
		bean.setAccountType("Savings");
		bean.setBalance(52000);
		bean.setBranchName("Indore");

		model.insert(bean);
	}

//	-----------------------------------------Update--------------------------------------------

	private static void testUpdate() throws Exception {
		BankAccountBean bean = new BankAccountBean();

		bean.setAccountNumber(11);
		bean.setAccountHolderName("Hemant Singh");
		bean.setAccountType("Savings");
		bean.setBalance(52350);
		bean.setBranchName("Bhopal");

		model.update(bean);

	}

//	----------------------------------------Delete---------------------------------------------

	private static void testDelete() throws Exception {
		model.delete(11);
	}

//	----------------------------------------Search--------------------------------------------

	private static void testSearch() throws Exception {

		BankAccountBean bean = new BankAccountBean();

		List<BankAccountBean> list = model.search(bean, 0, 0);

		Iterator<BankAccountBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getAccountNumber());
			System.out.print("\t" + bean.getAccountHolderName());
			System.out.print("\t" + bean.getAccountType());
			System.out.print("\t" + bean.getBalance());
			System.out.println("\t" + bean.getBranchName());

		}

	}
}
