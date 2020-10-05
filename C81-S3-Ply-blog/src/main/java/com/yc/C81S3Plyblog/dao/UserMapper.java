package com.yc.C81S3Plyblog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.C81S3Plyblog.bean.User;

public interface UserMapper {

	@Select("select count(*) from user where account = #{account}")
	int countByAccount(User user);

	@Select("select * from user where account = #{account} and pwd = #{pwd}")
	User selectByAccountAndPwd(User user);

	@Insert("insert into user values (null,#{name},#{account},#{pwd},#{phone},"
			+ "#{email},#{head},#{createtime},#{status},#{type})")
	void insert(User user);

	@Select("select * from user where account = #{account}")
	@Results(id = "umrm", value = { @Result(column = "pwd_question", property = "pwdQuestion"),
			@Result(column = "pwd_answer", property = "pwdAnswer") })
	User selectByAccount(String account);

	@Select("select * from user where account = #{account} and pwd_answer=#{pwdAnswer}")
	@ResultMap("umrm")
	User selectByAccountAndPwdAnswer(@Param("account") String account, @Param("pwdAnswer") String pwdAnswer);

	@Update("update user set pwd=#{pwd} where account=#{account}")
	void resetPwd(@Param("account")String account, @Param("pwd")String pwd);

}
