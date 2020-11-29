package com.hakan.rickandmortyapi2.model.response;

import java.util.List;

import com.hakan.rickandmortyapi2.model.Character;
import com.hakan.rickandmortyapi2.model.Info;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class CharacterResponse extends BaseResponse<Character> {
	
	public CharacterResponse() {
		super();
	}

	public CharacterResponse(Info info, List<Character> results) {
		super(info, results);
	}
	
}
