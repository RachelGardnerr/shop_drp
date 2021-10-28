package com.sk.controller;

import com.github.pagehelper.PageInfo;
import com.sk.domain.Category;
import com.sk.service.CategoryService;
import com.sk.vo.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //删除品类
    @DeleteMapping(value = "/deleteCategory/{id}" )
    @ResponseBody
    public CommonResult deleteCategoryById(@PathVariable Integer id) {
        if (categoryService.deleteCateById(id) > 0) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    //跳转到更新品类页面
    @GetMapping("/toUpdateCategory")
    public String toUpdatePage(Integer categoryId, Integer pn, Model model) {
        Category category = categoryService.queryCategoryById(categoryId);
        model.addAttribute("category", category);
        model.addAttribute("pageNum", pn);
        return "category/category_modify";
    }

    //更新品类
    @GetMapping("/updateCategory")
    public String updateCategory(@Param("categoryName") String categoryName,
                                 @Param("id") Integer id, Model model) {
        if (categoryName == null || categoryName.equals("")) {
            model.addAttribute("updateCategoryMsg", "名称不能为空");
            return "category/category_modify";
        }
        categoryService.updateCategoryById(categoryName, id);
        return "redirect:/queryAllCategory";
    }

    //查询所有品类
    @GetMapping("/queryAllCategory")
    public String queryAllCategory(@RequestParam(name = "pn", defaultValue = "1") Integer pn, String categoryName, Model model) {
        if (categoryName == null) {
            PageInfo<Category> categoryPageInfo = categoryService.queryAllCategory(pn);
            model.addAttribute("categoryPageInfo", categoryPageInfo);
            return "category/category_list";
        }
        PageInfo<Category> categoryPageInfo = categoryService.queryCateByName(categoryName);
        model.addAttribute("categoryPageInfo", categoryPageInfo);
        return "category/category_list";
    }

    //检查品类是否重复
    @RequestMapping("/checkCategoryName")
    @ResponseBody
    public CommonResult checkName(String name) {
        List<Category> categories = categoryService.queryCategoryByName(name);
        if (categories.isEmpty()) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    //添加品类`
    @PostMapping("/addCategoryList")
    @ResponseBody
    public CommonResult addCategory(Category category) {
        if (category.getCategoryName().equals("") || category.getCategoryName() == null) {
            return CommonResult.fail();
        }
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        category.setDeleted(true);
        categoryService.addCategory(category);
        return CommonResult.success();
    }


}
