package com.rays.scholarship;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestScholarshipModel {

	public static ScholarshipModel model = new ScholarshipModel();

	public static void main(String[] args) throws Exception {
//	  testCreate();
//	  testInsert();
//	  testUpdate();
//	  testDelete();

	  testSearch();
	}

//	-----------------Create---------------------------
	private static void testCreate() throws Exception {
		model.Create();
	}

//	-----------------Insert---------------------------
	private static void testInsert() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ScholarshipBean bean = new ScholarshipBean();
//
//		bean.setScholarshiId(1);
//		bean.setScholarshipName("Central Sector Scholarship");
//		bean.setAmount(20000);
//		bean.setEligibility("Merit Based");
//		bean.setLastDate(sdf.parse("2026-09-30"));

//		bean.setScholarshiId(2);
//		bean.setScholarshipName("Post Matric Scholarship");
//		bean.setAmount(15000);
//		bean.setEligibility("SC/ST Students");
//		bean.setLastDate(sdf.parse("2026-10-15"));

//		bean.setScholarshiId(3);
//	    bean.setScholarshipName("National Scholarship");
//	    bean.setAmount(25000);
//	    bean.setEligibility("Merit and Income Based");
//	    bean.setLastDate(sdf.parse("2026-09-20"));

//		bean.setScholarshiId(4);
//		bean.setScholarshipName("State Government Scholarship");
//		bean.setAmount(18000);
//		bean.setEligibility("State Domicile Students");
//		bean.setLastDate(sdf.parse("2026-10-10"));

//		bean.setScholarshiId(5);
//	    bean.setScholarshipName("Minority Scholarship");
//	    bean.setAmount(22000);
//	    bean.setEligibility("Minority Students");
//	    bean.setLastDate(sdf.parse("2026-11-05"));/

//		bean.setScholarshiId(6);
//		bean.setScholarshipName("Girl Child Scholarship");
//		bean.setAmount(30000);
//		bean.setEligibility("Female Students");
//		bean.setLastDate(sdf.parse("2026-09-25"));

//		bean.setScholarshiId(7);
//	    bean.setScholarshipName("Merit Scholarship");
//	    bean.setAmount(35000);
//	    bean.setEligibility("Students with 80% or above");
//	    bean.setLastDate(sdf.parse("2026-10-20"));
//		
//		bean.setScholarshiId(8);
//		bean.setScholarshipName("Post Graduate Scholarship");
//		bean.setAmount(40000);
//		bean.setEligibility("PG Students");
//		bean.setLastDate(sdf.parse("2026-11-15"));

//		bean.setScholarshiId(9);
//		bean.setScholarshipName("Sports Scholarship");
//		bean.setAmount(25000);
//		bean.setEligibility("Sports Achievers");
//		bean.setLastDate(sdf.parse("2026-10-05"));
//
//		bean.setScholarshiId(10);
//		bean.setScholarshipName("Research Scholarship");
//		bean.setAmount(50000);
//		bean.setEligibility("Research Students");
//		bean.setLastDate(sdf.parse("2026-12-01"));

		bean.setScholarshiId(11);
		bean.setScholarshipName("Economic Support Scholarship");
		bean.setAmount(30000);
		bean.setEligibility("Low Income Students");
		bean.setLastDate(sdf.parse("2026-11-25"));

		model.Insert(bean);

	}
	
//	-----------------------------------------Update----------------------------------------
	
	private static void testUpdate() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ScholarshipBean bean = new ScholarshipBean();
		
		bean.setScholarshiId(11);
		bean.setScholarshipName("Economic Support Scholarship");
		bean.setAmount(40000);
		bean.setEligibility("Sports Achievers");
		bean.setLastDate(sdf.parse("2026-11-25"));
		
		model.Update(bean);
	}
	
//	-----------------------------------------Delete----------------------------------------
	
	private static void testDelete() throws Exception{
		model.Delete(11);
	}
	
//	-----------------------------------------Search----------------------------------------
	
	public static void testSearch() throws Exception {

		ScholarshipBean bean = new ScholarshipBean();
	//	bean.setFirstName("v");
		List<ScholarshipBean> list = model.search(bean, 0, 0);

		Iterator<ScholarshipBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getScholarshiId());
			System.out.print("\t" + bean.getScholarshipName());
			System.out.print("\t" + bean.getAmount());
			System.out.print("\t" + bean.getEligibility());
			System.out.println("\t" + bean.getLastDate());
			
		}
	}

}
