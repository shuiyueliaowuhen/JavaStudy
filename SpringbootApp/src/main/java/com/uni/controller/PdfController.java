package com.uni.controller;


import com.uni.util.PdfUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pdf")
public class PdfController {


    /**
     * 导出数据 生成pdf
     *
     * @param response
     */
    @GetMapping("/exportPdf")
    public void exportPdf(HttpServletResponse response) {
        // 模板路径
        String tempPath = "/Users/songfei/Downloads/shezhao2.pdf";

        //文字类
        Map<String, String> dataMap = new HashMap<>();
        // dataMap中的key要和模板中的域名对应
        dataMap.put("fill_1", "测试文字内容userName");
        dataMap.put("fill_2", "就好好");



        Map<String, Object> o = new HashMap<>();
        o.put("tempPath", tempPath);
        o.put("dataMap", dataMap);
        o.put("imgMap", new HashMap<>());
        o.put("tableList", new HashMap<>());
        try {
            OutputStream out = response.getOutputStream();
            response.setCharacterEncoding("utf-8");
            response.setHeader("content-type", "application/octet-stream");


            String fileName = URLEncoder.encode("pdf模板导出.pdf", "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            try {
                PdfUtils.creatPdf(o, out);
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
