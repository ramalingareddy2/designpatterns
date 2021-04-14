package com.pdp.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pdp.helper.ObjectFactory;
import com.pdp.service.CachedAlbumService;
import com.pdp.service.IAlbumService;

@WebServlet(urlPatterns = { "/gallery" })
public class GalleryServlet extends HttpServlet {
	private static final long serialVersionUID = -149642301314777217L;
	private IAlbumService albumService;

	@Override
	public void init() throws ServletException {
		albumService = ObjectFactory.getObject(CachedAlbumService.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<Integer, String> albumsMap = null;
		String albumNo = null;
		String action = null;
		int cPhotoNo = 0;
		int photoNo = 0;

		albumNo = req.getParameter("albumNo");
		action = req.getParameter("action");

		if (action == null || action.trim().length() == 0) {
			if (albumNo != null && albumNo.trim().length() > 0) {
				photoNo = albumService.getFirstPhoto(Integer.parseInt(albumNo));
			}
		} else if (action.equals("next")) {
			cPhotoNo = Integer.parseInt(req.getParameter("cPhotoNo"));
			photoNo = albumService.getNextPhoto(Integer.parseInt(albumNo), cPhotoNo);
			if (photoNo == 0) {
				photoNo = cPhotoNo;
			}
		} else if (action.equals("prev")) {
			cPhotoNo = Integer.parseInt(req.getParameter("cPhotoNo"));
			photoNo = albumService.getPreviousPhoto(Integer.parseInt(albumNo), cPhotoNo);
			if (photoNo == 0) {
				photoNo = cPhotoNo;
			}
		}

		req.setAttribute("photoNo", photoNo);
		req.setAttribute("albumNo", albumNo);
		// for every request we need to populate all the albums in the request scope
		albumsMap = albumService.getAlbums();
		req.setAttribute("albums", albumsMap);
		req.getRequestDispatcher("/WEB-INF/jsp/gallery.jsp").forward(req, resp);
	}

}
