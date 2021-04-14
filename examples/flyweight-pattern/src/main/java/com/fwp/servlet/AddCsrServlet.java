package com.fwp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwp.delegate.CsrDelegate;
import com.fwp.dto.CsrDto;
import com.fwp.factory.ObjectFactory;

@WebServlet(urlPatterns = "/addCsr")
public class AddCsrServlet extends HttpServlet {
	private CsrDelegate csrDelegate;

	public void init() {
		csrDelegate = ObjectFactory.getObject(CsrDelegate.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CsrDto csrDto = null;
		System.out.println("Csr Delegate : " + csrDelegate.hashCode());
		csrDto = new CsrDto();
		csrDto.setCsrNo(Integer.parseInt(req.getParameter("csrNo")));
		csrDto.setDesignation(req.getParameter("designation"));
		csrDto.setFullName(req.getParameter("fullName"));
		csrDto.setExperience(Integer.parseInt(req.getParameter("experience")));
		csrDto.setMobileNo(req.getParameter("mobileNo"));
		csrDelegate.addCsr(csrDto);

		req.getRequestDispatcher("/add-csr-success.jsp").forward(req, resp);
	}

}
