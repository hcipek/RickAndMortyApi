package com.hakan.rickandmortyapi2.model;

import java.util.List;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class Character extends BaseClass {
	
	private String status;	//The status of the character ('Alive', 'Dead' or 'unknown').
	private String species;	//The species of the character.
	private String type;	//	The type or subspecies of the character.
	private String gender;		//The gender of the character ('Female', 'Male', 'Genderless' or 'unknown').
	private Location origin;	//Name and link to the character's origin location.
	private Location location;	//Name and link to the character's last known location endpoint.
	private String image;	//Link to the character's image. All images are 300x300px and most are medium shots or portraits since they are intended to be used as avatars.
	private List<String> episode;	//array (urls)	List of episodes in which this character appeared.
	
	public Character() {
		// TODO Auto-generated constructor stub
	}

	public Character(int id, String name, String status, String species, String type, String gender, Location origin, 
			Location location, String image, List<String> episode, String url, String created) {
		super(id, name, url, created);
		this.status = status;
		this.species = species;
		this.type = type;
		this.gender = gender;
		this.origin = origin;
		this.location = location;
		this.image = image;
		this.episode = episode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Location getOrigin() {
		return origin;
	}

	public void setOrigin(Location origin) {
		this.origin = origin;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getEpisode() {
		return episode;
	}

	public void setEpisode(List<String> episode) {
		this.episode = episode;
	}
	
	public Location setLocationUrl(String url) {
		this.location.setUrl(url);
		return location;
	}
	
	public Location setOriginUrl(String url) {
		this.origin.setUrl(url);
		return origin;
	}
	
}
