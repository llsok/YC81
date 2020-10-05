package com.yc.C81S3Plyblog.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.C81S3Plyblog.bean.Article;
import com.yc.C81S3Plyblog.bean.User;
import com.yc.C81S3Plyblog.dao.ArticleMapper;
import com.yc.C81S3Plyblog.dao.CategoryMapper;

@Controller
public class ArticleAction {
	
	@Resource
	private ArticleMapper am;
	@Resource
	private CategoryMapper cm;
	
	@GetMapping("toAddArticle")
	public String toAddArticle(Model m) {
		m.addAttribute("cList", cm.selectAll());
		return "addArticle";
	}
	
	@PostMapping("addArticle")
	public String addArticle(Article article, @SessionAttribute User loginedUser) {
		/**
		 * 业务层暂时省略, 字段验证
		 */
		// 作者名字
		article.setAuthor(loginedUser.getName());
		am.insert(article);
		// 响应重定向跳转到文章详情
		return "redirect:article.html?id=" + article.getId();
	}

}
