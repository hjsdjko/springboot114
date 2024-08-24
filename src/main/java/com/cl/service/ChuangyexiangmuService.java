package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChuangyexiangmuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangyexiangmuView;


/**
 * 创业项目
 *
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
public interface ChuangyexiangmuService extends IService<ChuangyexiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuangyexiangmuView> selectListView(Wrapper<ChuangyexiangmuEntity> wrapper);
   	
   	ChuangyexiangmuView selectView(@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuangyexiangmuEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ChuangyexiangmuEntity> wrapper);

}

