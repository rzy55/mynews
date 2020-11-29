package com.xx.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.xx.news.entity.Comment;


public interface CommentsDao{

	//根据Id查询评论
	public List<Comment> getCommentsById(int nid) throws SQLException;
	//添加评论
	public int addComment(Comment comment) throws SQLException;
	//删除评论
	public int deleteCommentsByNid(int nid) throws SQLException;
	//根据Id删除评论
	public int deleteCommentsById(int cid) throws SQLException;
}
