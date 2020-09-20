package com.yc.C81S3Plyblog;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yc.C81S3Plyblog.bean.Category;
import com.yc.C81S3Plyblog.bean.User;
import com.yc.C81S3Plyblog.biz.BizException;
import com.yc.C81S3Plyblog.biz.UserBiz;
import com.yc.C81S3Plyblog.dao.CategoryMapper;

@SpringBootTest
class C81S3PlyBlogApplicationTests {

	@Resource
	private CategoryMapper cm;

	@Resource
	private UserBiz ub;

	@Test
	void contextLoads() {
		for (Category c : cm.selectAll()) {
			System.out.println(c.getName());
		}
	}

	@Test
	void test() {
		User user = new User();
		user.setAccount("zhangsan");
		user.setPwd("123456");

		try {
			User dbuser = ub.login(user);
			Assert.notNull(dbuser, "dbuser不能为空");
		} catch (BizException e) {
			e.printStackTrace();
		}

		user.setPwd("654321");
		try {
			User dbuser = ub.login(user);
			Assert.isNull(dbuser, "dbuser必须为空");
		} catch (BizException e) {
			e.printStackTrace();
			Assert.hasText(e.getMessage(), "用户名或密码错误");
		}

	}

}
