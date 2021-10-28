package com.sk.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CommonResult {

    private Integer code;//100表示请求失败，200表示成功
    private String msg;
    //用户要返回给浏览器的数据
    private Map<String, Object> data = new HashMap<>();

    public static CommonResult success() {
        CommonResult result = new CommonResult();
        result.setCode(200);
        result.setMsg("处理成功");
        return result;
    }

    public static CommonResult fail() {
        CommonResult result = new CommonResult();
        result.setCode(100);
        result.setMsg("处理失败");
        return result;
    }

    //用来添加发送给浏览器的数据
    public CommonResult add(String key, Object value) {
        this.data.put(key, value);
        return this;
    }


}
