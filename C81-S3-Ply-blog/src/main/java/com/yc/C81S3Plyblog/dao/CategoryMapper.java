package com.yc.C81S3Plyblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.C81S3Plyblog.bean.Category;

/**
 * 注解(简单sql) + XML(复杂SQL) 配置映射
 * @author 廖彦
 *
 */
public interface CategoryMapper {
	
	@Select("select * from category")
	List<Category> selectAll();

}
