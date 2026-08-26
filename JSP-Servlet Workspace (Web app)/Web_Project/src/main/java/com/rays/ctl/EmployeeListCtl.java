package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.EmployeeBean;
import com.rays.model.EmployeeModel;
import com.rays.util.ServletUtility;

/**
 * Servlet implementation class EmployeeListCtl
 */
@WebServlet("/EmployeeListCtl")
public class EmployeeListCtl extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeModel model = new EmployeeModel();
		EmployeeBean bean = new EmployeeBean();

		try {
			List<EmployeeBean> list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("EmployeeListView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
