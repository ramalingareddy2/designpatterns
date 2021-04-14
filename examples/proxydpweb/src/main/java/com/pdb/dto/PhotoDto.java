package com.pdb.dto;

import java.io.Serializable;

public class PhotoDto implements Serializable {
	private static final long serialVersionUID = -8492364104787458709L;
	private String description;
	private byte[] imageContents;
	private String imageType;

	public PhotoDto(String description, byte[] imageContents, String imageType) {
		super();
		this.description = description;
		this.imageContents = imageContents;
		this.imageType = imageType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImageContents() {
		return imageContents;
	}

	public void setImageContents(byte[] imageContents) {
		this.imageContents = imageContents;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

}
