package com.laptrinhjavaweb.response;

public enum HTTPStatus {
	OK(200, "Request Success"),
	Already_Exists(401, "Data already exists"),
	DATA_NOT_FOUND(405, "Data not found in system"),
	SERVER_ERROR(500, "Request Error");

	private Integer code;
	private String message;
	
	HTTPStatus(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
