package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.PatientBean;
import com.rays.model.PatientModel;
import com.rays.util.ServletUtility;

@WebServlet("/PatientListCtl.do")
public class PatientListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PatientModel model = new PatientModel();
		PatientBean bean = new PatientBean();
		int pageNo = 1;
		int pageSize = 5;

		try {
			List<PatientBean> list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("PatientListView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PatientModel model = new PatientModel();
		PatientBean bean = new PatientBean();
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
			bean.setPatientId(request.getParameter("patientId"));
			bean.setDisease(request.getParameter("disease"));
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
			List<PatientBean> list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("PatientListView.jsp", request, response);

	}

}
