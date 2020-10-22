package com.my.entity;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;


@Data
public class Users {
 
	/** id */
	@NotNull(message="id不能为空")
	private Long id;
	
	/** 姓名 */
	@NotBlank(message="姓名不能为空")
	private String name;
	
	/** 年龄 */
	@NotNull(message="年龄不能为空")
	@Max(message="年龄不能超过120岁", value = 120)
	@Min(message="年龄不能小于1岁", value = 1)
	private Integer age;
	
	/** 创建时间 */
	@Future
	private Date createTime;
}