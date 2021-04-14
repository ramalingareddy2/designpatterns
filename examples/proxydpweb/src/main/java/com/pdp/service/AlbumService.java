package com.pdp.service;

import java.util.Map;

import com.pdb.bo.PhotoBo;
import com.pdb.dao.AlbumDao;
import com.pdb.dto.PhotoDto;
import com.pdp.helper.ObjectFactory;

public class AlbumService implements IAlbumService {
	private AlbumDao albumDao;

	public AlbumService() {
		albumDao = ObjectFactory.getObject(AlbumDao.class);
	}

	public Map<Integer, String> getAlbums() {
		System.out.println("AlbumService: getAlbums()");
		return albumDao.getAlbums();
	}

	public int getFirstPhoto(int albumNo) {
		return albumDao.getFirstPhoto(albumNo);
	}

	public PhotoDto getPhoto(int photoNo) {
		PhotoBo photoBo = null;
		PhotoDto photoDto = null;

		System.out.println("AlbumService: getPhoto(" + photoNo + ")");
		photoBo = albumDao.getPhoto(photoNo);
		photoDto = new PhotoDto(photoBo.getDescription(), photoBo.getImageContents(), photoBo.getImageType());

		return photoDto;
	}

	public int getPreviousPhoto(int albumNo, int cPhotoNo) {
		return albumDao.getPreviousPhoto(albumNo, cPhotoNo);
	}

	public int getNextPhoto(int albumNo, int cPhotoNo) {
		return albumDao.getNextPhoto(albumNo, cPhotoNo);
	}
}
