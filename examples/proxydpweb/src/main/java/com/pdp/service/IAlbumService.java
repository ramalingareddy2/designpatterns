package com.pdp.service;

import java.util.Map;

import com.pdb.dto.PhotoDto;

public interface IAlbumService {
	Map<Integer, String> getAlbums();

	int getFirstPhoto(int albumNo);

	PhotoDto getPhoto(int photoNo);

	int getPreviousPhoto(int albumNo, int cPhotoNo);

	int getNextPhoto(int albumNo, int cPhotoNo);
}
