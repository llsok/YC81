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

	/**
	 *  ?page=2  =>   http://127.0.0.1/index.html?page=2
	 *  jquery ias 无限加载插件 以ajax 方法发起 http 请求， 请求一个页面 => HTML 代码
	 *  ias 会将html中的第二页的内容解析出来，追加到文章列表中
	 */
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

	@GetMapping("article.html")
	public String article(int id, Model m) {
		m.addAttribute("article", am.selectById(id));
		return "article";
	}

}
