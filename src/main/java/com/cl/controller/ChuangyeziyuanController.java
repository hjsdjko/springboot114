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

import com.cl.entity.ChuangyeziyuanEntity;
import com.cl.entity.view.ChuangyeziyuanView;

import com.cl.service.ChuangyeziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 创业资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 13:54:18
 */
@RestController
@RequestMapping("/chuangyeziyuan")
public class ChuangyeziyuanController {
    @Autowired
    private ChuangyeziyuanService chuangyeziyuanService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuangyeziyuanEntity chuangyeziyuan,
		HttpServletRequest request){
        EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();

		PageUtils page = chuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyeziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChuangyeziyuanEntity chuangyeziyuan, 
		HttpServletRequest request){
        EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();

		PageUtils page = chuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyeziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuangyeziyuanEntity chuangyeziyuan){
       	EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuangyeziyuan, "chuangyeziyuan")); 
        return R.ok().put("data", chuangyeziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuangyeziyuanEntity chuangyeziyuan){
        EntityWrapper< ChuangyeziyuanEntity> ew = new EntityWrapper< ChuangyeziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuangyeziyuan, "chuangyeziyuan")); 
		ChuangyeziyuanView chuangyeziyuanView =  chuangyeziyuanService.selectView(ew);
		return R.ok("查询创业资源成功").put("data", chuangyeziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuangyeziyuanEntity chuangyeziyuan = chuangyeziyuanService.selectById(id);
		chuangyeziyuan.setClicktime(new Date());
		chuangyeziyuanService.updateById(chuangyeziyuan);
		chuangyeziyuan = chuangyeziyuanService.selectView(new EntityWrapper<ChuangyeziyuanEntity>().eq("id", id));
        return R.ok().put("data", chuangyeziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuangyeziyuanEntity chuangyeziyuan = chuangyeziyuanService.selectById(id);
		chuangyeziyuan.setClicktime(new Date());
		chuangyeziyuanService.updateById(chuangyeziyuan);
		chuangyeziyuan = chuangyeziyuanService.selectView(new EntityWrapper<ChuangyeziyuanEntity>().eq("id", id));
        return R.ok().put("data", chuangyeziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request){
    	chuangyeziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangyeziyuan);
        chuangyeziyuanService.insert(chuangyeziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request){
    	chuangyeziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangyeziyuan);
        chuangyeziyuanService.insert(chuangyeziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuangyeziyuan);
        chuangyeziyuanService.updateById(chuangyeziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuangyeziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request,String pre){
        EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();
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
		PageUtils page = chuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyeziyuan), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "ziyuanmingcheng";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "chuangyeziyuan").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ChuangyeziyuanEntity> chuangyeziyuanList = new ArrayList<ChuangyeziyuanEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                chuangyeziyuanList.addAll(chuangyeziyuanService.selectList(new EntityWrapper<ChuangyeziyuanEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = chuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyeziyuan), params), params));
        List<ChuangyeziyuanEntity> pageList = (List<ChuangyeziyuanEntity>)page.getList();
        if(chuangyeziyuanList.size()<limit) {
            int toAddNum = (limit-chuangyeziyuanList.size())<=pageList.size()?(limit-chuangyeziyuanList.size()):pageList.size();
            for(ChuangyeziyuanEntity o1 : pageList) {
                boolean addFlag = true;
                for(ChuangyeziyuanEntity o2 : chuangyeziyuanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    chuangyeziyuanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(chuangyeziyuanList.size()>limit) {
            chuangyeziyuanList = chuangyeziyuanList.subList(0, limit);
        }
        page.setList(chuangyeziyuanList);
        return R.ok().put("data", page);
    }







}
