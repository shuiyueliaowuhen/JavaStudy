package com.uni.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Test3 {

    public static void main(String[] args) {

        String str = "一院0.8875五院0.1125\n" +
                "一院0.7336五院0.0864七院0.171包事0.009\n" +
                "一院1\n" +
                "\n" +
                "一院1.0\n" +
                "一院0.7713三院0.0068五院0.1197六院0.0568七院0.0342总承包0.0108安全0.0004\n" +
                "\n" +
                "一院0.8875五院0.1125\n" +
                "一院0.7336五院0.0864七院0.18\n" +
                "一院0.82七院0.18\n" +
                "一院0.955七院0.045\n" +
                "七院0.045六院0.171一院0.784\n" +
                "一院0.955七院0.045\n" +
                "一院1.0\n" +
                "一院1\n" +
                "一院1.0\n" +
                "一院1\n" +
                "一院1.0 \n" +
                "一院0.7823三院0.1727七院0.045\n" +
                "一院1.0 \n" +
                "一院0.9813五院0.0187\n" +
                "一院0.892首席0.108\n" +
                "\n" +
                "一院0.8032五院0.1069七院0.045首席0.0449\n" +
                "一院0.9037七院0.045首席0.0513\n" +
                "一院1.0 \n" +
                "一院0.8372五院0.0838六院0.0339七院0.045\n" +
                "一院0.91七院0.09\n" +
                "\n" +
                "一院1.0 \n" +
                "一院0.8875五院0.1125\n" +
                "一院0.955七院0.045\n" +
                "一院0.9408首席0.0232七院0.036\n" +
                "\n" +
                "\n" +
                "三院1.0\n" +
                "七院0.135五院0.0918一院0.7732\n" +
                "一院0.8256五院0.1037六院0.0437七院0.027\n" +
                "\n" +
                "一院0.82七院0.18\n" +
                "一院0.91七院0.09\n" +
                "一院0.991七院0.009\n" +
                "五院0.1056六院0.0195一院0.7829首席0.042七院0.05\n" +
                "五院0.0864七院0.18一院0.7336\n" +
                "七院0.18一院0.5759五院0.0864二院0.1577\n" +
                "六院0.0444一院0.7577五院0.0976高质量0.0133二院0.0271七院0.06\n" +
                "五院0.1119七院0.0472一院0.8409\n" +
                "一院0.7336五院0.0864七院0.18\n" +
                "一院0.82七院0.18\n" +
                "一院0.8624五院0.1176七院0.02\n" +
                "\n" +
                "\n" +
                "\n" +
                "一院0.9415六院0.0585\n" +
                "一院1\n" +
                "\n" +
                "一院0.955七院0.045\n" +
                "一院0.955七院0.045\n" +
                "一院0.3821五院0.1125云南0.492安全0.0135\n" +
                "一院0.3537五院0.1125云南0.5203安全0.0135\n" +
                "一院0.7426五院0.1125云南0.1314安全0.0135\n" +
                "\n" +
                "一院0.6272 云南0.2468 五院0.1125 质量0.0135\n" +
                "一院0.6272 云南0.2348 五院0.1125 质量0.0135 首席0.012\n" +
                "一院0.4456五院0.1066七院0.045安全0.0121云南0.3907\n" +
                "一院0.7633云南0.1355五院0.1013\n" +
                "一院0.9055四院0.0945\n" +
                "\n" +
                "一院0.8613 云南0.0345 首席0.03 五院0.0563  质量0.018\n" +
                "一院0.8245安全0.0135云南0.162\n" +
                "\n" +
                "一院1.0 \n" +
                "一院1.0 \n" +
                "\n" +
                "一院0.8387云南0.0353五院0.1125安全0.0135\n" +
                "一院0.7264七院0.18五院0.0864云南0.0072\n" +
                "一院0.7264七院0.18五院0.0864云南0.0072\n" +
                "一院0.7264五院0.0864七院0.18云南0.0072\n" +
                "一院0.9775安全0.0225\n" +
                "一院0.9775安全0.0225\n" +
                "一院1\n" +
                "一院1\n" +
                "一院1\n" +
                "一院1\n" +
                "一院0.5938五院0.1069七院0.0108云南0.2415总承包0.0342安全0.0128\n" +
                "一院0.6022五院0.0864七院0.0432云南0.1292总承包0.1368安全0.0022\n" +
                "一院0.6152五院0.0864七院0.054云南0.1163总承包0.126安全0.0022\n" +
                "一院0.6544五院0.1069七院0.0135云南0.1809总承包0.0315\n" +
                "一院0.6932七院0.045安全0.0128五院0.1069云南0.1421\n" +
                "一院0.694五院0.0864云南0.0374七院0.18安全0.0022\n" +
                "一院0.6173云南0.1163五院0.0864总承包0.18\n" +
                "一院0.8695七院0.045云南0.0641安全0.0214\n" +
                "一院0.7746五院0.1069七院0.045安全0.0135云南0.0601\n" +
                "一院0.9054五院0.0428七院0.045云南0.0068\n" +
                "一院0.6196五院0.1125云南0.2079首席0.06\n" +
                "一院0.9069云南0.0932\n" +
                "一院0.7222三院0.018五院0.1103云南0.1495\n" +
                "一院0.7451七院0.18云南0.0605安全0.0144\n" +
                "一院0.6116五院0.0294云南0.0431安全0.0102七院0.18高质量0.1256\n" +
                "一院0.8146七院0.18云南0.0054\n" +
                "一院0.9008七院0.0992\n" +
                "一院0.82七院0.18\n" +
                "一院0.955七院0.045\n" +
                "一院0.7603五院0.0898七院0.045云南0.1049\n" +
                "一院0.7869五院0.1013云南0.0219七院0.09\n" +
                "六院0.0405七院0.09五院0.0962一院0.7733\n" +
                "一院0.829五院0.0256七院0.09云南0.0372安全0.0182\n" +
                "一院1.0\n" +
                "一院1.0\n" +
                "一院0.6796云南0.1685五院0.1069七院0.045\n" +
                "一院0.5029五院0.0864七院0.18云南0.2307\n" +
                "一院0.6828五院0.1069七院0.045云南0.1653\n" +
                "一院0.7864四院0.018五院0.15七院0.045安全0.0006\n" +
                "一院0.955七院0.045\n" +
                "一院1\n" +
                "一院0.8905三院0.0195七院0.09\n" +
                "一院0.7255五院0.0864云南0.0081七院0.18\n" +
                "一院0.982四院0.018\n" +
                "一院0.82七院0.18\n" +
                "一院0.639五院0.0864云南0.0946七院0.18\n" +
                "一院0.4337五院0.1149云南0.2714七院0.18\n" +
                "一院0.1229七院0.045云南0.8321\n" +
                "七院0.075一院0.907四院0.018\n" +
                "一院0.8237五院0.1046七院0.06安全0.0116\n" +
                "五院0.0864七院0.18一院0.7336\n" +
                "五院0.1125一院0.8875\n" +
                "一院0.4928四院0.0183五院0.1064七院0.045云南0.3258安全0.0117\n" +
                "一院1\n" +
                "一院0.8391五院0.0709七院0.09\n" +
                "一院0.8268云南0.1283七院0.045\n" +
                "\n" +
                "五院0.0146一院0.9854\n" +
                "一院0.6776四院0.034五院0.0964七院0.18云南0.012\n" +
                "\n" +
                "\n" +
                "安全0.0081七院0.09一院0.8419总承包0.06\n" +
                "一院0.8419安全0.0081七院0.09首席0.06\n" +
                "三院0.0081七院0.09一院0.7027工程0.066五院0.1332\n" +
                "一院0.8919四院0.0339云南0.0743\n" +
                "一院1.0\n" +
                "一院0.96七院0.04\n" +
                "七院0.09一院0.8128五院0.0972\n" +
                "\n" +
                "\n" +
                "一院0.9438云南0.0563七院0.045\n" +
                "一院0.8917云南0.1083\n" +
                "一院1\n" +
                "云南0.0062一院0.649七院0.18四院0.0503五院0.1145\n" +
                "一院0.6232七院0.09首席0.06云南0.2268\n" +
                "\n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 七院0.045五院0.045三院0.91 \n" +
                " 三院0.955七院0.045 \n" +
                "\n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                "\n" +
                " 三院1 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 三院0.9955一院0.0045 \n" +
                " 三院1.0 \n" +
                " 三院0.9874一院0.0126 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 一院0.0043安全0.0286七院0.045三院0.9221 \n" +
                " 三院1 \n" +
                " 三院1 \n" +
                " 三院0.55四院0.385一院0.0065五院0.0585 \n" +
                " 一院0.0069三院0.9931 \n" +
                " 三院0.9933一院0.0068 \n" +
                " 三院0.9874安全0.0126 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 三院0.9654安全0.0293六院0.0054 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                "\n" +
                "\n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 安全0.045三院0.955 \n" +
                " 三院0.978安全0.022 \n" +
                "\n" +
                " 三院1.0 \n" +
                " 三院0.9865五院0.0135 \n" +
                " 七院0.045一院0.0077三院0.9473 \n" +
                "\n" +
                "\n" +
                "\n" +
                " 一院0.0126三院0.9874 \n" +
                " 三院1 \n" +
                " 三院1 \n" +
                " 三院0.9937一院0.0063 \n" +
                " 三院0.9982六院0.0018 \n" +
                " 安全0.0044七院0.0225六院0.0203三院0.9481一院0.0047 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 三院0.9716安全0.0284 \n" +
                "\n" +
                " 一院0.0146三院0.8954七院0.09 \n" +
                " 三院1 \n" +
                "\n" +
                "\n" +
                "\n" +
                " 一院0.0036三院0.9964 \n" +
                " 三院1 \n" +
                " 三院1 \n" +
                " 三院0.964一院0.009安全0.027 \n" +
                "\n" +
                "\n" +
                "\n" +
                " 七院0.045三院0.9507一院0.0043 \n" +
                " 三院0.9928一院0.0072 \n" +
                "三院1\n" +
                " 三院1 \n" +
                "\n" +
                " 三院0.946七院0.054 \n" +
                " 三院0.946七院0.054 \n" +
                " 三院1 \n" +
                " 七院0.135三院0.865 \n" +
                " 一院0.0189三院0.9811 \n" +
                " 三院0.807经营四部0.148七院0.045 \n" +
                " 三院0.955七院0.045 \n" +
                " 三院0.82七院0.18 \n" +
                "\n" +
                "三院1\n" +
                "三院1\n" +
                " 三院0.955七院0.045 \n" +
                " 三院0.9926一院0.0074 \n" +
                " 一院0.0064三院0.9936 \n" +
                " 三院1 \n" +
                " 七院0.045三院0.955 \n" +
                " 七院0.0619三院0.9381 \n" +
                " 三院0.82七院0.18 \n" +
                " 一院0.0064三院0.9486七院0.045 \n" +
                " 七院0.045一院0.0064三院0.9486 \n" +
                " 一院0.0064七院0.045三院0.9486 \n" +
                " 七院0.045三院0.9507一院0.0043 \n" +
                " 三院0.91七院0.09 \n" +
                "\n" +
                " 一院0.0152三院0.9848 \n" +
                " 三院1.0 \n" +
                " 三院0.9937一院0.0063 \n" +
                " 三院0.955七院0.045 \n" +
                "\n" +
                "\n" +
                " 三院0.955七院0.045 \n" +
                " 七院0.09三院0.9043一院0.0057 \n" +
                " 一院0.0108三院0.9892 \n" +
                " 七院0.18三院0.82 \n" +
                " 三院0.82七院0.18 \n" +
                " 七院0.054三院0.946 \n" +
                " 七院0.054三院0.946 \n" +
                " 安全0.0203三院0.9798 \n" +
                "\n" +
                "\n" +
                " 三院1 \n" +
                " 三院0.9243安全0.0262一院0.0045七院0.045 \n" +
                " 三院0.928七院0.072 \n" +
                "\n" +
                "\n" +
                " 一院0.0063七院0.045三院0.9487 \n" +
                " 三院0.9455安全0.0437一院0.0108 \n" +
                " 三院0.91七院0.09 \n" +
                " 三院1.0 \n" +
                " 三院1.0 \n" +
                " 七院0.0135一院0.0064三院0.9801 \n" +
                " 七院0.18三院0.82 \n" +
                " 三院0.82七院0.18 \n" +
                " 一院0.1403总经办0.0026七院0.063三院0.7014五院0.081安全0.0117 \n" +
                " 三院0.955安全0.045 \n" +
                " 三院1 \n" +
                " 七院0.045三院0.9539一院0.0011 \n" +
                " 一院0.0011三院0.9359七院0.045五院0.018 \n" +
                " 三院1.0 \n" +
                " 三院1 \n" +
                " 三院1.0 \n" +
                "四院0.8695二院0.0405七院0.09\n" +
                "\n" +
                "四院0.91七院0.09\n" +
                "\n" +
                "四院0.9153二院0.0291五院0.0287六院0.0135安全0.011本部0.0023\n" +
                "\n" +
                "\n" +
                "四院0.964七院0.036\n" +
                "四院0.964七院0.036\n" +
                "四院0.9856六院0.0144\n" +
                "\n" +
                "四院0.9845六院0.0155\n" +
                "四院0.9845六院0.0155\n" +
                "四院0.9845六院0.0155\n" +
                "四院0.8379一院0.0195五院0.1426\n" +
                "四院0.7758一院0.017五院0.1172七院0.09\n" +
                "四院0.8531一院0.0189五院0.128\n" +
                "四院0.9647一院0.0235安全0.0118\n" +
                "\n" +
                "六院0.1069安全0.0068四院0.8863\n" +
                "安全0.0158四院0.9842\n" +
                "四院1\n" +
                "四院1.0\n" +
                "\n" +
                "四院1.0\n" +
                "\n" +
                "四院0.8345五院0.1147七院0.0508\n" +
                "四院0.9663六院0.0008七院0.0325总经办0.0005\n" +
                "四院1.0\n" +
                "四院1.0\n" +
                "四院0.7975六院0.2025\n" +
                "四院0.8875五院0.1125\n" +
                "四院0.955七院0.045\n" +
                "四院0.9328五院0.0222七院0.045\n" +
                "四院0.91七院0.09\n" +
                "四院0.748七院0.18五院0.072\n" +
                "\n" +
                "\n" +
                "四院0.91七院0.09\n" +
                "四院1\n" +
                "四院1\n" +
                "四院0.955七院0.045\n" +
                "四院0.955七院0.045\n" +
                "\n" +
                "四院0.964七院0.036\n" +
                "四院1\n" +
                "六院0.081四院0.919\n" +
                "四院0.8481五院0.1069七院0.045\n" +
                "四院1\n" +
                "六院0.0051七院0.144一院0.0313四院0.8154产品0.0043\n" +
                "四院1\n" +
                "七院0.1125四院0.2665三院0.4439六院0.1771\n" +
                "三院0.5896四院0.2119六院0.086七院0.1125\n" +
                "四院0.892七院0.108\n" +
                "一院0.081七院0.09四院0.829\n" +
                "\n" +
                "四院0.919五院0.081\n" +
                "七院0.045五院0.0983四院0.8567\n" +
                "四院0.91七院0.09\n" +
                "四院1\n" +
                "四院1\n" +
                "四院1\n" +
                "七院0.045四院0.8481五院0.1069\n" +
                "四院1\n" +
                "\n" +
                "四院0.955七院0.045\n" +
                "四院1.0\n" +
                "四院1.0\n" +
                "四院1\n" +
                "产品0.0608四院0.8493七院0.09\n" +
                "\n" +
                "四院0.955二院0.045\n" +
                "四院1\n" +
                "四院1\n" +
                "七院0.18四院0.7588六院0.0612\n" +
                "七院0.09四院0.7888五院0.1213\n" +
                "四院1.0\n" +
                "四院1\n" +
                "四院0.892七院0.108\n" +
                "四院0.892七院0.108\n" +
                "四院0.82七院0.18\n" +
                "\n" +
                "七院0.045五院0.0838高质量0.0103四院0.861\n" +
                "四院1.0\n" +
                "四院1.0\n" +
                "四院1.0\n" +
                "四院0.892七院0.108\n" +
                "\n" +
                "七院0.18四院0.6904三院0.1296\n" +
                "四院0.955七院0.045\n" +
                "七院0.09四院0.91\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "五院1.0\n" +
                "\n" +
                "\n" +
                "\n" +
                "五院1.0\n" +
                "五院1.0\n" +
                "五院1\n" +
                "五院1.0\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "五院1.0\n" +
                "\n" +
                "\n" +
                "五院1.0\n" +
                "\n" +
                "\n" +
                "五院1\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "五院0.955七院0.045\n" +
                "五院0.955七院0.045\n" +
                "五院1\n" +
                "五院1\n" +
                "五院1\n" +
                "五院1.0\n" +
                "\n" +
                "\n" +
                "五院1.0\n" +
                "\n" +
                "\n" +
                "\n" +
                "五院1.0\n" +
                "\n" +
                "\n" +
                "\n" +
                "五院1.0\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "北京1\n" +
                "\n" +
                "北京1.0\n" +
                "\n" +
                "\n" +
                "\n" +
                "北京1\n" +
                "北京1\n" +
                "北京1\n" +
                "\n" +
                "\n" +
                "北京1\n" +
                "四院0.7073产品0.0022五院0.0212二院0.03天津0.0947七院0.045北京0.0996\n" +
                "天津1\n" +
                "天津1\n" +
                "\n" +
                "湖北0.0158七院0.0437天津0.4326四院0.1093北京0.3987\n" +
                "五院0.0983七院0.108云南0.7467一院0.0471\n" +
                "一院0.0522五院0.0864七院0.18云南0.6814\n" +
                "一院0.0973七院0.045云南0.8577\n" +
                "一院0.0522云南0.6814五院0.0864七院0.18\n" +
                "一院0.0534分公0.7947五院0.1069七院0.045\n" +
                "一院0.0506云南0.7581七院0.09五院0.1013\n" +
                "云南0.7581七院0.09五院0.1013一院0.0506\n" +
                "一院0.0312云南0.6736七院0.18五院0.1152\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "七院1.0\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";

        String[] split = str.split("\\n");

        List<String> list = Arrays.asList(split);

        list.stream().filter( e -> !"".equals(e)).forEach(e ->{


            System.out.println(e);




        });




    }





}

















