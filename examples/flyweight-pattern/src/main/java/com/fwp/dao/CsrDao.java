package com.fwp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fwp.bo.CsrBo;
import com.fwp.exception.GenericException;
import com.fwp.factory.ConnectionFactory;

public class CsrDao {
	public void saveCsr(CsrBo csrBo) {
		boolean flag = false;
		System.out.println("CsrDao : " + this.hashCode());
		try (Connection con = ConnectionFactory.newConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into csr(csr_no, fullname, experience, designation, mobile_no) values(?,?,?,?,?)");) {
			try {
				pstmt.setInt(1, csrBo.getCsrNo());
				pstmt.setString(2, csrBo.getFullName());
				pstmt.setInt(3, csrBo.getExperience());
				pstmt.setString(4, csrBo.getDesignation());
				pstmt.setString(5, csrBo.getMobileNo());

				pstmt.executeUpdate();
				flag = true;
			} finally {
				if (con != null) {
					if (flag) {
						con.commit();
					} else {
						con.rollback();
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericException("unable to open connection or statement", e);
		}
	}
}
