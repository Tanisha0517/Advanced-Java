package com.rays.hotel;

import java.util.Iterator;
import java.util.List;

import com.rays.preparedstatement.bankaccount.BankAccountBean;

public class TestHotelModel {

	public static HotelModel model = new HotelModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();
//		
		testSearch();
	}

	private static void testCreate() throws Exception {
		model.create();
	}

	private static void testInsert() throws Exception {
		HotelBean bean = new HotelBean();

//		bean.setHotelId(1);
//		bean.setHotelName("Taj Palace");
//		bean.setLocation("Delhi");
//		bean.setRating(5);
//		bean.setContactNo("9876543210");
//		model.insert(bean);

//		bean.setHotelId(2);
//		bean.setHotelName("The Oberoi");
//		bean.setLocation("Mumbai");
//		bean.setRating(5);
//		bean.setContactNo("9876543211");

//		bean.setHotelId(3);
//		bean.setHotelName("ITC Grand");
//		bean.setLocation("Bangalore");
//		bean.setRating(4);
//		bean.setContactNo("9876543212");
//
//		bean.setHotelId(4);
//		bean.setHotelName("Radisson Blu");
//		bean.setLocation("Pune");
//		bean.setRating(4);
//		bean.setContactNo("9876543213");

//		bean.setHotelId(5);
//	    bean.setHotelName("Hyatt Regency");
//	    bean.setLocation("Hyderabad");
//	    bean.setRating(5);
//	    bean.setContactNo("9876543214");

//		bean.setHotelId(6);
//		bean.setHotelName("Lemon Tree Hotel");
//		bean.setLocation("Indore");
//		bean.setRating(4);
//		bean.setContactNo("9876543215");

//		bean.setHotelId(7);
//		bean.setHotelName("Marriott Hotel");
//		bean.setLocation("Jaipur");
//		bean.setRating(5);
//		bean.setContactNo("9876543216");

//		bean.setHotelId(8);
//		bean.setHotelName("Holiday Inn");
//		bean.setLocation("Chennai");
//		bean.setRating(4);
//		bean.setContactNo("9876543217");

//		bean.setHotelId(9);
//		bean.setHotelName("Hotel Surya");
//		bean.setLocation("Bhopal");
//		bean.setRating(3);
//		bean.setContactNo("9876543218");

//		bean.setHotelId(10);
//		bean.setHotelName("The Lalit");
//		bean.setLocation("Kolkata");
//		bean.setRating(5);
//		bean.setContactNo("9876543219");

		bean.setHotelId(11);
		bean.setHotelName("Hotel Paradise");
		bean.setLocation("Udaipur");
		bean.setRating(3);
		bean.setContactNo("9876543220");

		model.insert(bean);

	}

	private static void testUpdate() throws Exception {

		HotelBean bean = new HotelBean();
		bean.setHotelId(11);
		bean.setHotelName("Hotel Royal Orchid");
		bean.setLocation("Ahmedabad");
		bean.setRating(4);
		bean.setContactNo("9876543221");

		model.update(bean);
	}

	private static void testDelete() throws Exception {
		model.delete(11);

	}

	private static void testSearch() throws Exception {

		HotelBean bean = new HotelBean();

		List<HotelBean> list = model.search(bean, 0, 0);

		Iterator<HotelBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getHotelId());
			System.out.print("\t" + bean.getHotelName());
			System.out.print("\t" + bean.getLocation());
			System.out.print("\t" + bean.getRating());
			System.out.println("\t" + bean.getContactNo());

		}

	}

}
