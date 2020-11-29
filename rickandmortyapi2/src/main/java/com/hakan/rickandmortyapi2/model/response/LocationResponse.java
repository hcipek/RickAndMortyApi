package com.hakan.rickandmortyapi2.model.response;

import java.util.List;

import com.hakan.rickandmortyapi2.model.Info;
import com.hakan.rickandmortyapi2.model.Location;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class LocationResponse extends BaseResponse<Location> {
	
	public LocationResponse() {
		super();
	}

	public LocationResponse(Info info, List<Location> results) {
		super(info, results);
	}
	
}
