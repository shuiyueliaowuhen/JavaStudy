package com.uni.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api")
public class IndexController {

    @GetMapping("/getlunbo")
    public Map getlunbo() {
        String result = "{\n" +
                "  \"status\":0,\n" +
                "  \"message\":[\n" +
                "    {\n" +
                "    \"id\":1,\n" +
                "    \"url\":\"http://www.itcast.cn/subject/phoneweb/index.html\",\n" +
                "    \"img\":\"http://m.itheima.com/images/slidead/mobile/20191213180241750x410.jpg\"\n" +
                "    },        \n" +
                "    {\n" +
                "    \"id\":2,\n" +
                "    \"url\":\"http://www.itcast.cn/subject/phoneweb/index.html\",\n" +
                "    \"img\":\"http://m.itheima.com/images/slidead/mobile/20191210154717750-410.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "    \"id\":3,\n" +
                "    \"url\":\"http://www.itcast.cn/subject/phoneweb/index.html\",\n" +
                "    \"img\":\"http://m.itheima.com/images/slidead/mobile/20190327135101750x410-%E4%BC%A0%E6%99%BA%E9%BB%91%E9%A9%AC%E7%A7%BB%E5%8A%A8%E7%AB%AF%E5%B9%BB%E7%81%AF.jpg\"\n" +
                "     }\n" +
                "  ]\n" +
                "}";

        return JSON.parseObject(result, Map.class);



    }

    @GetMapping("/getgoods")
    public Map getgoods(Integer pageindex) {
        String str = "{\n" +
                "  \"status\":0,\n" +
                "  \"message\":[\n" +
                "    {\n" +
                "      \"id\":87,\"title\":\"华为（HUAWEI）荣耀6Plus 16G双4G版\",\n" +
                "      \"add_time\":\"2015-04-19T16:51:03.000Z\",\n" +
                "      \"zhaiyao\":\"荣耀6 Plus，该机型分为两款型号，分别为PE-\",\n" +
                "      \"click\":0,\n" +
                "      \"img_url\":\"https://img13.360buyimg.com/babel/s320x320_jfs/t1/181908/15/200/45273/607fbe15E82aac16e/1f8b2323f5b2590f.jpg!cc_320x320.webp\",\n" +
                "      \"sell_price\":2195,\n" +
                "      \"market_price\":2499,\n" +
                "      \"stock_quantity\":60\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Map map = JSON.parseObject(str, Map.class);
        List<Map> message = (List)map.get("message");
        String s = JSON.toJSONString(message.get(0));
        int limit = (pageindex - 1) * 10;
        for(int i = 0;i<9;i++){
            Map<String,String> map2 = JSON.parseObject(s,Map.class);
            map2.put("title",(i+limit)+map2.get("title"));
            message.add(map2);
        }

        return map;

    }





}
