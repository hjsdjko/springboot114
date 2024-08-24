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


import com.cl.dao.ChuangyekechengDao;
import com.cl.entity.ChuangyekechengEntity;
import com.cl.service.ChuangyekechengService;
import com.cl.entity.view.ChuangyekechengView;

@Service("chuangyekechengService")
public class ChuangyekechengServiceImpl extends ServiceImpl<ChuangyekechengDao, ChuangyekechengEntity> implements ChuangyekechengService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ChuangyekechengEntity> wrapper) {
		Page<ChuangyekechengView> page =new Query<ChuangyekechengView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuangyekechengEntity> page = this.selectPage(
                new Query<ChuangyekechengEntity>(params).getPage(),
                new EntityWrapper<ChuangyekechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuangyekechengEntity> wrapper) {
		  Page<ChuangyekechengView> page =new Query<ChuangyekechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChuangyekechengView> selectListView(Wrapper<ChuangyekechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuangyekechengView selectView(Wrapper<ChuangyekechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
