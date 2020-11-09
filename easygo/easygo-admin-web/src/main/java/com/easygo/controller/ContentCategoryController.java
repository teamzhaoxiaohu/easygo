package com.easygo.controller;

import com.easygo.api.ContentCategoryClient;
import com.easygo.pojo.ContentCategory;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @BelongsProject: easygo
 * @BelongsPackage: com.easygo.controller
 * @Author: bruceliu
 * @QQ:1241488705
 * @CreateTime: 2020-03-30 10:53
 * @Description: TODO
 */
@Controller
@Scope("prototype")
public class ContentCategoryController {

    @Autowired
    ContentCategoryClient contentCategoryClient;

    /**
     * 03-更新广告分类
     * @param category
     * @return
     */
    @RequestMapping("/contentCategory_update")
    @ResponseBody
    public MessageResults contentCategory_update(ContentCategory category){
        int count = contentCategoryClient.updateContentCategory(category);
        MessageResults results = null;
        if (count > 0) {
            results = new MessageResults(200, "更新成功");
        } else {
            results = new MessageResults(500, "更新失败");
        }
        return results;
    }

    @RequestMapping("/contentCategory_getById")
    @ResponseBody
    public ContentCategory contentCategory_getById(Integer id){
        System.out.println("查询ID是:"+id);
        return contentCategoryClient.getById(id);
    }

    /**
     * 02-新增广告分类
     * @param category
     * @return
     */
    @RequestMapping("/contentCategory_add")
    @ResponseBody
    public MessageResults contentCategory_add(ContentCategory category){
        int count = contentCategoryClient.addContentCategory(category);
        MessageResults results = null;
        if (count > 0) {
            results = new MessageResults(200, "新增成功");
        } else {
            results = new MessageResults(500, "新增失败");
        }
        return results;
    }

    /**
     * 01-广告分类列表
     * @param pageIndex
     * @param pageSize
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/contentCategory_page")
    public String getcontentCategorys(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false) Integer pageSize,
                                      @RequestParam(defaultValue = "",required = false) String name, Model model){
        System.out.println("pageIndex="+pageIndex);
        System.out.println("pageSize="+pageSize);
        System.out.println("name="+name);
        PageUtils<ContentCategory> pageUtils = contentCategoryClient.getcontentCategorys(pageIndex, pageSize, name);
        model.addAttribute("pageUtils",pageUtils);
        //回显搜素条件
        model.addAttribute("name",name);
        return "content_category";
    }

    /**
     * 01-下拉框数据
     * @return
     */
    @RequestMapping("/contentCategory_list")
    @ResponseBody
    public List<ContentCategory> getContentCategorys(){
        return contentCategoryClient.getContentCategorys();
    }


}
