package com.pdp.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.pdb.dto.PhotoDto;

public class CachedAlbumService implements IAlbumService {
	private IAlbumService albumService;
	private Map<Integer, String> albumsMap;
	private LinkedHashMap<Integer, PhotoDto> photoCache;

	public CachedAlbumService() {
		albumService = new AlbumService();
		photoCache = new LinkedHashMap<Integer, PhotoDto>(5);
	}

	@Override
	public Map<Integer, String> getAlbums() {
		if (albumsMap == null) {
			albumsMap = albumService.getAlbums();
		}
		return albumsMap;
	}

	@Override
	public int getFirstPhoto(int albumNo) {
		return albumService.getFirstPhoto(albumNo);
	}

	@Override
	public PhotoDto getPhoto(int photoNo) {
		PhotoDto photoDto = null;
		Integer firstPhoto = 0;

		if (photoCache.containsKey(photoNo)) {
			System.out.println("return : " + photoNo + " from cache");
			return photoCache.get(photoNo);
		} else {
			photoDto = albumService.getPhoto(photoNo);
			if (photoCache.size() > 5) {
				firstPhoto = photoCache.keySet().iterator().next();
				photoCache.remove(firstPhoto);
				System.out.println("removing first photo : " + firstPhoto + " from cache");
			}
			photoCache.put(photoNo, photoDto);
		}
		return photoDto;
	}

	@Override
	public int getPreviousPhoto(int albumNo, int cPhotoNo) {
		return albumService.getPreviousPhoto(albumNo, cPhotoNo);
	}

	@Override
	public int getNextPhoto(int albumNo, int cPhotoNo) {
		return albumService.getNextPhoto(albumNo, cPhotoNo);
	}

}
