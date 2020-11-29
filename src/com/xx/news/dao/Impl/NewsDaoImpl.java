package com.xx.news.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xx.news.dao.BaseDao;
import com.xx.news.dao.NewsDao;
import com.xx.news.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {


	@Override
	public List<News> getAllNews() throws SQLException {
		ResultSet rs=null;
		List<News> newslist = new ArrayList<News>();
		String sql="select * from news";
		rs=this.excuteQuery(sql);
		while(rs.next()) {
			News news = new News(); 
			news.setNid(rs.getInt("nid"));
			news.setNtid(rs.getInt("ntid"));
			news.setNtitle(rs.getString("ntitle"));
			news.setNauthor(rs.getString("nauthor"));
			news.setNcreateDate(rs.getDate("ncreateDate"));
			news.setNpicPath(rs.getString("npicPath"));
			news.setNcontent(rs.getString("ncontent"));
			news.setNmodifyDate(rs.getDate("nmodifyDate"));
			news.setNsummary(rs.getString("nsummary"));
			newslist.add(news);
		}
		return newslist;
	}

	@Override
	public int AddNews(News news) throws SQLException {
		String sql="insert into news (ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) values (?,?,?,?,?,?,?,?)";
		
		int result = excuteUpdate(sql,
					news.getNtid(),
					news.getNtitle(),
					news.getNauthor(),
					news.getNcreateDate(),
					news.getNpicPath(),
					news.getNcontent(),
					news.getNmodifyDate(),
					news.getNsummary());
		return result;
	}

	@Override
	public int deleteNews(int nid) throws SQLException {
		String sql="delete from news where nid=?";
		int result = excuteUpdate(sql, nid);
		return result;
	}

	@Override
	public int editNews(int nid,News news) throws SQLException {
		String sql="update news set ntid=?,ntitle=?,nauthor=?,ncreateDate=?,npicPath=?,ncontent=?,nmodifyDate=?,nsummary=?";
		int result=excuteUpdate(sql,
				news.getNtid(),
				news.getNtitle(),
				news.getNauthor(),
				news.getNcreateDate(),
				news.getNpicPath(),
				news.getNcontent(),
				news.getNmodifyDate(),
				news.getNsummary());
		return result;
	}

	@Override
	public News getNewsById(int nid) throws SQLException {
		String sql = "select * from news where nid = ?";
		ResultSet resultSet = excuteQuery(sql, nid);
		News news = new News();
		while(resultSet.next()) {
			news.setNid(resultSet.getInt("nid"));
			news.setNtid(resultSet.getInt("ntid"));
			news.setNtitle(resultSet.getString("ntitle"));
			news.setNcontent(resultSet.getString("ncontent"));
			news.setNauthor(resultSet.getString("nauthor"));
			news.setNcreateDate(resultSet.getDate("ncreateDate"));
			news.setNmodifyDate(resultSet.getDate("nmodifyDate"));
			news.setNsummary(resultSet.getString("nsummary"));
			news.setNpicPath(resultSet.getString("npicPath"));
		}
		return news;
	}

	@Override
	public List<News> getNewsByPage(int contPage, int pageSize) throws SQLException {
		List<News> newsList=new ArrayList<News>();
		String sql="select * from news limit ?,?";
		ResultSet rs = excuteQuery(sql, 
				(contPage-1)*pageSize,
				pageSize);
		while(rs.next()) {
			News news = new News();
			news.setNid(rs.getInt("nid"));
			news.setNtitle(rs.getString("ntitle"));
			news.setNsummary(rs.getString("nsummary"));
			news.setNpicPath(rs.getString("npicPath"));
			news.setNcreateDate(rs.getDate("ncreateDate"));
			news.setNmodifyDate(rs.getDate("nmodifyDate"));
			news.setNcontent(rs.getString("ncontent"));
			news.setNauthor(rs.getString("nauthor"));
			news.setNtid(rs.getInt("ntid"));
			newsList.add(news);
		}
		return newsList;
	}

	@Override
	public List<News> getNewsByCondition(News news) throws SQLException {
		List<News> newsList=new ArrayList<News>();
		String sql="select * from news where "
				+"ntitle like concat('%',?,'%') "
				+"and date_format( ncreateDate ,'%Y-%m-%d') = date_format(?,'%Y-%m-%d') "
				+"and nid=?"
				+"and nauthor like concat('%','?','%')";
		ResultSet rs=excuteQuery(sql,
				news.getNtitle(),
				new java.sql.Date(news.getNcreateDate().getTime()),
				news.getNtid(),
				news.getNauthor());
		while(rs.next()) {
			News newsobj = new News();
			newsobj.setNid(rs.getInt("nid"));
			newsobj.setNtitle(rs.getString("ntitle"));
			newsobj.setNsummary(rs.getString("nsummary"));
			newsobj.setNpicPath(rs.getString("npicPath"));
			newsobj.setNcreateDate(rs.getDate("ncreateDate"));
			newsobj.setNmodifyDate(rs.getDate("nmodifyDate"));
			newsobj.setNcontent(rs.getString("ncontent"));
			newsobj.setNauthor(rs.getString("nauthor"));
			newsobj.setNtid(rs.getInt("ntid"));
			newsList.add(newsobj);
		}
		return newsList;
	}

	@Override
	public List<News> getNewsByTid(int tid) throws SQLException {
		String sql = "select * from news where ntid = ? ";
		ResultSet res = excuteQuery(sql, tid);
		List<News> newsList = new ArrayList<News>();
		while(res.next()) {
			News newsObj = new News();
			newsObj.setNid(res.getInt("nid"));
			newsObj.setNtitle(res.getString("ntitle"));
			newsObj.setNsummary(res.getString("nsummary"));
			newsObj.setNpicPath(res.getString("npicPath"));
			newsObj.setNcreateDate(res.getDate("ncreateDate"));
			newsObj.setNmodifyDate(res.getDate("nmodifyDate"));
			newsObj.setNcontent(res.getString("ncontent"));
			newsObj.setNauthor(res.getString("nauthor"));
			newsObj.setNtid(res.getInt("ntid"));
			newsList.add(newsObj);
		}
		return newsList;
	}

	@Override
	public List<News> getNewsByTopicId(int tid) throws SQLException{
		String sql = "select * from news where ntid = ? ";
		ResultSet res = excuteQuery(sql, tid);
		List<News> newsList = new ArrayList<News>();
		while(res.next()) {
			News newsObj = new News();
			newsObj.setNid(res.getInt("nid"));
			newsObj.setNtitle(res.getString("ntitle"));
			newsObj.setNsummary(res.getString("nsummary"));
			newsObj.setNpicPath(res.getString("npicPath"));
			newsObj.setNcreateDate(res.getDate("ncreateDate"));
			newsObj.setNmodifyDate(res.getDate("nmodifyDate"));
			newsObj.setNcontent(res.getString("ncontent"));
			newsObj.setNauthor(res.getString("nauthor"));
			newsObj.setNtid(res.getInt("ntid"));
			newsList.add(newsObj);
		}
		return newsList;
	}

}
