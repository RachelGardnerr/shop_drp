package com.sk.controller;

import com.github.pagehelper.PageInfo;
import com.sk.domain.Supplier;
import com.sk.service.SupplierService;
import com.sk.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/deleteSupplier/{id}")
    @ResponseBody
    public CommonResult deleteSupplier(@PathVariable Integer id){
        int i = supplierService.deleteSupplier(id);
        if (i > 0){
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    //更新供给商
    @PostMapping("/updateSupplier")
    public String updateSupplier(Supplier supplier, Integer pn, Model model) {
        //获取添加供给商的时间
        Supplier oldSupplier = supplierService.selectByPrimaryKey(supplier.getId());
        supplier.setCreateTime(oldSupplier.getCreateTime());
        supplierService.updateSupplier(supplier);  //更新
        PageInfo<Supplier> supplierPageInfo = supplierService.queryAllSupplierWithPn(pn);
        model.addAttribute("supplierPageInfo", supplierPageInfo);
        return "supplier/supplier_list";
    }

    //跳转到更新供给商页面
    @GetMapping("/toUpdateSupplier")
    public String toUpdatePage(Integer supplierId, Integer pageNum, Model model) {
        Supplier supplier = supplierService.selectByPrimaryKey(supplierId);
        //用于回显旧数据
        model.addAttribute("supplier", supplier);
        //保存要修改的记录的页码，用于更新完成后的跳转
        model.addAttribute("pageNum", pageNum);
        return "supplier/supplier_modify";
    }

    //添加供应商
    @PostMapping("/addSupplier")
    @ResponseBody
    public CommonResult addSupplier(Supplier supplier) {
        supplier.setCreateTime(new Date());
        supplier.setUpdateTime(new Date());
        supplier.setDeleted(true);
        supplierService.addSupplier(supplier);
        return CommonResult.success();
    }

    /**
     * productName不为空，查询单条，否则查询所有
     *
     * @param supplierName
     * @param model
     * @return
     */
    @GetMapping("/supplierList")
    public String queryAllCategory(@RequestParam(name = "pn", defaultValue = "1") Integer pn, String supplierName, Model model) {
        if (supplierName == null) {
            //查询所有商品
            PageInfo<Supplier> suppliers = supplierService.queryAllSupplierWithPn(pn);
            model.addAttribute("supplierPageInfo", suppliers);
            return "supplier/supplier_list";
        }
        //根据查询商品
        PageInfo<Supplier> suppliers = supplierService.querySupplierByName(supplierName);
        model.addAttribute("supplierPageInfo", suppliers);
        return "supplier/supplier_list";
    }

}
