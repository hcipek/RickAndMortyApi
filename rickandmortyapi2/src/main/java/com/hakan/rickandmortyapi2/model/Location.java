package com.hakan.rickandmortyapi2.model;

import java.util.List;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class Location extends BaseClass {
	
	private String type;
	private String dimension;
	private List<String> residents;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}

	public Location(int id, String name, String type, String dimension, List<String> residents, String url, String created) {
		super(id, name, url, created);
		this.type = type;
		this.dimension = dimension;
		this.residents = residents;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public List<String> getResidents() {
		return residents;
	}

	public void setResidents(List<String> residents) {
		this.residents = residents;
	}
	
}
