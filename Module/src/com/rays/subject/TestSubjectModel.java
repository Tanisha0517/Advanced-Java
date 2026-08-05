package com.rays.subject;

import java.util.Iterator;
import java.util.List;

public class TestSubjectModel {
	
	public static SubjectModel sm = new SubjectModel();


	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();
		
//		testFindByPk();
		testSearch();
	}



	



	//	--------------------------------------Create--------------------------------------------
	public static void testCreate() throws Exception {
		SubjectModel sm = new SubjectModel();

		sm.create();

	}

//	--------------------------------------Insert--------------------------------------------
	public static void testInsert() throws Exception {
//		SubjectModel sm = new SubjectModel();
		SubjectBean bean = new SubjectBean();

		bean.setSubjectId(110);
		bean.setSubjectName(" GenAI ");
		bean.setSubjectCode("BTCS110");
		bean.setCredits(4);
		bean.setSemester(6);

		sm.insert(bean);

//		System.out.println("data Add succ");
	}

//	--------------------------------------Update--------------------------------------------
	public static void testUpdate() throws Exception {

//		SubjectModel sm = new SubjectModel();
		SubjectBean bean = new SubjectBean();

		bean.setSubjectId(102);
		bean.setSubjectName("Python");

		sm.update(bean);
	}

//	--------------------------------------Delete--------------------------------------------
	public static void testDelete() throws Exception {
//		SubjectModel sm = new SubjectModel();
		sm.delete(103);
	}

//    ----------------------------------SearchQuery = FindByPK------------------------------
	public static void testFindByPk() throws Exception {
//		SubjectModel sm = new SubjectModel();
		SubjectBean bean = new SubjectBean();

		bean = sm.findByPk(102);

		if (bean != null) {
			System.out.print(bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getSubjectCode());
			System.out.print("\t" + bean.getCredits());
			System.out.print("\t" + bean.getSemester());

		} else {
			throw new RuntimeException("record not found");
		}
	}
		
//		---------------------------Search Query = FindBySearch------------------------------------------

	public static void testSearch() throws Exception {
//		SubjectModel sm = new SubjectModel();
		SubjectBean bean = new SubjectBean();
		//	bean.setFirstName("v");
			List<SubjectBean> list = sm.Search(bean, 1, 5);

			Iterator<SubjectBean> it = list.iterator();

			while (it.hasNext()) {
				bean = it.next();
				System.out.print(bean.getSubjectId());
				System.out.print("\t" + bean.getSubjectName());
				System.out.print("\t" + bean.getSubjectCode());
				System.out.print("\t" + bean.getCredits());
				System.out.println("\t" + bean.getSemester());
				
			}

	}

	

}
