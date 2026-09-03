package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.DoctorBean;
import com.rays.bean.UserBean;
import com.rays.model.DoctorModel;
import com.rays.model.UserModel;
import com.rays.util.ServletUtility;

@WebServlet("/DoctorListCtl.do")
public class DoctorListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DoctorModel model = new DoctorModel();
		DoctorBean bean = new DoctorBean();
		int pageNo = 1;
		int pageSize = 5;

		try {
			List<DoctorBean> list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("DoctorListView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DoctorModel model = new DoctorModel();
		DoctorBean bean = new DoctorBean();
		int pageNo = 1;
		int pageSize = 5;

		String op = request.getParameter("operation");
		String[] ids = request.getParameterValues("ids");

		if (op.equals("delete")) {
			if (ids != null && ids.length > 0) {

				for (String id : ids) {
					try {
						model.delete(Integer.parseInt(id));
						request.setAttribute("successMsg", "record deleted successfully");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else {
				request.setAttribute("errorMsg", "select at least one record to delete");
			}
		}

		if (op.equals("search")) {
			bean.setDoctorId(request.getParameter("doctorId"));
			bean.setDoctorName(request.getParameter("doctorName"));
		}

		if (op.equals("previous")) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageNo--;
		}

		if (op.equals("next")) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageNo++;
		}

		try {
			List<DoctorBean> list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("DoctorListView.jsp", request, response);

	}

}
