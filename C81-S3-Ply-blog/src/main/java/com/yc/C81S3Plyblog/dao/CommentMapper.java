package com.yc.C81S3Plyblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.C81S3Plyblog.bean.Comment;

public interface CommentMapper {
	
	@Insert("insert into comment values(null,#{articleid},#{content},#{createby}, now())")
	int insert(Comment comment);
	
	@Select("select * from comment where articleid=#{aid}")
	List<Comment> selectByArticleid(int articleid);

}
