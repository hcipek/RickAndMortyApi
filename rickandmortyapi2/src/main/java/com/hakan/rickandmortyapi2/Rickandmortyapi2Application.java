package com.hakan.rickandmortyapi2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.hakan.rickandmortyapi2.model.Episode;
import com.hakan.rickandmortyapi2.model.ItemHolder;
import com.hakan.rickandmortyapi2.model.Location;
import com.hakan.rickandmortyapi2.model.Report;
import com.hakan.rickandmortyapi2.model.Character;
import com.hakan.rickandmortyapi2.model.UriNameBase;
import com.hakan.rickandmortyapi2.model.response.CharacterResponse;
import com.hakan.rickandmortyapi2.model.response.EpisodeResponse;
import com.hakan.rickandmortyapi2.model.response.LocationResponse;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

@SpringBootApplication
public class Rickandmortyapi2Application {
	
	private static String CHARACTERS_URI;
	private static String LOCATIONS_URI;
	private static String EPISODES_URI;
	private static RestTemplate restTemplate = new RestTemplate();
	private static String API_URI_DEFAULT = "http://localhost:8080";		//This needs to be get from start, when address changed it gonna blow
	private static String REPLACING_URI = "https://rickandmortyapi.com/api";

	public static void main(String[] args) {
		SpringApplication.run(Rickandmortyapi2Application.class, args);
	}	
	
	@Bean
	public Report getReport() {
		return new Report();
	}	
	
	/**
	 * Creates itemHolder for project requirements. Items stores at beginning.
	 * @return itemHolder object
	 */
	@Bean
	public ItemHolder getItemHolder(HttpServletRequest request) {
		getUriNames();
		ItemHolder itemHolder = new ItemHolder();
		itemHolder.setCharacterList(getCharacterList(CHARACTERS_URI));
		itemHolder.setLocationsList(getLocationList(LOCATIONS_URI));
		itemHolder.setEpisodesList(getEpisodeList(EPISODES_URI));
		
		return itemHolder;
	}
	
	/**
	 * sets uri addresses of characters, locations, episodes
	 */
	private static void getUriNames() {
		UriNameBase uriNameBase = restTemplate.getForObject("https://rickandmortyapi.com/api/", UriNameBase.class);
		CHARACTERS_URI = uriNameBase.getCharacters() + "/";
		LOCATIONS_URI = uriNameBase.getLocations() + "/";
		EPISODES_URI = uriNameBase.getEpisodes() + "/";
	}
	
	/**
	 * Gets all characters from given URI
	 * @param URI uri that stores character list
	 * @return character list
	 */
	private List<Character> getCharacterList(String URI) {
		List<Character> list = new ArrayList<Character>();
		do {
			CharacterResponse response = restTemplate.getForObject(URI, CharacterResponse.class);
			list.addAll(convertCharacterResponseUrls(response.getResults()));
			URI = response.getInfo().getNext();
		} while(!StringUtils.isEmpty(URI));
		return list;
	}
	
	/**
	 * Gets all Locations from given URI
	 * @param URI uri that stores Location list
	 * @return Location list
	 */
	private List<Location> getLocationList(String URI) {
		List<Location> list = new ArrayList<Location>();
		do {
			LocationResponse response = restTemplate.getForObject(URI, LocationResponse.class);
			list.addAll(convertLocationResponseUrls(response.getResults()));
			URI = response.getInfo().getNext();
		} while(!StringUtils.isEmpty(URI));
		return list;
	}
	
	/**
	 * Gets all Episodes from given URI
	 * @param URI uri that stores Episode list
	 * @return Episode list
	 */
	private List<Episode> getEpisodeList(String URI) {
		List<Episode> list = new ArrayList<Episode>();
		do {
			EpisodeResponse response = restTemplate.getForObject(URI, EpisodeResponse.class);
			list.addAll(convertEpisodeResponseUrls(response.getResults()));
			URI = response.getInfo().getNext();
		} while(!StringUtils.isEmpty(URI));
		return list;
	}
	
	/**
	 * Converts old uri values with this apis uri values
	 * @param list List to convert
	 * @return converted list
	 */
	private List<Character> convertCharacterResponseUrls(List<Character> list) {
		list.stream().forEach(c -> c.setUrl(c.getUrl().replace(REPLACING_URI, API_URI_DEFAULT)));
		list.stream().forEach(c -> c.setLocation(c.setLocationUrl(c.getLocation().getUrl().replace(REPLACING_URI, API_URI_DEFAULT))));
		list.stream().forEach(c -> c.setOrigin(c.setOriginUrl(c.getOrigin().getUrl().replace(REPLACING_URI, API_URI_DEFAULT))));
		list.stream().forEach(c -> c.setEpisode(c.getEpisode().stream().map(f -> f.replace(REPLACING_URI, API_URI_DEFAULT)).collect(Collectors.toList())));
		
		return list;
	}
	
	/**
	 * Converts old uri values with this apis uri values
	 * @param list List to convert
	 * @return converted list
	 */
	private List<Location> convertLocationResponseUrls(List<Location> list) {
		list.stream().forEach(c -> c.setUrl(c.getUrl().replace(REPLACING_URI, API_URI_DEFAULT)));
		list.stream().forEach(c -> c.setResidents(c.getResidents().stream().map(f -> f.replace(REPLACING_URI, API_URI_DEFAULT)).collect(Collectors.toList())));
		
		return list;
	}
	
	/**
	 * Converts old uri values with this apis uri values
	 * @param list List to convert
	 * @return converted list
	 */
	private List<Episode> convertEpisodeResponseUrls(List<Episode> list) {
		list.stream().forEach(c -> c.setUrl(c.getUrl().replace(REPLACING_URI, API_URI_DEFAULT)));
		list.stream().forEach(c -> c.setCharacters((c.getCharacters().stream().map(f -> f.replace(REPLACING_URI, API_URI_DEFAULT)).collect(Collectors.toList()))));
		
		return list;
	}
	
	

}
