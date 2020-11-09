package com.easygo.controller;

import com.easygo.api.ContentClient;
import com.easygo.pojo.Content;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @BelongsProject: easygo
 * @BelongsPackage: com.easygo.controller
 * @Author: bruceliu
 * @QQ:1241488705
 * @CreateTime: 2020-03-30 15:03
 * @Description: TODO
 */
@Controller
@Scope("prototype")
public class ContentController {

    @Autowired
    ContentClient contentClient;

    //新增广告
    @RequestMapping("/content_add")
    @ResponseBody
    public MessageResults contentAdd(Content content){
        MessageResults results=null;
        System.out.println("新增的对象是："+content);
        Integer count = contentClient.addContent(content);
        if (count > 0) {
            results = new MessageResults(200, "新增成功");
        } else {
            results = new MessageResults(500, "新增失败");
        }
        return results;

    }

    /**
     * 修改广告的有效无效状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/content_updateStatus")
    @ResponseBody
    public MessageResults updateStatus(Integer id, Integer status) {
        MessageResults results=null;
        int count= contentClient.updateStatus(id, status);
        if (count > 0) {
            results = new MessageResults(200, "更新成功");
        } else {
            results = new MessageResults(500, "更新失败");
        }
        return results;
    }


    /**
     * 广告分页
     * @param pageIndex
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping("/content_page")
    public String getContent_page(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                  @RequestParam(defaultValue = "5", required = false) Integer pageSize, Model model) {
        PageUtils<Content> pageUtils = contentClient.getContent_page(pageIndex, pageSize);
        model.addAttribute("pageUtils",pageUtils);
        return "content";
    }

}
