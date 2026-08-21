package com.rays.preparedstatement.exam;

import java.text.SimpleDateFormat;

public class TestExamModelPreparedStmt {
	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
		testDelete();
	}

	public static void testCreate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ExamModelPreparedStatement model = new ExamModelPreparedStatement();

		model.create();

	}

//	-------------------------------------------------------------------------

	public static void testInsert() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ExamModelPreparedStatement model = new ExamModelPreparedStatement();

		model.insert(8, "Java Programming", sdf.parse("2002-04-09"), 90, 30);
		model.insert(1, "Python Programming", sdf.parse("2002-04-10"), 80, 30);
		model.insert(2, "OOPS", sdf.parse("2002-04-11"), 90, 30);
		model.insert(3, "OPerating System", sdf.parse("2002-04-12"), 85, 30);
		model.insert(4, "PHP", sdf.parse("2002-04-13"), 95, 30);
		model.insert(5, "C#", sdf.parse("2002-04-14"), 92, 30);

	}
//	-----------------------------------------------------------------------
	
	public static void testUpdate() throws Exception {

	
		ExamModelPreparedStatement model = new ExamModelPreparedStatement();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		model.update(8,"Web Technlogies", sdf.parse("2002-04-19"), 98, 30);

	}
	
//	----------------------------------------------------------------------
	
	public static void testDelete() throws Exception {

		ExamModelPreparedStatement model = new ExamModelPreparedStatement();

		model.delete(8);

	}
}
