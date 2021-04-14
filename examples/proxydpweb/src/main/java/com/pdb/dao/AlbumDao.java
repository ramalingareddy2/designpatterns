package com.pdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.pdb.bo.PhotoBo;
import com.pdp.exception.GenericException;
import com.pdp.helper.ConnectionFactory;

public class AlbumDao {
	public Map<Integer, String> getAlbums() {
		Map<Integer, String> albumsMap = null;

		try (Connection con = ConnectionFactory.newConnection(); Statement stmt = con.createStatement();) {
			ResultSet rs = stmt.executeQuery("select album_no, title from album order by title asc");
			albumsMap = new HashMap<>();
			while (rs.next()) {
				albumsMap.put(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			throw new GenericException(e);
		}
		return albumsMap;
	}

	public int getFirstPhoto(int albumNo) {
		int photoNo = 0;
		ResultSet rs = null;

		try (Connection con = ConnectionFactory.newConnection();
				PreparedStatement pstmt = con
						.prepareStatement("select min(photo_no) from photos where album_no = ?");) {
			pstmt.setInt(1, albumNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				photoNo = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new GenericException(e);
		}

		return photoNo;
	}

	public int getNextPhoto(int albumNo, int cPhotoNo) {
		int photoNo = 0;
		ResultSet rs = null;

		try (Connection con = ConnectionFactory.newConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT min(photo_no) FROM dpdb.photos where album_no = ? and photo_no > ?");) {
			pstmt.setInt(1, albumNo);
			pstmt.setInt(2, cPhotoNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				photoNo = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new GenericException(e);
		}

		return photoNo;

	}
	
	public int getPreviousPhoto(int albumNo, int cPhotoNo) {
		int photoNo = 0;
		ResultSet rs = null;

		try (Connection con = ConnectionFactory.newConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT max(photo_no) FROM dpdb.photos where album_no = ? and photo_no < ?");) {
			pstmt.setInt(1, albumNo);
			pstmt.setInt(2, cPhotoNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				photoNo = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new GenericException(e);
		}

		return photoNo;

	}

	public PhotoBo getPhoto(int photoNo) {
		ResultSet rs = null;
		PhotoBo photoBo = null;

		try (Connection con = ConnectionFactory.newConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"select description, image_content,image_type from photos where photo_no = ?");) {
			pstmt.setInt(1, photoNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				photoBo = new PhotoBo(rs.getString(1), rs.getBytes(2), rs.getString(3));
			}

		} catch (SQLException e) {
			throw new GenericException(e);
		}
		return photoBo;
	}

}
