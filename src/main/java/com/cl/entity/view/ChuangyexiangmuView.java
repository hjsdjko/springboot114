package com.cl.entity.view;

import com.cl.entity.ChuangyexiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 创业项目
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
@TableName("chuangyexiangmu")
public class ChuangyexiangmuView  extends ChuangyexiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChuangyexiangmuView(){
	}
 
 	public ChuangyexiangmuView(ChuangyexiangmuEntity chuangyexiangmuEntity){
 	try {
			BeanUtils.copyProperties(this, chuangyexiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
