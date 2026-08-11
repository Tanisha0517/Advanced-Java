package com.rays.user;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

//------
	public static UserModel model = new UserModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testAdd();
//	testUpdate();
//	testDelete();
//	testFindByPk();
		testSearch();
	}

	private static void testCreate() throws Exception {
		model.create();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

//		bean.setId(1);
//		bean.setFirstName("Ayan");
//		bean.setLastName("Choudhary");
//		bean.setLoginId("ayan123@gmail.com");
//		bean.setPassword("ayan123");
//		bean.setDob(sdf.parse("2004-10-09"));

//		 bean.setId(2);
//		    bean.setFirstName("Rahul");
//		    bean.setLastName("Sharma");
//		    bean.setLoginId("rahul123@gmail.com");
//		    bean.setPassword("rahul123");
//		    bean.setDob(sdf.parse("2003-05-15"));

//		bean.setId(3);
//	    bean.setFirstName("Priya");
//	    bean.setLastName("Verma");
//	    bean.setLoginId("priya123@gmail.com");
//	    bean.setPassword("priya123");
//	    bean.setDob(sdf.parse("2004-02-20"));

//		 bean.setId(4);
//		    bean.setFirstName("Rohit");
//		    bean.setLastName("Patel");
//		    bean.setLoginId("rohit123@gmail.com");
//		    bean.setPassword("rohit123");
//		    bean.setDob(sdf.parse("2002-11-10"));

//		 bean.setId(5);
//		    bean.setFirstName("Sneha");
//		    bean.setLastName("Jain");
//		    bean.setLoginId("sneha123@gmail.com");
//		    bean.setPassword("sneha123");
//		    bean.setDob(sdf.parse("2005-07-25"));

//		 bean.setId(6);
//		    bean.setFirstName("Arjun");
//		    bean.setLastName("Singh");
//		    bean.setLoginId("arjun123@gmail.com");
//		    bean.setPassword("arjun123");
//		    bean.setDob(sdf.parse("2003-09-18"));

//		  bean.setId(7);
//		    bean.setFirstName("Neha");
//		    bean.setLastName("Gupta");
//		    bean.setLoginId("neha123@gmail.com");
//		    bean.setPassword("neha123");
//		    bean.setDob(sdf.parse("2004-12-05"));

//		 bean.setId(8);
//		    bean.setFirstName("Vivek");
//		    bean.setLastName("Mehta");
//		    bean.setLoginId("vivek123@gmail.com");
//		    bean.setPassword("vivek123");
//		    bean.setDob(sdf.parse("2002-06-14"));

//		 bean.setId(9);
//		    bean.setFirstName("Anjali");
//		    bean.setLastName("Mishra");
//		    bean.setLoginId("anjali123@gmail.com");
//		    bean.setPassword("anjali123");
//		    bean.setDob(sdf.parse("2005-03-30"));

//		bean.setId(10);
//	    bean.setFirstName("Karan");
//	    bean.setLastName("Malhotra");
//	    bean.setLoginId("karan123@gmail.com");
//	    bean.setPassword("karan123");
//	    bean.setDob(sdf.parse("2003-08-22"));

		bean.setId(11);
		bean.setFirstName("Pooja");
		bean.setLastName("Shah");
		bean.setLoginId("pooja123@gmail.com");
		bean.setPassword("pooja123");
		bean.setDob(sdf.parse("2004-01-12"));

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		bean.setId(11);
		bean.setFirstName("Ajay");
		bean.setLastName("Singh ");
		bean.setLoginId("ayan@gmail.com");
		bean.setPassword("ayan123");
		bean.setDob(sdf.parse("2004-10-09"));

		model.update(bean);

	}

	public static void testDelete() throws Exception {

		model.delete(11);

	}

	public static void testFindByPk() throws Exception {

		UserBean bean = new UserBean();

		bean = model.findByPk(10);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		} else {
			throw new RuntimeException("record not found");
		}

	}

	public static void testSearch() throws Exception {

		UserBean bean = new UserBean();
//	bean.setFirstName("v");
		List<UserBean> list = model.search(bean, 1, 5);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		}
	}

}
