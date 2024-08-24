package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiangmuleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmuleixingView;


/**
 * 项目类型
 *
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
public interface XiangmuleixingService extends IService<XiangmuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmuleixingView> selectListView(Wrapper<XiangmuleixingEntity> wrapper);
   	
   	XiangmuleixingView selectView(@Param("ew") Wrapper<XiangmuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmuleixingEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<XiangmuleixingEntity> wrapper);

}

