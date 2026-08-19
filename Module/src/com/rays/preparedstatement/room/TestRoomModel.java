package com.rays.preparedstatement.room;

import java.util.Iterator;
import java.util.List;

import com.rays.hotel.HotelBean;

public class TestRoomModel {

	public static RoomModel model = new RoomModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();

		testSearch();
	}

//	--------------------------------------------------create------------------------------------------

	private static void testCreate() throws Exception {
		model.create();
	}

//	--------------------------------------------------insert------------------------------------------
	private static void testInsert() throws Exception {
		RoomBean bean = new RoomBean();

//		bean.setRoomId(1);
//		bean.setRoomNumber("101");
//		bean.setRoomType("Single");
//		bean.setPricePerDay(1000);
//		bean.setAvailability(true);

//		bean.setRoomId(2);
//		bean.setRoomNumber("102");
//		bean.setRoomType("Double");
//		bean.setPricePerDay(1500);
//		bean.setAvailability(true);

//		bean.setRoomId(3);
//		bean.setRoomNumber("103");
//		bean.setRoomType("Single");
//		bean.setPricePerDay(1000);
//		bean.setAvailability(false);

//		bean.setRoomId(4);
//		bean.setRoomNumber("104");
//		bean.setRoomType("Double");
//		bean.setPricePerDay(1500);
//		bean.setAvailability(true);

//		bean.setRoomId(5);
//		bean.setRoomNumber("105");
//		bean.setRoomType("Suite");
//		bean.setPricePerDay(2500);
//		bean.setAvailability(true);

//		bean.setRoomId(6);
//		bean.setRoomNumber("106");
//		bean.setRoomType("Single");
//		bean.setPricePerDay(1100);
//		bean.setAvailability(false);

//		bean.setRoomId(7);
//		bean.setRoomNumber("107");
//		bean.setRoomType("Double");
//		bean.setPricePerDay(1600);
//		bean.setAvailability(true);

//		bean.setRoomId(8);
//		bean.setRoomNumber("108");
//		bean.setRoomType("Suite");
//		bean.setPricePerDay(3000);
//		bean.setAvailability(true);

//		bean.setRoomId(9);
//		bean.setRoomNumber("109");
//		bean.setRoomType("Single");
//		bean.setPricePerDay(1200);
//		bean.setAvailability(false);

//		bean.setRoomId(10);
//		bean.setRoomNumber("110");
//		bean.setRoomType("Double");
//		bean.setPricePerDay(1700);
//		bean.setAvailability(true);

		bean.setRoomId(11);
		bean.setRoomNumber("111");
		bean.setRoomType("Suite");
		bean.setPricePerDay(2800);
		bean.setAvailability(true);

		model.insert(bean);
	}

//	--------------------------------------------------update------------------------------------------

	private static void testUpdate() throws Exception {
		RoomBean bean = new RoomBean();

		bean.setRoomId(11);
		bean.setRoomNumber("112");
		bean.setRoomType("Double");
		bean.setPricePerDay(1800);
		bean.setAvailability(true);
		model.update(bean);
	}

//	--------------------------------------------------delete------------------------------------------
	private static void testDelete() throws Exception {
		model.delete(11);
	}

//	--------------------------------------------------search------------------------------------------
	private static void testSearch() throws Exception {

		RoomBean bean = new RoomBean();

		List<RoomBean> list = model.search(bean, 0, 0);

		Iterator<RoomBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getRoomId());
			System.out.print("\t" + bean.getRoomNumber());
			System.out.print("\t" + bean.getRoomType());
			System.out.print("\t" + bean.getPricePerDay());
			System.out.println("\t" + bean.getAvailability());

		}

	}
}
