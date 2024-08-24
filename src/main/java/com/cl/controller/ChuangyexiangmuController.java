package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ChuangyexiangmuEntity;
import com.cl.entity.view.ChuangyexiangmuView;

import com.cl.service.ChuangyexiangmuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 创业项目
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
@RestController
@RequestMapping("/chuangyexiangmu")
public class ChuangyexiangmuController {
    @Autowired
    private ChuangyexiangmuService chuangyexiangmuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuangyexiangmuEntity chuangyexiangmu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			chuangyexiangmu.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChuangyexiangmuEntity> ew = new EntityWrapper<ChuangyexiangmuEntity>();

		PageUtils page = chuangyexiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyexiangmu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChuangyexiangmuEntity chuangyexiangmu, 
		HttpServletRequest request){
        EntityWrapper<ChuangyexiangmuEntity> ew = new EntityWrapper<ChuangyexiangmuEntity>();

		PageUtils page = chuangyexiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyexiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuangyexiangmuEntity chuangyexiangmu){
       	EntityWrapper<ChuangyexiangmuEntity> ew = new EntityWrapper<ChuangyexiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuangyexiangmu, "chuangyexiangmu")); 
        return R.ok().put("data", chuangyexiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuangyexiangmuEntity chuangyexiangmu){
        EntityWrapper< ChuangyexiangmuEntity> ew = new EntityWrapper< ChuangyexiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuangyexiangmu, "chuangyexiangmu")); 
		ChuangyexiangmuView chuangyexiangmuView =  chuangyexiangmuService.selectView(ew);
		return R.ok("查询创业项目成功").put("data", chuangyexiangmuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuangyexiangmuEntity chuangyexiangmu = chuangyexiangmuService.selectById(id);
		chuangyexiangmu.setClicktime(new Date());
		chuangyexiangmuService.updateById(chuangyexiangmu);
		chuangyexiangmu = chuangyexiangmuService.selectView(new EntityWrapper<ChuangyexiangmuEntity>().eq("id", id));
        return R.ok().put("data", chuangyexiangmu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuangyexiangmuEntity chuangyexiangmu = chuangyexiangmuService.selectById(id);
		chuangyexiangmu.setClicktime(new Date());
		chuangyexiangmuService.updateById(chuangyexiangmu);
		chuangyexiangmu = chuangyexiangmuService.selectView(new EntityWrapper<ChuangyexiangmuEntity>().eq("id", id));
        return R.ok().put("data", chuangyexiangmu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuangyexiangmuEntity chuangyexiangmu, HttpServletRequest request){
    	chuangyexiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangyexiangmu);
        chuangyexiangmuService.insert(chuangyexiangmu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuangyexiangmuEntity chuangyexiangmu, HttpServletRequest request){
    	chuangyexiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangyexiangmu);
        chuangyexiangmuService.insert(chuangyexiangmu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChuangyexiangmuEntity chuangyexiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuangyexiangmu);
        chuangyexiangmuService.updateById(chuangyexiangmu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuangyexiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChuangyexiangmuEntity chuangyexiangmu, HttpServletRequest request,String pre){
        EntityWrapper<ChuangyexiangmuEntity> ew = new EntityWrapper<ChuangyexiangmuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = chuangyexiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyexiangmu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ChuangyexiangmuEntity chuangyexiangmu, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "xiangmumingcheng";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "chuangyexiangmu").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ChuangyexiangmuEntity> chuangyexiangmuList = new ArrayList<ChuangyexiangmuEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                chuangyexiangmuList.addAll(chuangyexiangmuService.selectList(new EntityWrapper<ChuangyexiangmuEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ChuangyexiangmuEntity> ew = new EntityWrapper<ChuangyexiangmuEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = chuangyexiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyexiangmu), params), params));
        List<ChuangyexiangmuEntity> pageList = (List<ChuangyexiangmuEntity>)page.getList();
        if(chuangyexiangmuList.size()<limit) {
            int toAddNum = (limit-chuangyexiangmuList.size())<=pageList.size()?(limit-chuangyexiangmuList.size()):pageList.size();
            for(ChuangyexiangmuEntity o1 : pageList) {
                boolean addFlag = true;
                for(ChuangyexiangmuEntity o2 : chuangyexiangmuList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    chuangyexiangmuList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(chuangyexiangmuList.size()>limit) {
            chuangyexiangmuList = chuangyexiangmuList.subList(0, limit);
        }
        page.setList(chuangyexiangmuList);
        return R.ok().put("data", page);
    }







}
