package com.yc.C81S3Plyblog;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.C81S3Plyblog.bean.Category;
import com.yc.C81S3Plyblog.dao.CategoryMapper;

@SpringBootTest
class C81S3PlyBlogApplicationTests {

	@Resource
	private CategoryMapper cm;

	@Test
	void contextLoads() {
		for (Category c : cm.selectAll()) {
			System.out.println(c.getName());
		}
	}

}
