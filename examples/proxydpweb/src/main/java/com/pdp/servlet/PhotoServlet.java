package com.pdp.servlet;

import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pdb.dto.PhotoDto;
import com.pdp.helper.ObjectFactory;
import com.pdp.service.CachedAlbumService;
import com.pdp.service.IAlbumService;

@WebServlet(urlPatterns = { "/photo" })
public class PhotoServlet extends HttpServlet {
	private IAlbumService albumService;

	@Override
	public void init() throws ServletException {
		albumService = ObjectFactory.getObject(CachedAlbumService.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String photoNo = null;
		PhotoDto photoDto = null;
		BufferedOutputStream bos = null;

		photoNo = req.getParameter("photoNo");
		photoDto = albumService.getPhoto(Integer.parseInt(photoNo));

		try {
			bos = new BufferedOutputStream(resp.getOutputStream());
			resp.setHeader("Content-Type", photoDto.getImageType());
			resp.setHeader("Content-Disposition", "inline");
			bos.write(photoDto.getImageContents());
		} finally {
			bos.close();
		}
	}

}






