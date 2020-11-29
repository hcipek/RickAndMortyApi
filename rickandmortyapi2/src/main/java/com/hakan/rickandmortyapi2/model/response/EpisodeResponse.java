package com.hakan.rickandmortyapi2.model.response;

import java.util.List;

import com.hakan.rickandmortyapi2.model.Episode;
import com.hakan.rickandmortyapi2.model.Info;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class EpisodeResponse extends BaseResponse<Episode> {
	
	public EpisodeResponse() {
		super();
	}

	public EpisodeResponse(Info info, List<Episode> results) {
		super(info, results);
	}
	
}
