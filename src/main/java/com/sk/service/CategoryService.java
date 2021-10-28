package com.sk.service;

import com.github.pagehelper.PageInfo;
import com.sk.domain.Category;

import java.util.List;


public interface CategoryService {


    /**
     * 查询所有品类
     *
     * @return PageInfo<Category>
     */
    PageInfo<Category> queryAllCategory(Integer pn);


    List<Category> queryAllCategory();

    /**
     * @param name
     * @returnPageInfo<Category>
     */
    PageInfo<Category> queryCateByName(String name);

    /**
     * 根据名称查询记录
     *
     * @param name
     * @return List<Category>
     */
    List<Category> queryCategoryByName(String name);

    /**
     * @param categoryId
     * @return Category
     */
    Category queryCategoryById(Integer categoryId);

    /**
     * 添加品类
     *
     * @param category
     * @return
     */
    int addCategory(Category category);

    /**
     * 更新品类信息
     *
     * @param categoryName
     * @return
     */
    int updateCategoryById(String categoryName, Integer id);

    /**
     *
     * @param id
     * @return
     */
    int deleteCateById(Integer id);

}
