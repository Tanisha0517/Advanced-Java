package com.rays.vehicle;

public class TestVehicleModel {

	public static VehicleModel model = new VehicleModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
		testInsert();
	}

//	---------------------------------------Insert-------------------------------------------------
	private static void testCreate() throws Exception {
		model.create();
	}

//	---------------------------------------Create---------------------------------------------
	private static void testInsert() throws Exception {

		VehicleBean bean = new VehicleBean();

//		bean.setVehicleId(1L);
//		bean.setVehicleName("BMW");
//		bean.setModel("X5");
//		bean.setColor("Black");
//		bean.setPrice(5000000);

//		bean.setVehicleId(2L);
//		bean.setVehicleName("Audi");
//		bean.setModel("A4");
//		bean.setColor("White");
//		bean.setPrice(4500000);

//		bean.setVehicleId(3);
//		bean.setVehicleName("Toyota");
//		bean.setModel("Fortuner");
//		bean.setColor("Black");
//		bean.setPrice(4000000);

//		bean.setVehicleId(4);
//	    bean.setVehicleName("Honda");
//	    bean.setModel("City");
//	    bean.setColor("Red");
//	    bean.setPrice(1500000);

//		bean.setVehicleId(5);
//		bean.setVehicleName("Hyundai");
//		bean.setModel("Creta");
//		bean.setColor("Blue");
//		bean.setPrice(1800000);

//		bean.setVehicleId(6);
//	    bean.setVehicleName("Tata");
//	    bean.setModel("Nexon");
//	    bean.setColor("Grey");
//	    bean.setPrice(1400000);

		bean.setVehicleId(7L);
		bean.setVehicleName("Mahindra");
		bean.setModel("Thar");
		bean.setColor("Black");
		bean.setPrice(1700000);

		bean.setVehicleId(8L);
		bean.setVehicleName("Kia");
		bean.setModel("Seltos");
		bean.setColor("White");
		bean.setPrice(1600000);

		bean.setVehicleId(9L);
		bean.setVehicleName("Maruti");
		bean.setModel("Swift");
		bean.setColor("Red");
		bean.setPrice(900000);

		bean.setVehicleId(10L);
		bean.setVehicleName("Ford");
		bean.setModel("Endeavour");
		bean.setColor("Black");
		bean.setPrice(3500000);

		bean.setVehicleId(11L);
		bean.setVehicleName("Volkswagen");
		bean.setModel("Virtus");
		bean.setColor("Silver");
		bean.setPrice(1800000);

		model.insert(bean); // Record inserted successfully will print
	}
	
//	------------------------------------------Update----------------------------------------------------
	
//	------------------------------------------Delete----------------------------------------------------
	
//	------------------------------------------Search----------------------------------------------------
}
