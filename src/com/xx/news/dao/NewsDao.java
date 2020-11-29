package com.xx.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.xx.news.entity.News;

public interface NewsDao {

	//显示所有新闻
	public List<News> getAllNews() throws SQLException;
	//添加新闻 
	public int AddNews(News news) throws SQLException;
	//删除新闻
	public int deleteNews(int nid) throws SQLException;
	//修改新闻
	public int editNews(int nid,News news) throws SQLException;
	//根据Id查询新闻
	public News getNewsById(int nid) throws SQLException;
	//新闻分页
	public List<News> getNewsByPage(int contPage,int pageSize) throws SQLException;
	//根据条件得到新闻
	public List<News> getNewsByCondition(News news) throws SQLException;
	//根据Tid得到新闻
	public List<News> getNewsByTid(int tid) throws SQLException;
	//根据主题Id得到新闻
	public List<News> getNewsByTopicId(int tid) throws SQLException;
}
