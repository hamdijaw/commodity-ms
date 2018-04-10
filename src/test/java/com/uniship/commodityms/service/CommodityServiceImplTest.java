package com.uniship.commodityms.service;


import com.uniship.commodityms.domain.Commodity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommodityServiceImplTest {

    @Autowired
    private CommodityService commodityService;

    @Test
    public void testHappy_getAllCommodity() throws Exception {
        List<Commodity> allCommodity = commodityService.getAllCommodity(1);
//        assertEquals(2, allCommodity.size());
        allCommodity = commodityService.getAllCommodity(2);
    }
}