package com.zhutao.learn.springmvc.common.mybatis.pojo;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * 通过注解@Valid进行验证
 * - 灵活性差
 * - 不适合自定义
 * @Author: zhutao
 * @Date: 2019/2/20 22:58
 * @Version 1.0
 */
public class ValidatorPojo {
    @NotNull(message = "id不能为空")
    private Long id;

    @Future(message = "需要一个将来日期")
//    @Past(message = "需要一个过去日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "日期不能为空")
    private Date date;

    @NotNull(message = "不能为空")
    @DecimalMax(value = "1000")
    @DecimalMin(value = "0.1")
    private double number;

    @NotNull
    @Min(value = 1, message = "最小值为1")
    @Max(value = 1999)
    private Integer integer;

    @Range(min = 1L, max = 100L, message = "范围为1-100间的整数")
    private Long range;

    @Size(min = 5, max = 10, message = "长度要求在5到10之间")
    private String size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Long getRange() {
        return range;
    }

    public void setRange(Long range) {
        this.range = range;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
