package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChuangyeziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangyeziyuanView;


/**
 * 创业资源
 *
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
public interface ChuangyeziyuanService extends IService<ChuangyeziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuangyeziyuanView> selectListView(Wrapper<ChuangyeziyuanEntity> wrapper);
   	
   	ChuangyeziyuanView selectView(@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuangyeziyuanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ChuangyeziyuanEntity> wrapper);

}

