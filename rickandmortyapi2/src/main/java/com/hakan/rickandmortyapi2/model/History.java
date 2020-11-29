package com.hakan.rickandmortyapi2.model;

import java.time.LocalDateTime;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class History {
	
	private String request;
	private String response;
	private String date;
	
	public History() {
		//TODO
	}
	
	public History(String req, String resp) {
		this.date = LocalDateTime.now().toString();
		this.request = req;
		this.response = resp;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getDate() {
		return date;
	}
	
	
	
	

}
