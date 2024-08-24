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


import com.cl.dao.XiangmuleixingDao;
import com.cl.entity.XiangmuleixingEntity;
import com.cl.service.XiangmuleixingService;
import com.cl.entity.view.XiangmuleixingView;

@Service("xiangmuleixingService")
public class XiangmuleixingServiceImpl extends ServiceImpl<XiangmuleixingDao, XiangmuleixingEntity> implements XiangmuleixingService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<XiangmuleixingEntity> wrapper) {
		Page<XiangmuleixingView> page =new Query<XiangmuleixingView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmuleixingEntity> page = this.selectPage(
                new Query<XiangmuleixingEntity>(params).getPage(),
                new EntityWrapper<XiangmuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmuleixingEntity> wrapper) {
		  Page<XiangmuleixingView> page =new Query<XiangmuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiangmuleixingView> selectListView(Wrapper<XiangmuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmuleixingView selectView(Wrapper<XiangmuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
