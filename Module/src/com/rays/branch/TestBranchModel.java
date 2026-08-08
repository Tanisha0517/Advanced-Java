package com.rays.branch;

import java.util.Iterator;
import java.util.List;

public class TestBranchModel {

	public static BranchModel model = new BranchModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();

		testSearch();
	}

//	-----------------------------------------------Create-------------------------------------------
	private static void testCreate() throws Exception {
		model.Create();
	}

//	-----------------------------------------------Insert-------------------------------------------
	private static void testInsert() throws Exception {
		BranchBean bean = new BranchBean();

//		bean.setBranchId(1);
//		bean.setBranchName("Vijay Nagar Branch");
//		bean.setCity("Indore");
//		bean.setManagerName("Rahul Sharma");
//		bean.setContactNo("9876545782");
//		

//	    bean.setBranchId(2);
//	    bean.setBranchName("Palasia Branch");
//	    bean.setCity("Indore");
//	    bean.setManagerName("Amit Verma");
//	    bean.setContactNo("9876543211");

//		bean.setBranchId(3);
//		bean.setBranchName("Bhopal Main Branch");
//		bean.setCity("Bhopal");
//		bean.setManagerName("Rohit Singh");
//		bean.setContactNo("9876543212");

//		bean.setBranchId(4);
//		bean.setBranchName("Gwalior Branch");
//		bean.setCity("Gwalior");
//		bean.setManagerName("Neeraj Gupta");
//		bean.setContactNo("9876543213");

//		bean.setBranchId(5);
//	    bean.setBranchName("Jabalpur Branch");
//	    bean.setCity("Jabalpur");
//	    bean.setManagerName("Suresh Patel");
//	    bean.setContactNo("9876543214");

//		bean.setBranchId(6);
//	    bean.setBranchName("Ujjain Branch");
//	    bean.setCity("Ujjain");
//	    bean.setManagerName("Vikas Jain");
//	    bean.setContactNo("9876543215");

//		bean.setBranchId(7);
//	    bean.setBranchName("Dewas Branch");
//	    bean.setCity("Dewas");
//	    bean.setManagerName("Ankit Mehta");
//	    bean.setContactNo("9876543216");

//		bean.setBranchId(8);
//	    bean.setBranchName("Ratlam Branch");
//	    bean.setCity("Ratlam");
//	    bean.setManagerName("Manish Yadav");
//	    bean.setContactNo("9876543217");

//		bean.setBranchId(9);
//		bean.setBranchName("Indore Central Branch");
//		bean.setCity("Indore");
//		bean.setManagerName("Karan Malhotra");
//		bean.setContactNo("9876543218");

//		bean.setBranchId(10);
//	    bean.setBranchName("Bhopal City Branch");
//	    bean.setCity("Bhopal");
//	    bean.setManagerName("Nitin Joshi");
//	    bean.setContactNo("9876543219");

		bean.setBranchId(11);
		bean.setBranchName("Indore Airport Branch");
		bean.setCity("Indore");
		bean.setManagerName("Rakesh Sharma");
		bean.setContactNo("9876543220");

		model.Insert(bean);
	}

//	-----------------------------------------------Update-------------------------------------------
	private static void testUpdate() throws Exception {
		BranchBean bean = new BranchBean();

		bean.setBranchId(11);
		bean.setBranchName("Indore Airport Branch");
		bean.setCity("Pune");
		bean.setManagerName("Usha Sharma");
		bean.setContactNo("9876543221");

		model.Update(bean);

	}

//	-----------------------------------------------Delete-------------------------------------------
	private static void testDelete() throws Exception {
		model.Delete(11);
	}

//	----------------------------------------------Search-------------------------------------------
	public static void testSearch() throws Exception {

		BranchBean bean = new BranchBean();

		List<BranchBean> list = model.search(bean, 0, 0);

		Iterator<BranchBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getBranchId());
			System.out.print("\t" + bean.getBranchName());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getManagerName());
			System.out.println("\t" + bean.getContactNo());

		}
	}
}
