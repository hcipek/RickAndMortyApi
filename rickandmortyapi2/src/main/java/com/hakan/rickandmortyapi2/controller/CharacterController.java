package com.hakan.rickandmortyapi2.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hakan.rickandmortyapi2.model.Character;
import com.hakan.rickandmortyapi2.model.response.CharacterResponse;

/**
 * Controller that handles character based requests
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

@RestController
@RequestMapping("/character")
public class CharacterController extends BaseController<Character, CharacterResponse> {
	
	/**
	 * Method that gets pageNumber(optional), pageSize(optional) and sort value(optional) and returns characterResponse
	 * @param pageNumber user desired page
	 * @param pageSize user desired page size
	 * @param sort user desired sort value, could be 'name' or character size of Character
	 * @param request 
	 * @return characterResponse object
	 */
	@RequestMapping("")
	public CharacterResponse getAllCharacters(@RequestParam("page") Optional<Integer> pageNumber, 
											@RequestParam("pageSize") Optional<Integer> pageSize, 
											@RequestParam("sort") Optional<String> sort,
											HttpServletRequest request)  {
		
		int page = pageNumber.isPresent() ? pageNumber.get().intValue() : 1;
		int size = pageSize.isPresent() ? pageSize.get().intValue() : PAGE_SIZE;
		String sortValue = sort.isPresent() ? sort.get() : DEFAULT_SORT;
		
		CharacterResponse charResp = getCharacters(page, size, sortValue, request.getRequestURL().toString());
		
		report.locationVisited();
		report.addHistory(createHistory(page, size, charResp));
		
		return charResp;
	}
	
	/**
	 * Method that gets id of Character and returns it, empty Character returns if object not found
	 * @param id user desired Character id
	 * @return Character object
	 */
	@RequestMapping("/{id}")
	public Character getCharacter(@PathVariable("id") int id) {
		Character character = getSingleItem(itemHolder.getCharacterList(), new Character(), id);
		report.locationVisited();
		report.addHistory(createHistory(id, character));
		return character;
	}
	
	private CharacterResponse getCharacters(int pageNumber, int count, String sort, String url) {
		List<Character> list = itemHolder.getCharacterList();
		
		if (sort.equals("episodes")) {
			list.sort((Character s1, Character s2)->s2.getEpisode().size()-s1.getEpisode().size());
		}
		
		return getResponse(new CharacterResponse(), list, pageNumber, count, sort, url);
	}
}
