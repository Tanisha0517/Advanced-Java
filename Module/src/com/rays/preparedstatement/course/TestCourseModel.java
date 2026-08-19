package com.rays.preparedstatement.course;

import java.util.Iterator;
import java.util.List;

import com.rays.preparedstatement.room.RoomBean;

public class TestCourseModel {

	public static CourseModel model = new CourseModel();

	public static void main(String[] args) throws Exception {
//        testCreate();
//		testInsert();
//        testUpdate();
//		testDelete();
//        
        testSearch();
	}

	private static void testCreate() throws Exception {
		model.create();
	}

	private static void testInsert() throws Exception {
		CourseBean bean = new CourseBean();

//		bean.setCourseId(1);
//		bean.setCourseName("Java");
//		bean.setDuration("6 Months");
//		bean.setFees(25000);
//		bean.setTrainerName("Raj Sharma");

//		bean.setCourseId(2);
//		bean.setCourseName("Python");
//		bean.setDuration("6 Months");
//		bean.setFees(22000);
//		bean.setTrainerName("Amit Sharma");

//		bean.setCourseId(3);
//		bean.setCourseName("C++");
//		bean.setDuration("4 Months");
//		bean.setFees(18000);
//		bean.setTrainerName("Neha Singh");

//		bean.setCourseId(4);
//		bean.setCourseName("JavaScript");
//		bean.setDuration("4 Months");
//		bean.setFees(20000);
//		bean.setTrainerName("Rahul Verma");

//		bean.setCourseId(5);
//		bean.setCourseName("React");
//		bean.setDuration("3 Months");
//		bean.setFees(18000);
//		bean.setTrainerName("Priya Sharma");

//		bean.setCourseId(6);
//		bean.setCourseName("Spring Boot");
//		bean.setDuration("5 Months");
//		bean.setFees(28000);
//		bean.setTrainerName("Vikas Patel");

//		bean.setCourseId(7);
//		bean.setCourseName("SQL");
//		bean.setDuration("3 Months");
//		bean.setFees(15000);
//		bean.setTrainerName("Pooja Jain");

//		bean.setCourseId(8);
//		bean.setCourseName("HTML CSS");
//		bean.setDuration("2 Months");
//		bean.setFees(10000);
//		bean.setTrainerName("Ravi Kumar");

//		bean.setCourseId(9);
//		bean.setCourseName("MERN Stack");
//		bean.setDuration("6 Months");
//		bean.setFees(30000);
//		bean.setTrainerName("Ankit Gupta");

//		bean.setCourseId(10);
//		bean.setCourseName("Data Science");
//		bean.setDuration("8 Months");
//		bean.setFees(35000);
//		bean.setTrainerName("SFneha Mehta");

		bean.setCourseId(11);
		bean.setCourseName("Machine Learning");
		bean.setDuration("6 Months");
		bean.setFees(32000);
		bean.setTrainerName("Arjun Singh");

		model.insert(bean);
	}

	public static void testUpdate() throws Exception {
		CourseBean bean = new CourseBean();

		bean.setCourseId(11);
		bean.setCourseName("AWS");
		bean.setDuration("4 Months");
		bean.setFees(27000);
		bean.setTrainerName("Karan Patel");

		model.update(bean);
	}

	public static void testDelete() throws Exception {
		model.delete(11);
	}

	public static void testSearch() throws Exception {

		CourseBean bean = new CourseBean();

		List<CourseBean> list = model.search(bean, 0, 0);

		Iterator<CourseBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getFees());
			System.out.println("\t" + bean.getTrainerName());

		}

	}
}
