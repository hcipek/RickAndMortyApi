package com.hakan.rickandmortyapi2.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hakan.rickandmortyapi2.model.BaseClass;
import com.hakan.rickandmortyapi2.model.History;
import com.hakan.rickandmortyapi2.model.Info;
import com.hakan.rickandmortyapi2.model.ItemHolder;
import com.hakan.rickandmortyapi2.model.Report;
import com.hakan.rickandmortyapi2.model.response.BaseResponse;

/**
 * BaseController for managing generic methods of controllers
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

@RestController
public abstract class BaseController<T extends BaseClass, U extends BaseResponse<T>> {

	protected int PAGE_SIZE=20;
	protected String DEFAULT_SORT="id";
	
	@Autowired
	protected ItemHolder itemHolder;
	
	@Autowired
	protected Report report;
	
	/**
	 * Generic method for getting single item by id
	 * @param list List that object belong to
	 * @param t instance of Object
	 * @param id id of desired object
	 * @return returns object with desired id or else empty instance of object
	 */
	protected T getSingleItem(List<T> list, T t, int id) {
		return list.stream().filter(location -> id==location.getId()).findFirst().orElse(t);
	}
	
	/**
	 * Method can be used when response is not sortable
	 * @param u Empty instance of response object
	 * @param list object list to be paged
	 * @param pageNumber number of page user wants to see
	 * @param count size of page
	 * @param url using for create info object prev/next values
	 * @return result of getResponse method
	 */
	protected U getResponse(U u, List<T> list, int pageNumber, int count, String url) {
		return getResponse(u, list, pageNumber, count, DEFAULT_SORT, url);
	}
	
	/**
	 * Generic method for getting paged response
	 * @param u Empty instance of response object
	 * @param list object list to be paged
	 * @param pageNumber number of page user wants to see
	 * @param count size of page
	 * @param sort desired sort method
	 * @param url using for create info object prev/next values
	 * @return response object
	 */
	protected U getResponse(U u, List<T> list, int pageNumber, int count, String sort, String url) {
		Info info = infoCreator(list, count, pageNumber, url);
		if(info == null) {
			return u;
		}

		if(sort.equals("name")) {
			list.sort(Comparator.comparing(T::getName));
		} else if (sort.equals("id")) {
			list.sort(Comparator.comparing(T::getId));
		}
		
		u.setInfo(info);
		u.setResults(getSubList(list, pageNumber, count));
		return u;
	}

	/**
	 * Generic Method to create Info object for response object
	 * @param list object list to be paged
	 * @param count size of page
	 * @param pageNumber number of page user wants to see
	 * @param url using for create prev/next values
	 * @return created info object, returns null when pageNumber is out of bounds
	 */
	private Info infoCreator(List<T> list, int count, int pageNumber, String url) {
		int sizeOfList = list.size();
		int pageCount = sizeOfList/count + (sizeOfList%count == 0 ? 0 : 1);
		if(pageCount<pageNumber) {
			return null;
		}
		String nextPageUrl = pageCount > pageNumber ? url + "?page=" + (pageNumber + 1) : null;
		String prevPageUrl = pageNumber > 1 ? url + "?page=" + (pageNumber - 1) : null;
		return new Info(sizeOfList, pageCount, nextPageUrl, prevPageUrl);
	}
	
	/**
	 * Generic method to create history for id requests
	 * @param id value to show user in report requests
	 * @param base class that extends BaseClass
	 * @return History object
	 */
	protected History createHistory(int id, T base) {
		String request = getReportRequestValue(base.getClass().getSimpleName(), id);
		String response = base.getReportResponseValue(base.getClass().getSimpleName());
		return new History(request, response);
	}
	
	/**
	 * Generic method to create history for paged request
	 * @param page Page that user visited
	 * @param size users visited page size
	 * @param base class that extends BaseClass
	 * @return History object
	 */
	protected History createHistory(int page, int size, U base) {
		String request = getReportRequestWithPageValue(base.getClass().getSimpleName(), page, size);
		String response = base.getReportResponseValueWithPage(base.getClass().getSimpleName(), page, size);
		return new History(request, response);
	}
	
	private String getReportRequestWithPageValue(String value, int page, int count) {
		return value + " requested with page number " + page + " with item count per page : " + count;
	}
	
	private String getReportRequestValue(String value, int id) {
		return value + " requested with id " + id;
	}
	
	/**
	 * Generic method to create page spesific list
	 * @param list List of object extends BaseClass
	 * @param pageNumber page to show user
	 * @param count the page size
	 * @return List of result
	 */
	private List<T> getSubList(List<T> list, int pageNumber, int count) {
		int fromIndex = getFromIndex(pageNumber);
		int toIndex = getToIndex(list, fromIndex, count);
		return list.subList(fromIndex, toIndex);
	}
	
	private int getFromIndex(int val) {
		return (val - 1)*20;
	}
	
	private int getToIndex(List<? extends BaseClass> list, int val1, int val2) {
		return list.size() < (val1 + val2) ? list.size() : (val1 + val2);
	}

}
