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
 * 创业资源
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
@TableName("chuangyeziyuan")
public class ChuangyeziyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChuangyeziyuanEntity() {
		
	}
	
	public ChuangyeziyuanEntity(T t) {
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
	 * 资源名称
	 */
					
	private String ziyuanmingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 资源类型
	 */
					
	private String ziyuanleixing;
	
	/**
	 * 资源简介
	 */
					
	private String ziyuanjianjie;
	
	/**
	 * 资源祥情
	 */
					
	private String ziyuanxiangqing;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
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
	 * 设置：资源名称
	 */
	public void setZiyuanmingcheng(String ziyuanmingcheng) {
		this.ziyuanmingcheng = ziyuanmingcheng;
	}
	/**
	 * 获取：资源名称
	 */
	public String getZiyuanmingcheng() {
		return ziyuanmingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：资源类型
	 */
	public void setZiyuanleixing(String ziyuanleixing) {
		this.ziyuanleixing = ziyuanleixing;
	}
	/**
	 * 获取：资源类型
	 */
	public String getZiyuanleixing() {
		return ziyuanleixing;
	}
	/**
	 * 设置：资源简介
	 */
	public void setZiyuanjianjie(String ziyuanjianjie) {
		this.ziyuanjianjie = ziyuanjianjie;
	}
	/**
	 * 获取：资源简介
	 */
	public String getZiyuanjianjie() {
		return ziyuanjianjie;
	}
	/**
	 * 设置：资源祥情
	 */
	public void setZiyuanxiangqing(String ziyuanxiangqing) {
		this.ziyuanxiangqing = ziyuanxiangqing;
	}
	/**
	 * 获取：资源祥情
	 */
	public String getZiyuanxiangqing() {
		return ziyuanxiangqing;
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

}
