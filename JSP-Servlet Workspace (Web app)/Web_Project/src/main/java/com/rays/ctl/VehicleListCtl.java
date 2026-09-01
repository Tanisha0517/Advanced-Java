package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.VehicleBean;
import com.rays.model.VehicleModel;
import com.rays.util.ServletUtility;

@WebServlet("/VehicleListCtl")
public class VehicleListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VehicleModel model = new VehicleModel();
		VehicleBean bean = new VehicleBean();

		try {
			List<VehicleBean> list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("VehicleListView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
