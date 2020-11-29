package com.hakan.rickandmortyapi2.model;

import java.util.List;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class Episode extends BaseClass {
	
	private String air_date;
	private String episode;
	private List<String> characters;
	
	public Episode() {
		// TODO Auto-generated constructor stub
	}

	public Episode(int id, String name, String air_date, String episode, List<String> characters, String url, String created) {
		super(id, name, url, created);
		this.air_date = air_date;
		this.episode = episode;
		this.characters = characters;
	}

	public String getAir_date() {
		return air_date;
	}

	public void setAir_date(String air_date) {
		this.air_date = air_date;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public List<String> getCharacters() {
		return characters;
	}

	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}
	
}
