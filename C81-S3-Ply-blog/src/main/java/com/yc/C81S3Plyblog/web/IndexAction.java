package com.yc.C81S3Plyblog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.C81S3Plyblog.bean.Article;
import com.yc.C81S3Plyblog.dao.ArticleMapper;

// @RestController  ==> 所有的方法默认返回 json 数据
@Controller // ==> 所有的方法默认返回一个视图的名称(字符串)
public class IndexAction {

	@Resource
	private ArticleMapper am;

	@GetMapping(path = { "index", "index.html", "/" })
	// SpringMVC 使用一个 Model 对象传递数据给 页面, Model 通过方法参数注入进来
	public String index(Model m) {
		List<Article> newArticles = am.selectNewArticle();
		// 将查询出的数据添加到 model 中 发送给页面
		m.addAttribute("newArticles", newArticles);
		return "index";
	}

}
