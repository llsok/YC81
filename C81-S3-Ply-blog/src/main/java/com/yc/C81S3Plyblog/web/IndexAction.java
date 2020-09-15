package com.yc.C81S3Plyblog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.C81S3Plyblog.bean.Article;
import com.yc.C81S3Plyblog.dao.ArticleMapper;
import com.yc.C81S3Plyblog.dao.CategoryMapper;

// @RestController  ==> 所有的方法默认返回 json 数据
@Controller // ==> 所有的方法默认返回一个视图的名称(字符串)
public class IndexAction {

	@Resource
	private ArticleMapper am;

	@Resource
	private CategoryMapper cm;

	@GetMapping(path = { "index", "index.html", "/" })
	// SpringMVC 使用一个 Model 对象传递数据给 页面, Model 通过方法参数注入进来
	public String index(Model m, @RequestParam(defaultValue = "1") int page) {
		// 分页查询设置必须在查询方法执行前设定
		PageHelper.startPage(page, 5);
		List<Article> newArticles = am.selectNewArticle();
		// 将查询出的数据添加到 model 中 发送给页面
		m.addAttribute("newArticles", newArticles);
		m.addAttribute("categorys", cm.selectAll());
		return "index";
	}

}
