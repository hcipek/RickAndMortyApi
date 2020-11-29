package com.hakan.rickandmortyapi2.model;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class UriNameBase {
	
	private String characters;
	private String locations;
	private String episodes;
	
	public UriNameBase() {
		// TODO Auto-generated constructor stub
	}
	
	public UriNameBase(String characters, String locations, String episodes) {
		super();
		this.characters = characters;
		this.locations = locations;
		this.episodes = episodes;
	}

	public String getCharacters() {
		return characters;
	}
	public String getLocations() {
		return locations;
	}
	public String getEpisodes() {
		return episodes;
	}
	
	

}
