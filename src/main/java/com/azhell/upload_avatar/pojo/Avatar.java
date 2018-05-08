package com.azhell.upload_avatar.pojo;

public class Avatar {
	private String img;
	private Integer id;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Avatar [img=" + img + ", id=" + id + "]";
	}
	
	
}
