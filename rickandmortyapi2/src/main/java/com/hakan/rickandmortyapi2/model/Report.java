package com.hakan.rickandmortyapi2.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class Report {
	
	private int totalCharacterRequest;
	private int totalEpisodesRequest;
	private int totalLocationsRequest;
	private int totalReportRequest;
	private List<History> historyList;
	
	public Report() {
		//TODO
	}
	
	public Report(int totalCharacterRequest, int totalEpisodesRequest, int totalLocationsRequest,
			int totalReportRequest, List<History> historyList) {
		super();
		this.totalCharacterRequest = totalCharacterRequest;
		this.totalEpisodesRequest = totalEpisodesRequest;
		this.totalLocationsRequest = totalLocationsRequest;
		this.totalReportRequest = totalReportRequest;
		this.historyList = historyList;
	}

	public void characterVisited() {
		this.totalCharacterRequest++;
	}
	
	public void episodeVisited() {
		this.totalEpisodesRequest++;
	}
	
	public void locationVisited() {
		this.totalLocationsRequest++;
	}
	
	public void reportVisited() {
		this.totalReportRequest++;
	}

	public int getTotalCharacterRequest() {
		return totalCharacterRequest;
	}

	public int getTotalEpisodesRequest() {
		return totalEpisodesRequest;
	}

	public int getTotalLocationsRequest() {
		return totalLocationsRequest;
	}
	
	public int getTotalReportRequest() {
		return totalReportRequest;
	}
	
	public List<History> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List<History> historyList) {
		this.historyList = historyList;
	}

	public void addHistory(History history) {
		if(CollectionUtils.isEmpty(historyList)) {
			this.historyList = new ArrayList<History>();
		}
		historyList.add(history);
	}

}
