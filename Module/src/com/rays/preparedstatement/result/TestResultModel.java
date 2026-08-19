package com.rays.preparedstatement.result;

public class TestResultModel {
	public static void main(String[] args) throws Exception {
		testAdd();
//		testCreate();
//		testUpdate();
//		testDelete();
	}

	public static void testDelete() throws Exception {
		ResultModel ms = new ResultModel();

		ms.delete(2);

	}

	public static void testUpdate() throws Exception {
		ResultModel ms = new ResultModel();

		ResultBean bean = new ResultBean();

		bean.setResultId(1);
		bean.setStudentId(2);
		bean.setPercentage(85);
		bean.setGrade("A");
		bean.setResultStatus("Pass");

		ms.update(bean);

	}

	public static void testCreate() throws Exception {
		ResultModel ms = new ResultModel();

		ms.create();
	}

	public static void testAdd() throws Exception {

		ResultModel ms = new ResultModel();

		ResultBean bean = new ResultBean();

		bean.setResultId(5);
		bean.setStudentId(6);
		bean.setPercentage(83);
		bean.setGrade("B");
		bean.setResultStatus("Pass");

		ms.add(bean);
		System.out.println("data Add succ");
	}

}
