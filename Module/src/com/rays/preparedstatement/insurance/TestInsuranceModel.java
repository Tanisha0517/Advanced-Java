package com.rays.preparedstatement.insurance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class TestInsuranceModel {

	public static InsuranceModel model = new InsuranceModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//	    testUpdate();
//		testDelete();
		testSearch();
	}

//	----------------------------------------------Create----------------------------------------------
	public static void testCreate() throws Exception {
		model.Create();
	}

//	----------------------------------------------Insert-----------------------------------------------
	public static void testInsert() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		InsuranceBean bean = new InsuranceBean();

//		bean.setPolicyId(1);
//		bean.setPolicyHolderName("Rahul");
//		bean.setPolicyType("Health");
//		bean.setPremiumAmount(5000);
//		bean.setExpiryDate(sdf.parse("2026-12-31"));

//		bean.setPolicyId(2);
//		bean.setPolicyHolderName("Priya");
//		bean.setPolicyType("Life");
//		bean.setPremiumAmount(7000);
//		bean.setExpiryDate(sdf.parse("2027-01-15"));

//		bean.setPolicyId(3);
//		bean.setPolicyHolderName("Amit");
//		bean.setPolicyType("Car");
//		bean.setPremiumAmount(12000);
//		bean.setExpiryDate(sdf.parse("2027-02-20"));

//	    bean.setPolicyId(4);
//	    bean.setPolicyHolderName("Neha");
//	    bean.setPolicyType("Health");
//	    bean.setPremiumAmount(6000);
//	    bean.setExpiryDate(sdf.parse("2027-03-10"));
//		
//		bean.setPolicyId(5);
//	    bean.setPolicyHolderName("Rohit");
//	    bean.setPolicyType("Life");
//	    bean.setPremiumAmount(8000);
//	    bean.setExpiryDate(sdf.parse("2027-04-25"));

//		bean.setPolicyId(6);
//	    bean.setPolicyHolderName("Sneha");
//	    bean.setPolicyType("Bike");
//	    bean.setPremiumAmount(4000);
//	    bean.setExpiryDate(sdf.parse("2027-05-15"));
//		
//		bean.setPolicyId(7);
//	    bean.setPolicyHolderName("Vikas");
//	    bean.setPolicyType("Health");
//	    bean.setPremiumAmount(5500);
//	    bean.setExpiryDate(sdf.parse("2027-06-20"));

//		bean.setPolicyId(8);
//		bean.setPolicyHolderName("Pooja");
//		bean.setPolicyType("Life");
//		bean.setPremiumAmount(9000);
//		bean.setExpiryDate(sdf.parse("2027-07-10"));

//		bean.setPolicyId(9);
//		bean.setPolicyHolderName("Karan");
//		bean.setPolicyType("Car");
//		bean.setPremiumAmount(15000);
//		bean.setExpiryDate(sdf.parse("2027-08-05"));

//		bean.setPolicyId(10);
//		bean.setPolicyHolderName("Anjali");
//		bean.setPolicyType("Health");
//		bean.setPremiumAmount(6500);
//		bean.setExpiryDate(sdf.parse("2027-09-30"));

		bean.setPolicyId(11);
		bean.setPolicyHolderName("Riya");
		bean.setPolicyType("Life");
		bean.setPremiumAmount(7500);
		bean.setExpiryDate(sdf.parse("2027-10-15"));

		model.Insert(bean);
	}

//	-----------------------------------------------Update---------------------------------------------------
	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		InsuranceBean bean = new InsuranceBean();

		bean.setPolicyId(11);
		bean.setPolicyHolderName("Rinu");
		bean.setPolicyType("Life");
		bean.setPremiumAmount(9500);
		bean.setExpiryDate(sdf.parse("2027-10-15"));

		model.Update(bean);

	}

//	----------------------------------------------Delete-----------------------------------------------------
	public static void testDelete() throws Exception {
		model.Delete(12);

	}

//	----------------------------------------------Search----------------------------------------------------

	public static void testSearch() throws Exception {

		InsuranceBean bean = new InsuranceBean();

		List<InsuranceBean> list = model.search(bean, 0, 0);

		Iterator<InsuranceBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getPolicyId());
			System.out.print("\t" + bean.getPolicyHolderName());
			System.out.print("\t" + bean.getPolicyType());
			System.out.print("\t" + bean.getPremiumAmount());
			System.out.println("\t" + bean.getExpiryDate());

		}

	}

}
