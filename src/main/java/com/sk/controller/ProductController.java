package com.sk.controller;


import com.github.pagehelper.PageInfo;
import com.sk.domain.Category;
import com.sk.domain.Product;
import com.sk.domain.Supplier;
import com.sk.service.CategoryService;
import com.sk.service.ProductService;
import com.sk.service.SupplierService;
import com.sk.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SupplierService supplierService;


    //更新商品
    @PostMapping("/updateProduct")
    public String updateProduct(Product product, Integer pn, Model model) {
        int amount = product.getSalePrice().compareTo(BigDecimal.ZERO);
        if (amount < 0) {
            model.addAttribute("addProductMsg","销售单价不能小于等于零");
            return "product/product_modify";
        }
        productService.updateProduct(product);
        PageInfo<Product> productPageInfo = productService.selectByExampleWithOtherMsg(pn);
        model.addAttribute("productPageInfo", productPageInfo);
        return queryAllCategory(pn, null, model);
    }


    //跳转到更新商品页面
    @GetMapping("/toUpdateProduct")
    public String toUpdatePage(Integer productId, Integer pageNum, Model model) {
        Product product = productService.selectByPrimaryKey(productId);
        //查询所有品类和供给商信息，用于显示下拉列表框
        List<Category> categories = categoryService.queryAllCategory();
        List<Supplier> suppliers = supplierService.queryAllSupplier();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("categories", categories);
        //回显旧数据
        model.addAttribute("product", product);
        //保存要修改的记录的页码，用于更新完成后的跳转
        model.addAttribute("pageNum", pageNum);
        return "product/product_modify";
    }

    //删除品类
    @DeleteMapping("/deleteProduct/{id}")
    public CommonResult deleteProductById(@PathVariable Integer id) {
        int i = productService.deleteProductById(id);
        if (i > 0){
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    /**
     * productName不为空，查询单挑，否则查询所有
     *
     * @param pn
     * @param productName
     * @param model
     * @return
     */
    @GetMapping("/queryAllProduct")
    public String queryAllCategory(@RequestParam(name = "pn", defaultValue = "1") Integer pn, String productName, Model model) {
        if (productName == null) {
            PageInfo<Product> productPageInfo = productService.selectByExampleWithOtherMsg(pn);
            model.addAttribute("productPageInfo", productPageInfo);
            return "product/product_list";
        }
        PageInfo<Product> productPageInfo = productService.queryProductByName(productName);
        model.addAttribute("productPageInfo", productPageInfo);
        return "product/product_list";
    }

}
