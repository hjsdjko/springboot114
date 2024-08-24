package com.cl.dao;

import com.cl.entity.ChuangyeziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangyeziyuanView;


/**
 * 创业资源
 * 
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
public interface ChuangyeziyuanDao extends BaseMapper<ChuangyeziyuanEntity> {
	
	List<ChuangyeziyuanView> selectListView(@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);

	List<ChuangyeziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);
	
	ChuangyeziyuanView selectView(@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);
	
	List<ChuangyeziyuanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);

}
