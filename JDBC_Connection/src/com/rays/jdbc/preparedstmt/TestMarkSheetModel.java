package com.rays.jdbc.preparedstmt;

public class TestMarkSheetModel {
	public static void main(String[] args) throws Exception {

		testAdd();

	}

	private static void testAdd() throws Exception {

		MarkSheetModel ms = new MarkSheetModel();

		MarkSheetBean bean = new MarkSheetBean();

		bean.setId(11);
		bean.setName("Aadi");
		bean.setRollno(111);
		bean.setPhy(90);
		bean.setChem(91);
		bean.setMaths(85);
		
		

		ms.add(bean);
	}
}
