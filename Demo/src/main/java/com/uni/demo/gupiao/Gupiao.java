package com.uni.demo.gupiao;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Gupiao {

    @ExcelProperty("股票代码")
    private String dm;

    @ExcelProperty("股票名字")
    private String mc;

    @ExcelProperty("交易所")
    private String jys;


}
