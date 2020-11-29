package com.xx.news.dao;

import java.util.List;

import com.xx.news.entity.Topic;

public interface TopicDao {

	//添加主题
	public int addTopic (Topic topic) throws Exception;
	//显示所有主题
	public List<Topic> allTopic() throws Exception;
}
