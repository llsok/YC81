package com.yc.C81S3Plyblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C81S3Plyblog.bean.User;
import com.yc.C81S3Plyblog.dao.UserMapper;

@Service // 语义组件注解
public class UserBiz {

	@Resource
	private UserMapper um;

	/**
	 * 登录方法
	 * @param user 用户提交的数据
	 * @return		查询到的用户信息
	 * @throws BizException 
	 */
	public User login(User user) throws BizException {
		User dbuser = um.selectByAccountAndPwd(user);
		if (dbuser == null) {
			throw new BizException("用户名或密码错误");
		}
		return dbuser;
	}

	public User register(User user) throws BizException {
		if (um.countByAccount(user) > 0) {
			throw new BizException("该用户已经存在");
		}
		return null;
	}

}
