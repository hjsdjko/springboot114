package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChuangyekechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangyekechengView;


/**
 * 创业课程
 *
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
public interface ChuangyekechengService extends IService<ChuangyekechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuangyekechengView> selectListView(Wrapper<ChuangyekechengEntity> wrapper);
   	
   	ChuangyekechengView selectView(@Param("ew") Wrapper<ChuangyekechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuangyekechengEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ChuangyekechengEntity> wrapper);

}

