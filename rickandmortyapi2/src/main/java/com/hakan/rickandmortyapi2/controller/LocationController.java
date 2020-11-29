package com.hakan.rickandmortyapi2.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hakan.rickandmortyapi2.model.Location;
import com.hakan.rickandmortyapi2.model.response.LocationResponse;

/**
 * Controller to handle Location Requests
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

@RestController
@RequestMapping("/location")
public class LocationController extends BaseController<Location, LocationResponse> {
	
	/**
	 * 
	 * @param pageNumber : number given by user of which page he/she wants to see,default page 1
	 * @param pageSize : giving flexibility to user so can decide how much data will come to page, default size 20
	 * @param request
	 * @return LocationResponse object that give results of given paramaters 
	 */
	@GetMapping("")
	public LocationResponse getAllLocation(@RequestParam("page") Optional<Integer> pageNumber, 
										@RequestParam("pageSize") Optional<Integer> pageSize,
										HttpServletRequest request) {
		
		int page = pageNumber.isPresent() ? pageNumber.get().intValue() : 1;
		int size = pageSize.isPresent() ? pageSize.get().intValue() : PAGE_SIZE;

		LocationResponse locResp = getResponse(new LocationResponse(), itemHolder.getLocationsList(), page, size, request.getRequestURL().toString());
		
		report.locationVisited();
		report.addHistory(createHistory(page, size, locResp));
		
		return locResp;
	
	}
	
	/**
	 * 
	 * @param id : int value of user desired object id
	 * @return User desired Location
	 */
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable("id") int id) {
		Location loc = getSingleItem(itemHolder.getLocationsList(), new Location(), id);
		
		report.locationVisited();
		report.addHistory(createHistory(id, loc));
		return loc;
	}


}
