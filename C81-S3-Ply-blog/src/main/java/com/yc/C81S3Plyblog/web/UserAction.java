package com.yc.C81S3Plyblog.web;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;

import com.yc.C81S3Plyblog.bean.Result;
import com.yc.C81S3Plyblog.bean.User;

@RestController  // json
public class UserAction {
	
	public Result login(@Valid User user, Errors errors) {
		
		// 用户输入验证
		if(errors.hasFieldErrors("account") || errors.hasFieldErrors("pwd")) {
			return new Result(0, "字段验证错误", errors.getAllErrors());
		}
		
		// 业务逻辑验证
		
		return null;
	}
	
	
	public void register() {
		
	}

}
