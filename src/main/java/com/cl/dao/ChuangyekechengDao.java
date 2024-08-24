package com.cl.dao;

import com.cl.entity.ChuangyekechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangyekechengView;


/**
 * 创业课程
 * 
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
public interface ChuangyekechengDao extends BaseMapper<ChuangyekechengEntity> {
	
	List<ChuangyekechengView> selectListView(@Param("ew") Wrapper<ChuangyekechengEntity> wrapper);

	List<ChuangyekechengView> selectListView(Pagination page,@Param("ew") Wrapper<ChuangyekechengEntity> wrapper);
	
	ChuangyekechengView selectView(@Param("ew") Wrapper<ChuangyekechengEntity> wrapper);
	
	List<ChuangyekechengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ChuangyekechengEntity> wrapper);

}
