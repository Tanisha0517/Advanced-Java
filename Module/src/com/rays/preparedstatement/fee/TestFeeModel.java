package com.rays.preparedstatement.fee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestFeeModel {

	public static FeeModel model = new FeeModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();
		testSearch();
	}

	// Calls the Create() method to create the Fee table in the database.
	public static void testCreate() throws Exception {
		model.Create();
	}

	// Calls the insert() method to insert a new record into the Fee table.
	public static void testInsert() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		FeeBean bean = new FeeBean();

		bean.setFeeId(3);
		bean.setStudentId(103);
		bean.setAmount(28000);
		bean.setPaymentDate(sdf.parse("2026-02-05"));
		bean.setPaymentstatus("Paid");

		model.Insert(bean);

	}

	private static void testUpdate() throws Exception {
		FeeBean bean = new FeeBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFeeId(10);
		bean.setStudentId(110);
		bean.setAmount(35000);
		bean.setPaymentDate(sdf.parse("2026-05-25 "));
		bean.setPaymentstatus("Paid");

		model.Update(bean);
	}

	private static void testDelete() throws Exception {
		model.Delete(10);
	}

//	---------------------Search - All records exist in table---------------------

	public static void testSearch() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		FeeBean bean = new FeeBean();
//		bean.setPaymentDate(sdf.parse(" 2026-04-20")); // filter
		List<FeeBean> list = model.search(bean, 0, 0);
//		List<FeeBean> list = model.search(bean, 1, 5);//First 5 records
//		List<FeeBean> list = model.search(bean, 2, 5);//Next five records

		Iterator<FeeBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getFeeId());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getAmount());
			System.out.print("\t" + bean.getPaymentDate());
			System.out.println("\t" + bean.getPaymentstatus());

		}

	}

}
