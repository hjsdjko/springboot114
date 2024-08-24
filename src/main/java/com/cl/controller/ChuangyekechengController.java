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

import com.cl.entity.ChuangyekechengEntity;
import com.cl.entity.view.ChuangyekechengView;

import com.cl.service.ChuangyekechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 创业课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
@RestController
@RequestMapping("/chuangyekecheng")
public class ChuangyekechengController {
    @Autowired
    private ChuangyekechengService chuangyekechengService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuangyekechengEntity chuangyekecheng,
		HttpServletRequest request){
        EntityWrapper<ChuangyekechengEntity> ew = new EntityWrapper<ChuangyekechengEntity>();

		PageUtils page = chuangyekechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyekecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChuangyekechengEntity chuangyekecheng, 
		HttpServletRequest request){
        EntityWrapper<ChuangyekechengEntity> ew = new EntityWrapper<ChuangyekechengEntity>();

		PageUtils page = chuangyekechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyekecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuangyekechengEntity chuangyekecheng){
       	EntityWrapper<ChuangyekechengEntity> ew = new EntityWrapper<ChuangyekechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuangyekecheng, "chuangyekecheng")); 
        return R.ok().put("data", chuangyekechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuangyekechengEntity chuangyekecheng){
        EntityWrapper< ChuangyekechengEntity> ew = new EntityWrapper< ChuangyekechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuangyekecheng, "chuangyekecheng")); 
		ChuangyekechengView chuangyekechengView =  chuangyekechengService.selectView(ew);
		return R.ok("查询创业课程成功").put("data", chuangyekechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuangyekechengEntity chuangyekecheng = chuangyekechengService.selectById(id);
		chuangyekecheng.setClicktime(new Date());
		chuangyekechengService.updateById(chuangyekecheng);
		chuangyekecheng = chuangyekechengService.selectView(new EntityWrapper<ChuangyekechengEntity>().eq("id", id));
        return R.ok().put("data", chuangyekecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuangyekechengEntity chuangyekecheng = chuangyekechengService.selectById(id);
		chuangyekecheng.setClicktime(new Date());
		chuangyekechengService.updateById(chuangyekecheng);
		chuangyekecheng = chuangyekechengService.selectView(new EntityWrapper<ChuangyekechengEntity>().eq("id", id));
        return R.ok().put("data", chuangyekecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuangyekechengEntity chuangyekecheng, HttpServletRequest request){
    	chuangyekecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangyekecheng);
        chuangyekechengService.insert(chuangyekecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuangyekechengEntity chuangyekecheng, HttpServletRequest request){
    	chuangyekecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangyekecheng);
        chuangyekechengService.insert(chuangyekecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChuangyekechengEntity chuangyekecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuangyekecheng);
        chuangyekechengService.updateById(chuangyekecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuangyekechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChuangyekechengEntity chuangyekecheng, HttpServletRequest request,String pre){
        EntityWrapper<ChuangyekechengEntity> ew = new EntityWrapper<ChuangyekechengEntity>();
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
		PageUtils page = chuangyekechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyekecheng), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ChuangyekechengEntity chuangyekecheng, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "kechengleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "chuangyekecheng").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ChuangyekechengEntity> chuangyekechengList = new ArrayList<ChuangyekechengEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                chuangyekechengList.addAll(chuangyekechengService.selectList(new EntityWrapper<ChuangyekechengEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ChuangyekechengEntity> ew = new EntityWrapper<ChuangyekechengEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = chuangyekechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyekecheng), params), params));
        List<ChuangyekechengEntity> pageList = (List<ChuangyekechengEntity>)page.getList();
        if(chuangyekechengList.size()<limit) {
            int toAddNum = (limit-chuangyekechengList.size())<=pageList.size()?(limit-chuangyekechengList.size()):pageList.size();
            for(ChuangyekechengEntity o1 : pageList) {
                boolean addFlag = true;
                for(ChuangyekechengEntity o2 : chuangyekechengList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    chuangyekechengList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(chuangyekechengList.size()>limit) {
            chuangyekechengList = chuangyekechengList.subList(0, limit);
        }
        page.setList(chuangyekechengList);
        return R.ok().put("data", page);
    }







}
