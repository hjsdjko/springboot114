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


import com.cl.dao.ChuangyeziyuanDao;
import com.cl.entity.ChuangyeziyuanEntity;
import com.cl.service.ChuangyeziyuanService;
import com.cl.entity.view.ChuangyeziyuanView;

@Service("chuangyeziyuanService")
public class ChuangyeziyuanServiceImpl extends ServiceImpl<ChuangyeziyuanDao, ChuangyeziyuanEntity> implements ChuangyeziyuanService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ChuangyeziyuanEntity> wrapper) {
		Page<ChuangyeziyuanView> page =new Query<ChuangyeziyuanView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuangyeziyuanEntity> page = this.selectPage(
                new Query<ChuangyeziyuanEntity>(params).getPage(),
                new EntityWrapper<ChuangyeziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuangyeziyuanEntity> wrapper) {
		  Page<ChuangyeziyuanView> page =new Query<ChuangyeziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChuangyeziyuanView> selectListView(Wrapper<ChuangyeziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuangyeziyuanView selectView(Wrapper<ChuangyeziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
