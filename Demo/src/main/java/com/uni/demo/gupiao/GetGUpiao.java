package com.uni.demo.gupiao;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.uni.demo.HttpClientUtils;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class GetGUpiao {


    public static void main(String[] args) throws IOException {


        String token = "142839cffd1590f4fe";
        String url = "http://api.mairui.club/hslt/list/"+token;
        String s = HttpClientUtils.get(url);


        List<Gupiao> list = JSON.parseArray(s, Gupiao.class);

        list.sort(Comparator.comparing(Gupiao::getDm));

        //"sh"表示上证，"sz"表示深证

        list.parallelStream().forEach(e -> {

            if("sh".equals(e.getJys())){
                e.setJys("上证");
            }else {
                e.setJys("深证");
            }


        });


        String fileName = "/Users/songfei/Downloads/股票嗲吗.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Gupiao.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });

    }


}
