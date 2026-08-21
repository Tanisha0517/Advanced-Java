package com.rays.preparedstatement.library;

import java.util.Iterator;
import java.util.List;

import com.rays.preparedstatement.course.CourseBean;

public class TestLibraryModel {

	public static LibraryModel model = new LibraryModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();

		testSearch();
	}

//	------------------------------------------create--------------------------------------------
	private static void testCreate() throws Exception {
		model.create();
	}

//	------------------------------------------insert--------------------------------------------
	private static void testInsert() throws Exception {
		LibraryBean bean = new LibraryBean();

//		bean.setLibraryId(1);
//		bean.setLibraryName("Central Library");
//		bean.setAddress("Indore");
//		bean.setTotalBooks(500);
//		bean.setContactNo("9876543210");

//		bean.setLibraryId(2);
//		bean.setLibraryName("City Library");
//		bean.setAddress("Bhopal");
//		bean.setTotalBooks(300);
//		bean.setContactNo("9876543211");

//		bean.setLibraryId(3);
//		bean.setLibraryName("Knowledge Library");
//		bean.setAddress("Ujjain");
//		bean.setTotalBooks(450);
//		bean.setContactNo("9876543212");

//		bean.setLibraryId(4);
//		bean.setLibraryName("Public Library");
//		bean.setAddress("Dewas");
//		bean.setTotalBooks(250);
//		bean.setContactNo("9876543213");

//		bean.setLibraryId(5);
//		bean.setLibraryName("Readers Library");
//		bean.setAddress("Indore");
//		bean.setTotalBooks(350);
//		bean.setContactNo("9876543214");

//		bean.setLibraryId(6);
//		bean.setLibraryName("Modern Library");
//		bean.setAddress("Bhopal");
//		bean.setTotalBooks(400);
//		bean.setContactNo("9876543215");

//		bean.setLibraryId(7);
//		bean.setLibraryName("National Library");
//		bean.setAddress("Jabalpur");
//		bean.setTotalBooks(600);
//		bean.setContactNo("9876543216");

//		bean.setLibraryId(8);
//		bean.setLibraryName("City Readers");
//		bean.setAddress("Gwalior");
//		bean.setTotalBooks(275);
//		bean.setContactNo("9876543217");

//		bean.setLibraryId(9);
//		bean.setLibraryName("Study Library");
//		bean.setAddress("Indore");
//		bean.setTotalBooks(325);
//		bean.setContactNo("9876543218");

//		bean.setLibraryId(10);
//		bean.setLibraryName("Digital Library");
//		bean.setAddress("Bhopal");
//		bean.setTotalBooks(550);
//		bean.setContactNo("9876543219");

		bean.setLibraryId(11);
		bean.setLibraryName("Smart Library");
		bean.setAddress("Ujjain");
		bean.setTotalBooks(375);
		bean.setContactNo("9876543220");
		model.insert(bean);
	}

//	------------------------------------------update--------------------------------------------
	private static void testUpdate() throws Exception {
		LibraryBean bean = new LibraryBean();

		bean.setLibraryId(11);
		bean.setLibraryName("Knowledge Hub");
		bean.setAddress("Indore");
		bean.setTotalBooks(425);
		bean.setContactNo("9876543221");
		model.update(bean);
	}

//	------------------------------------------delete--------------------------------------------
	private static void testDelete() throws Exception {
		model.delete(11);
	}

//	------------------------------------------search--------------------------------------------
	public static void testSearch() throws Exception {

		LibraryBean bean = new LibraryBean();

		List<LibraryBean> list = model.search(bean, 0, 0);

		Iterator<LibraryBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getLibraryId());
			System.out.print("\t" + bean.getLibraryName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getTotalBooks());
			System.out.println("\t" + bean.getContactNo());

		}

	}
}
