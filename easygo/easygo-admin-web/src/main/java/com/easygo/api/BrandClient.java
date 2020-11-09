package com.easygo.api;

import com.easygo.pojo.Brand;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @BelongsProject: easygo
 * @BelongsPackage: com.easygo.api
 * @Author: bruceliu
 * @QQ:1241488705
 * @CreateTime: 2020-03-27 11:26
 * @Description: TODO
 */
@FeignClient(value = "easygo-brand-service")
public interface BrandClient {

    @RequestMapping("/brand_page")
    public PageUtils getBrandsByPage(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false) Integer pageSize);

    @RequestMapping("/brand_getBrands")
    public List<Brand> getBrands();

    @RequestMapping("/brand_add")
    public int addBrand(@RequestBody Brand brand);

    @RequestMapping("/brand_getBrandById")
    public Brand getBrandById(@RequestParam Integer id);

    @RequestMapping("/brand_updateBrand")
    public int updateBrand(@RequestBody Brand brand);

    @RequestMapping("/brand_delete")
    public int deleteBrand(@RequestParam Integer id);

    @RequestMapping("/brand_deleteSome")
    public int deleteSome(@RequestParam String ids);
}
