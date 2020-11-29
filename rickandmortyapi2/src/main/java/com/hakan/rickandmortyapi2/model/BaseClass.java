package com.hakan.rickandmortyapi2.model;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public abstract class BaseClass {
	
	private int id;
	private String name;
	private String url;
	private String created;
	
	public BaseClass() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseClass(int id, String name, String url, String created) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.created = created;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	public String getReportResponseValue(String value) {
		if(this.name == null) {
			return "Not available " + value;
		}
		return value + " returned with id " + this.id + ", named: " + this.name;
	}

}
