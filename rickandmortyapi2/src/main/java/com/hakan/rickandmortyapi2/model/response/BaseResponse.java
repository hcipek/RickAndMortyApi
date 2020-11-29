package com.hakan.rickandmortyapi2.model.response;

import java.util.List;

import com.hakan.rickandmortyapi2.model.Info;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public abstract class BaseResponse<T> {
	
	private Info info;
	private List<T> results;
	
	public BaseResponse() {
		//TODO: 
	}
	
	public BaseResponse(Info info, List<T> results) {
		this.info = info;
		this.results = results;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public String getReportResponseValueWithPage(String value, int page, int count) {
		if(this.info == null) {
			return "Not available responses";
		}
		return value + " returned with page number " + page + " with item Count " + count;
	}

}
