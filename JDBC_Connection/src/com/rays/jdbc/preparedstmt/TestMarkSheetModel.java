package com.rays.jdbc.preparedstmt;

import java.util.Iterator;
import java.util.List;

public class TestMarkSheetModel {
	public static void main(String[] args) throws Exception {

//		testAdd();
		testSearch();

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

//	---------------------Search-----------------------

	public static void testSearch() throws Exception {

		MarkSheetBean bean = new MarkSheetBean();
		MarkSheetModel ms = new MarkSheetModel();
		// bean.setFirstName("v");
		List<MarkSheetBean> list = ms.search(bean, 1, 10);

		Iterator<MarkSheetBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			int total = (bean.getPhy()+bean.getMaths()+bean.getChem());
			double percentage = ((bean.getPhy()+bean.getMaths()+bean.getChem())/3);
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhy());
			System.out.print("\t" + bean.getChem());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + total);
			System.out.print("\t" +percentage);
			
			
			if (bean.getPhy() < 33 || bean.getChem() < 33 || bean.getMaths() < 33) {
				System.out.println("\t" + "Fail");
			} else {
				System.out.println("\t" + "Pass");
			}
		}

	}

}
