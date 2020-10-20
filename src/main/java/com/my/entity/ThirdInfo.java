package com.my.entity;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author hutf
 * @createTime 2020年10月17日 23:03:00
 */
public class ThirdInfo {
    @NotEmpty(message = "id 不能为空")
    private String id;

    @NotEmpty(message = "name 不能为空")
    private String name;

    @DecimalMax(value = "100",message = "age 不能超过 100 ")
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
