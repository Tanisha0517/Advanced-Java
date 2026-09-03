package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.PatientBean;
import com.rays.model.PatientModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/AddPatientCtl.do")
public class AddPatientCtl extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.patientValidator(request) == false) {
				ServletUtility.forward("AddPatientView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PatientBean bean = new PatientBean();
		PatientModel model = new PatientModel();
		String id = request.getParameter("id");

		if (id != null) {
			try {
				bean = model.findByPk(Integer.parseInt(id));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ServletUtility.forward("AddPatientView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		PatientBean bean = new PatientBean();
		PatientModel model = new PatientModel();
		String op = request.getParameter("operation");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String patientId = request.getParameter("patientId");
		String patientName = request.getParameter("patientName");
		String disease = request.getParameter("disease");
		String doctorName = request.getParameter("doctorName");
		String admissionDate = request.getParameter("admissionDate");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setPatientId(patientId);
			bean.setPatientName(patientName);
			bean.setDisease(disease);
			bean.setDoctorName(doctorName);
			bean.setAdmissionDate(sdf.parse(admissionDate));

			if (op.equals("save")) {
				model.add(bean);
				request.setAttribute("successMsg", "Patient saved successfully");
			} else if (op.equals("update")) {
				bean.setId(Integer.parseInt(request.getParameter("id")));
				model.update(bean);
				request.setAttribute("successMsg", "Patient updated successfully");
			}

		} catch (Exception e) {
			request.setAttribute("errorMsg", "PatientId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("AddPatientView.jsp", request, response);

	}
}
