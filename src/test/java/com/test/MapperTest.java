package com.test;

import com.sk.dao.StockModifyRecordMapper;
import com.sk.domain.StockModifyRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    private StockModifyRecordMapper mapper;

    @Test
    public void test1() {
        List<StockModifyRecord> records = mapper.selectWithProductAndCategory();
        records.forEach(System.out::println);
    }

    @Test
    public void test() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("aaa");
        if (objects.isEmpty()) {
            System.out.println("不为空");
        }else {
            System.out.println(Collections.emptyList());
        }
    }
}
