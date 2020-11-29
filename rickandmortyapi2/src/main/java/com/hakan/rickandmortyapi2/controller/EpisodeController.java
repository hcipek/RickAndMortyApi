package com.hakan.rickandmortyapi2.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hakan.rickandmortyapi2.model.Episode;
import com.hakan.rickandmortyapi2.model.response.EpisodeResponse;

/**
 * Controller that handles Episode requests
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

@RestController
@RequestMapping("/episode")
public class EpisodeController extends BaseController<Episode, EpisodeResponse> {
	
	/**
	 * Method that gets pageNumber(optional), pageSize(optional) and sort value(optional) and returns episodeResponse
	 * @param pageNumber user desired page
	 * @param pageSize user desired page size
	 * @param sort user desired sort value, could be 'name' or character size of Episode
	 * @param request 
	 * @return episodeResponse object
	 */
	@RequestMapping("")
	public EpisodeResponse getAllEpisodes(@RequestParam("page") Optional<Integer> pageNumber, 
										@RequestParam("pageSize") Optional<Integer> pageSize, 
										@RequestParam("sort") Optional<String> sort,
										HttpServletRequest request) {

		int page = pageNumber.isPresent() ? pageNumber.get().intValue() : 1;
		int size = pageSize.isPresent() ? pageSize.get().intValue() : PAGE_SIZE;
		String sortValue = sort.isPresent() ? sort.get() : DEFAULT_SORT;
		
		EpisodeResponse epiResp = getEpisodes(page, size, sortValue, request.getRequestURL().toString());
		
		report.locationVisited();
		report.addHistory(createHistory(page, size, epiResp));
		
		return epiResp;
	}
	
	/**
	 * Method that gets id of Episode and returns it, empty Episode returns if object not found
	 * @param id user desired Episode id
	 * @return Episode object
	 */
	@RequestMapping("/{id}")
	public Episode getEpisode(@PathVariable("id") int id) {
		Episode epi = getSingleItem(itemHolder.getEpisodesList(), new Episode(), id);
		
		report.locationVisited();
		report.addHistory(createHistory(id, epi));
		return epi;
	}
	
	private EpisodeResponse getEpisodes(int pageNumber, int count, String sort, String url) {
		List<Episode> list = itemHolder.getEpisodesList();
		
		if (sort.equals("characters")) {
			list.sort((Episode s1, Episode s2)->s2.getCharacters().size()-s1.getCharacters().size());
		}
		
		return getResponse(new EpisodeResponse(), list, pageNumber, count, sort, url);
	}

}
