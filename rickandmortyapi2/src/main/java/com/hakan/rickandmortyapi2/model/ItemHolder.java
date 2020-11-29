package com.hakan.rickandmortyapi2.model;

import java.util.List;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class ItemHolder {
	
	private List<Character> characterList;
	private List<Location> locationsList;
	private List<Episode> episodesList;
	
	public ItemHolder() {
		// TODO Auto-generated constructor stub
	}

	public List<Character> getCharacterList() {
		return characterList;
	}

	public void setCharacterList(List<Character> characterList) {
		this.characterList = characterList;
	}

	public List<Location> getLocationsList() {
		return locationsList;
	}

	public void setLocationsList(List<Location> locationsList) {
		this.locationsList = locationsList;
	}

	public List<Episode> getEpisodesList() {
		return episodesList;
	}

	public void setEpisodesList(List<Episode> episodesList) {
		this.episodesList = episodesList;
	}
	
}
