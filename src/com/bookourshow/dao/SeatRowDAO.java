package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.util.ConnectionUtil;

public class SeatRowDAO {

	public SeatRowDAO() {
		// TODO Auto-generated constructor stub
	}

	public int getRowId(String rowName) throws BookOurShowException {
		int rowId = 0;
		String query = "select * from seat_row where row_code=?;";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection connObj = null;
		try {
			connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			pstmt = connObj.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, rowName);
			result = pstmt.executeQuery();
			while (result.next()) {
				rowId = result.getInt("row_id");
			}
			connObj.commit();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new BookOurShowException("SQL EXCEPTION");
				// e1.printStackTrace();
			}
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connObj != null) {
					connObj.close();
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new BookOurShowException("SQL EXCEPTION");
				// e1.printStackTrace();
			}
		}
		return rowId;
	}

}
