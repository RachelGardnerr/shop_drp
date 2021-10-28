package com.sk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.dao.CategoryMapper;
import com.sk.domain.Category;
import com.sk.domain.CategoryExample;
import com.sk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public int deleteCateById(Integer id) {
        if (id != null){
            return categoryMapper.deleteCategoryById(id);
        }
        return 0;
    }

    @Override
    public PageInfo<Category> queryCateByName(String name) {
        if (name != null){
            CategoryExample example = new CategoryExample();
            CategoryExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryNameEqualTo(name);
            return new PageInfo<>(categoryMapper.selectByExample(example));
        }
        return null;
    }

    @Override
    public Category queryCategoryById(Integer categoryId) {
        if (categoryId != null){
            return categoryMapper.selectByPrimaryKey(categoryId);
        }
        return null;
    }

    @Override
    public int updateCategoryById(String categoryName,Integer id) {
        if (categoryName != null || id != null) {
            categoryMapper.updateCategoryById(categoryName,id);
        }
        return 0;
    }




    @Override
    public PageInfo<Category> queryAllCategory(Integer pn) {
        PageHelper.startPage(pn,8);
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(true);
        return new PageInfo<>(categoryMapper.selectByExample(example));
    }

    @Override
    public List<Category> queryCategoryByName(String name) {
        if (name != null) {

            CategoryExample example = new CategoryExample();
            CategoryExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryNameEqualTo(name);
            return categoryMapper.selectByExample(example);
        }
        return Collections.emptyList();
    }

    @Override
    public int addCategory(Category category) {
        if (category != null){
            categoryMapper.insertSelective(category);
        }
        return -1;
    }
}
