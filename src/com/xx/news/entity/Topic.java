package com.xx.news.entity;

public class Topic {

	private int tid;
	private String tname;
	public Topic(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public Topic() {
		// TODO Auto-generated constructor stub
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	

}
