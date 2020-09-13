package com.yc.C81S3Plyblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.C81S3Plyblog.bean.Article;

public interface ArticleMapper {

	@Select("select * from article order by id desc")
	List<Article> selectNewArticle();

}
