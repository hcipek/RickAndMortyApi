package com.hakan.rickandmortyapi2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakan.rickandmortyapi2.model.History;
import com.hakan.rickandmortyapi2.model.Report;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private Report report;
	
	/**
	 * Method for see endpoint visits and history details
	 * @return Report object 
	 */
	@RequestMapping("/")
	public Report getReport() {
		report.reportVisited();
		report.addHistory(createHistory());
		return report;
	}
	
	/**
	 * Creates a new history for report
	 * @return History object
	 */
	private History createHistory() {
		String request = "Reports requested";
		String response = "ReportList responded.";
		return new History(request, response);
	}
	
}
