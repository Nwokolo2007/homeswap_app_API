package com.homeswap.payloads.Responses;

public class ImageResponse {

	private Long homeId;
	private Long imageId;
	private String imageUrl;
	public Long getHomeId() {
		return homeId;
	}
	public void setHomeId(Long homeId) {
		this.homeId = homeId;
	}
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
