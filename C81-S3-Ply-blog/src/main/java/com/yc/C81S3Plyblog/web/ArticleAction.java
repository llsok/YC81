package com.yc.C81S3Plyblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleAction {
	
	@GetMapping("toAddArticle")
	public String toAddArticle() {
		return "addArticle";
	}

}
