package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ChuangyexiangmuDao;
import com.cl.entity.ChuangyexiangmuEntity;
import com.cl.service.ChuangyexiangmuService;
import com.cl.entity.view.ChuangyexiangmuView;

@Service("chuangyexiangmuService")
public class ChuangyexiangmuServiceImpl extends ServiceImpl<ChuangyexiangmuDao, ChuangyexiangmuEntity> implements ChuangyexiangmuService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ChuangyexiangmuEntity> wrapper) {
		Page<ChuangyexiangmuView> page =new Query<ChuangyexiangmuView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuangyexiangmuEntity> page = this.selectPage(
                new Query<ChuangyexiangmuEntity>(params).getPage(),
                new EntityWrapper<ChuangyexiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuangyexiangmuEntity> wrapper) {
		  Page<ChuangyexiangmuView> page =new Query<ChuangyexiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChuangyexiangmuView> selectListView(Wrapper<ChuangyexiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuangyexiangmuView selectView(Wrapper<ChuangyexiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
