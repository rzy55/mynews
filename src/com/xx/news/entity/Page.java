package com.xx.news.entity;

import java.util.List;

public class Page {

	private int currPage;
	private int pageSize;
	private List<News> newsList;
	private int totalSize;
	private int totalPage;
	
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

		//具体情况具体分析
	public void setTotalPage(int pageSize) {
		if(this.totalSize % pageSize == 0) {
			this.totalPage = this.totalSize /pageSize ;
		}if(this.totalSize % pageSize > 0) {
			this.totalPage = (this.totalSize /pageSize)  + 1;
		}
	}
	
	@Override
	public String toString() {
		return "Page [currPage=" + currPage + ", pageSize=" + pageSize + ", newsList=" + newsList + ", totalSize="
				+ totalSize + ", totalPage=" + totalPage + "]";
	}
		
		
	
}
