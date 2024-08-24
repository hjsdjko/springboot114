package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 创业课程
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
@TableName("chuangyekecheng")
public class ChuangyekechengEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChuangyekechengEntity() {
		
	}
	
	public ChuangyekechengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 课程名称
	 */
					
	private String kechengmingcheng;
	
	/**
	 * 课程封面
	 */
					
	private String kechengfengmian;
	
	/**
	 * 课程类型
	 */
					
	private String kechengleixing;
	
	/**
	 * 课程简介
	 */
					
	private String kechengjianjie;
	
	/**
	 * 授课教师
	 */
					
	private String shoukejiaoshi;
	
	/**
	 * 授课时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shoukeshijian;
	
	/**
	 * 授课地点
	 */
					
	private String shoukedidian;
	
	/**
	 * 授课内容
	 */
					
	private String shoukeneirong;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：课程名称
	 */
	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}
	/**
	 * 获取：课程名称
	 */
	public String getKechengmingcheng() {
		return kechengmingcheng;
	}
	/**
	 * 设置：课程封面
	 */
	public void setKechengfengmian(String kechengfengmian) {
		this.kechengfengmian = kechengfengmian;
	}
	/**
	 * 获取：课程封面
	 */
	public String getKechengfengmian() {
		return kechengfengmian;
	}
	/**
	 * 设置：课程类型
	 */
	public void setKechengleixing(String kechengleixing) {
		this.kechengleixing = kechengleixing;
	}
	/**
	 * 获取：课程类型
	 */
	public String getKechengleixing() {
		return kechengleixing;
	}
	/**
	 * 设置：课程简介
	 */
	public void setKechengjianjie(String kechengjianjie) {
		this.kechengjianjie = kechengjianjie;
	}
	/**
	 * 获取：课程简介
	 */
	public String getKechengjianjie() {
		return kechengjianjie;
	}
	/**
	 * 设置：授课教师
	 */
	public void setShoukejiaoshi(String shoukejiaoshi) {
		this.shoukejiaoshi = shoukejiaoshi;
	}
	/**
	 * 获取：授课教师
	 */
	public String getShoukejiaoshi() {
		return shoukejiaoshi;
	}
	/**
	 * 设置：授课时间
	 */
	public void setShoukeshijian(Date shoukeshijian) {
		this.shoukeshijian = shoukeshijian;
	}
	/**
	 * 获取：授课时间
	 */
	public Date getShoukeshijian() {
		return shoukeshijian;
	}
	/**
	 * 设置：授课地点
	 */
	public void setShoukedidian(String shoukedidian) {
		this.shoukedidian = shoukedidian;
	}
	/**
	 * 获取：授课地点
	 */
	public String getShoukedidian() {
		return shoukedidian;
	}
	/**
	 * 设置：授课内容
	 */
	public void setShoukeneirong(String shoukeneirong) {
		this.shoukeneirong = shoukeneirong;
	}
	/**
	 * 获取：授课内容
	 */
	public String getShoukeneirong() {
		return shoukeneirong;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
