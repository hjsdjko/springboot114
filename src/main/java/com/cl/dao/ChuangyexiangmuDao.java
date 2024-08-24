package com.cl.dao;

import com.cl.entity.ChuangyexiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangyexiangmuView;


/**
 * 创业项目
 * 
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
public interface ChuangyexiangmuDao extends BaseMapper<ChuangyexiangmuEntity> {
	
	List<ChuangyexiangmuView> selectListView(@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);

	List<ChuangyexiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);
	
	ChuangyexiangmuView selectView(@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);
	
	List<ChuangyexiangmuView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);

}
