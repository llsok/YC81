package com.yc.C81S3Plyblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.C81S3Plyblog.bean.Article;

public interface ArticleMapper {

	@Select("select * from article order by id desc")
	/**
	 * <resultMap> =>	@Results
	 * 	<result> => Result	
	 * <一对一 >
	 *  <一对多>
	 * @return
	 * 
	 * ?????  ==> 子查询的  命名空间  namespace='' +查询id
	 */
	@Results(id="rmAct", value={
			@Result(column = "categoryid", property = "category",
					one = @One(select = "com.yc.C81S3Plyblog.dao.CategoryMapper.selectById")) })
	List<Article> selectNewArticle();

	@Select("select * from article where id = #{id}")
	// 引用关联查询的配置
	@ResultMap("rmAct")
	Article selectById(int id);

}
