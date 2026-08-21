package com.rays.preparedstatement.patient;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestPatientModel {

	public static PatientModel model = new PatientModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();
//		
		testSearch();
	}

//	--------------------------------------------Create-----------------------------------------

	private static void testCreate() throws Exception {
		model.create();
	}

//	--------------------------------------------Insert-----------------------------------------
	private static void testInsert() throws Exception {

		PatientBean bean = new PatientBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//		bean.setPatientId(1);
//		bean.setPatientName("Aaryanshi");
//		bean.setDisease("Asthma");
//		bean.setDoctorName("Dr. Suresh Jain");
//		bean.setAdmissionDate(sdf.parse("2026-04-01"));

//		bean.setPatientId(2);
//	    bean.setPatientName("Rahul Sharma");
//	    bean.setDisease("Diabetes");
//	    bean.setDoctorName("Dr. Anil Verma");
//	    bean.setAdmissionDate(sdf.parse("2026-04-03"));

//		bean.setPatientId(3);
//	    bean.setPatientName("Priya Patel");
//	    bean.setDisease("Fever");
//	    bean.setDoctorName("Dr. Neha Gupta");
//	    bean.setAdmissionDate(sdf.parse("2026-04-05"));

//		bean.setPatientId(4);
//	    bean.setPatientName("Rohan Mehta");
//	    bean.setDisease("Migraine");
//	    bean.setDoctorName("Dr. Rajesh Singh");
//	    bean.setAdmissionDate(sdf.parse("2026-04-07"));

//		bean.setPatientId(5);
//		bean.setPatientName("Sneha Joshi");
//		bean.setDisease("Malaria");
//		bean.setDoctorName("Dr. Pooja Sharma");
//		bean.setAdmissionDate(sdf.parse("2026-04-09"));

//		bean.setPatientId(6);
//		bean.setPatientName("Vikram Yadav");
//		bean.setDisease("Typhoid");
//		bean.setDoctorName("Dr. Amit Jain");
//		bean.setAdmissionDate(sdf.parse("2026-04-11"));

//		bean.setPatientId(7);
//	    bean.setPatientName("Ananya Singh");
//	    bean.setDisease("Pneumonia");
//	    bean.setDoctorName("Dr. Suresh Patel");
//	    bean.setAdmissionDate(sdf.parse("2026-04-13"));

//		bean.setPatientId(8);
//		bean.setPatientName("Karan Gupta");
//		bean.setDisease("Bronchitis");
//		bean.setDoctorName("Dr. Rakesh Verma");
//		bean.setAdmissionDate(sdf.parse("2026-04-15"));

//		bean.setPatientId(9);
//		bean.setPatientName("Neha Mishra");
//		bean.setDisease("Hypertension");
//		bean.setDoctorName("Dr. Sunita Jain");
//		bean.setAdmissionDate(sdf.parse("2026-04-17"));

//		bean.setPatientId(10);
//		bean.setPatientName("Arjun Malhotra");
//		bean.setDisease("Heart Disease");
//		bean.setDoctorName("Dr. Vivek Sharma");
//		bean.setAdmissionDate(sdf.parse("2026-04-19"));

		bean.setPatientId(11);
		bean.setPatientName("Pallavi Verma");
		bean.setDisease("Arthritis");
		bean.setDoctorName("Dr. Meena Gupta");
		bean.setAdmissionDate(sdf.parse("2026-04-21"));

		model.insert(bean);
	}

//	--------------------------------------------Update-----------------------------------------

	private static void testUpdate() throws Exception {
		PatientBean bean = new PatientBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setPatientId(11);
		bean.setPatientName("Piyush Verma");
		bean.setDisease("Arthritis");
		bean.setDoctorName("Dr. Harsh Pandey");
		bean.setAdmissionDate(sdf.parse("2026-04-21"));

		model.update(bean);
	}

//	--------------------------------------------Delete-----------------------------------------

	private static void testDelete() throws Exception {
		model.delete(11);
	}

//	--------------------------------------------Search-----------------------------------------

	private static void testSearch() throws Exception {

		PatientBean bean = new PatientBean();

		List<PatientBean> list = model.search(bean, 0, 0);

		Iterator<PatientBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getPatientId());
			System.out.print("\t" + bean.getPatientName());
			System.out.print("\t" + bean.getDisease());
			System.out.print("\t" + bean.getDoctorName());
			System.out.println("\t" + bean.getAdmissionDate());

		}

	}
}
