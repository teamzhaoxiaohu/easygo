package com.easygo.service;

import com.easygo.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: easygo
 * @BelongsPackage: com.easygo.service
 * @Author: bruceliu
 * @QQ:1241488705
 * @CreateTime: 2020-03-27 11:00
 * @Description: TODO
 */
public interface BrandService {

    public List<Brand> getBrands();

    public int addBrand(Brand brand);

    public int updateBrand(Brand brand);

    public Brand getBrandById(Integer id);

    public int deleteBrand(Integer id);

    public int deleteSome(String ids);

    //查询总条数(没有条件)
    public int getTotalCount();

    //查询每页的数据(没有条件)
    public List<Brand> getPageBrands(Map<String,Object> map);
}
