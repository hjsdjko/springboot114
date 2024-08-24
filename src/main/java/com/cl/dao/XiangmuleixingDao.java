package com.cl.dao;

import com.cl.entity.XiangmuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmuleixingView;


/**
 * 项目类型
 * 
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
public interface XiangmuleixingDao extends BaseMapper<XiangmuleixingEntity> {
	
	List<XiangmuleixingView> selectListView(@Param("ew") Wrapper<XiangmuleixingEntity> wrapper);

	List<XiangmuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmuleixingEntity> wrapper);
	
	XiangmuleixingView selectView(@Param("ew") Wrapper<XiangmuleixingEntity> wrapper);
	
	List<XiangmuleixingView> selectGroupBy(Pagination page,@Param("ew") Wrapper<XiangmuleixingEntity> wrapper);

}
