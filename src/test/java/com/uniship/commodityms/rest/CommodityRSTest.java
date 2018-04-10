package com.uniship.commodityms.rest;

import com.google.gson.Gson;
import com.uniship.commodityms.domain.Commodity;
import com.uniship.commodityms.domain.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommodityRSTest {

    private static final String GET_COMMODITY_LIST_URL = "/msapi/CommodityManagementMs/v1/commodityList";
    private static final String SAVE_COMMODITY_LIST_URL = "/msapi/CommodityManagementMs/v1/Commodity";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHappy_getCommodityList() throws Exception {
        this.mockMvc.perform(get(GET_COMMODITY_LIST_URL)).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString(SUCCESSFUL_MESSAGE))
                ;
    }

//    @Test
    public void testHappy_saveCommodityList() throws Exception {
        List<Commodity> commodityList = new ArrayList<>();
        Commodity commodity = new Commodity();
        commodity.setCustomerId(2);
        commodity.setDescription("third commodity");
        Document document = new Document();
        document.setId(1);
        commodity.setDocumentDetails(document);
        commodity.setName("commodity-3");
        commodity.setCreatedBy("user-1");
        commodity.setCreateDate(LocalDateTime.parse("2018-04-09T17:06:57.986"));

        commodityList.add(commodity);


        Gson gson = new Gson();
        String json = gson.toJson(commodityList);
        System.out.println("json: " + json);


        this.mockMvc.perform(post(SAVE_COMMODITY_LIST_URL)
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }
}