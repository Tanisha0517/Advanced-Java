package com.rays.preparedstatement.doctor;

import java.util.Iterator;
import java.util.List;

import com.rays.preparedstatement.user.UserBean;

public class TestDoctorModel {
	public static DoctorModel model = new DoctorModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();
		
		testSearch();

	}

//	--------------------------------------------Create----------------------------------------------
	private static void testCreate() throws Exception {
		model.create();
	}

//	--------------------------------------------Insert----------------------------------------------
	private static void testInsert() throws Exception {
		DoctorBean bean = new DoctorBean();

//		bean.setDoctorId(1);
//		bean.setDoctorName("Dr. Rajesh Sharma");
//		bean.setSpecialization("Cardiologist");
//		bean.setExperience(10);
//		bean.setContactNo("9876543210");

//		bean.setDoctorId(2);
//	    bean.setDoctorName("Dr. Priya Verma");
//	    bean.setSpecialization("Dermatologist");
//	    bean.setExperience(7);
//	    bean.setContactNo("9876543211");

//		bean.setDoctorId(3);
//	    bean.setDoctorName("Dr. Amit Jain");
//	    bean.setSpecialization("Neurologist");
//	    bean.setExperience(12);
//	    bean.setContactNo("9876543212");

//	    bean.setDoctorId(4);
//	    bean.setDoctorName("Dr. Neha Gupta");
//	    bean.setSpecialization("Pediatrician");
//	    bean.setExperience(6);
//	    bean.setContactNo("9876543213");
//
//		bean.setDoctorId(5);
//		bean.setDoctorName("Dr. Suresh Patel");
//		bean.setSpecialization("Orthopedic");
//		bean.setExperience(15);
//		bean.setContactNo("9876543214");

//		bean.setDoctorId(6);
//		bean.setDoctorName("Dr. Anjali Mehta");
//		bean.setSpecialization("Gynecologist");
//		bean.setExperience(9);
//		bean.setContactNo("9876543215");

//		bean.setDoctorId(7);
//	    bean.setDoctorName("Dr. Rahul Singh");
//	    bean.setSpecialization("ENT Specialist");
//	    bean.setExperience(8);
//	    bean.setContactNo("9876543216");

//		bean.setDoctorId(8);
//		bean.setDoctorName("Dr. Kavita Joshi");
//		bean.setSpecialization("Psychiatrist");
//		bean.setExperience(11);
//		bean.setContactNo("9876543217");

//		bean.setDoctorId(9);
//		bean.setDoctorName("Dr. Mohit Agarwal");
//		bean.setSpecialization("General Physician");
//		bean.setExperience(5);
//		bean.setContactNo("9876543218");

//		bean.setDoctorId(10);
//	    bean.setDoctorName("Dr. Pooja Sharma");
//	    bean.setSpecialization("Ophthalmologist");
//	    bean.setExperience(13);
//	    bean.setContactNo("9876543219");

		bean.setDoctorId(11);
		bean.setDoctorName("Dr. Vivek Choudhary");
		bean.setSpecialization("Dentist");
		bean.setExperience(10);
		bean.setContactNo("9876543220");

		model.insert(bean);
	}

//	--------------------------------------------Update-------------------------------------------------
	private static void testUpdate() throws Exception {
		DoctorBean bean = new DoctorBean();
		bean.setDoctorId(11);
		bean.setDoctorName("Dr. Vivek Choudhary");
		bean.setSpecialization("Ophthalmologist");
		bean.setExperience(10);
		bean.setContactNo("9812345678");

		model.update(bean);
	}

//	--------------------------------------------Delete-------------------------------------------------
	private static void testDelete() throws Exception {
		model.delete(11);
	}

//	--------------------------------------------Search------------------------------------------------
	public static void testSearch() throws Exception {

		DoctorBean bean = new DoctorBean();
	//	bean.setFirstName("v");
		List<DoctorBean> list = model.search(bean, 0, 0);

		Iterator<DoctorBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getDoctorId());
			System.out.print("\t" + bean.getDoctorName());
			System.out.print("\t" + bean.getSpecialization());
			System.out.print("\t" + bean.getExperience());
			System.out.println("\t" + bean.getContactNo());
			
		}

	}
}
