package com.hakan.rickandmortyapi2.model;

/**
 * 
 * @author hakan.ipek
 * @version 1.0.0
 * @since 2020-07-12
 *
 */

public class Info {
	
	private int count;
	private int pages;
	private String next;
	private String prev;
	
	public Info() {
		// TODO Auto-generated constructor stub
	}

	public Info(int count, int pages, String next, String prev) {
		super();
		this.count = count;
		this.pages = pages;
		this.next = next;
		this.prev = prev;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}
	
	

}
