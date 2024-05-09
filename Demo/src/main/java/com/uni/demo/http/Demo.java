package com.uni.demo.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Demo {



        /**
         * Http get请求
         * @param httpUrl 连接
         * @return 响应数据
         */
        public static String doGet(String httpUrl){
            //链接
            HttpURLConnection connection = null;
            InputStream is = null;
            BufferedReader br = null;
            StringBuffer result = new StringBuffer();
            try {
                //创建连接
                URL url = new URL(httpUrl);
                connection = (HttpURLConnection) url.openConnection();
                //设置请求方式
                connection.setRequestMethod("GET");
                //设置连接超时时间
                connection.setReadTimeout(15000);
                //开始连接
                connection.connect();
                //获取响应数据
                if (connection.getResponseCode() == 200) {
                    //获取返回的数据
                    is = connection.getInputStream();
                    if (null != is) {
                        br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                        String temp = null;
                        while (null != (temp = br.readLine())) {
                            result.append(temp);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != br) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != is) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //关闭远程连接
                connection.disconnect();
            }
            return result.toString();
        }

        /**
         * Http post请求
         * @param httpUrl 连接
         * @param param 参数
         * @return
         */
        public static String doPost(String httpUrl, String param) {
            StringBuffer result = new StringBuffer();
            //连接
            HttpURLConnection connection = null;
            OutputStream os = null;
            InputStream is = null;
            BufferedReader br = null;
            try {
                //创建连接对象
                URL url = new URL(httpUrl);
                //创建连接
                connection = (HttpURLConnection) url.openConnection();
                //设置请求方法
                connection.setRequestMethod("POST");
                //设置连接超时时间
                connection.setConnectTimeout(15000);
                //设置读取超时时间
                connection.setReadTimeout(15000);
                //DoOutput设置是否向httpUrlConnection输出，DoInput设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
                //设置是否可读取
                connection.setDoOutput(true);
                connection.setDoInput(true);
                //设置通用的请求属性
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
                connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");

                //拼装参数
                if (null != param && param.equals("")) {
                    //设置参数
                    os = connection.getOutputStream();
                    //拼装参数
                    os.write(param.getBytes("UTF-8"));
                }
                //设置权限
                //设置请求头等
                //开启连接
                //connection.connect();
                //读取响应
                if (connection.getResponseCode() == 200) {
                    is = connection.getInputStream();
                    if (null != is) {
                        br = new BufferedReader(new InputStreamReader(is, "GBK"));
                        String temp = null;
                        while (null != (temp = br.readLine())) {
                            result.append(temp);
                            result.append("\r\n");
                        }
                    }
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭连接
                if(br!=null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(os!=null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //关闭连接
                connection.disconnect();
            }
            return result.toString();
        }

        public static void main(String[] args) {
            String message = doPost("https://s.upapi.cn/njszy/2022/2/27/6ee1f3bbe67d8df3e839595c43558fe9_%E7%87%95%E5%AD%90%E7%9F%B6%E6%95%B4%E6%B2%BB%E5%BC%80%E5%8F%91%E5%85%AC%E5%8F%B8%E7%BB%8F%E4%BA%94%E8%B7%AF%E7%94%B5%E5%8A%9B%E9%9A%A7%E9%81%93%E5%8F%8A110%E5%8D%83%E4%BC%8F%E7%87%95%E4%B8%87#1%E7%BA%BF%E3%80%81%E6%99%93%E8%BF%88#1%E7%BA%BF%E8%BF%81%E7%A7%BB%E5%B7%A5%E7%A8%8B%E5%88%9D%E8%AE%BE%E3%80%81%E6%96%BD%E5%B7%A5%E5%9B%BE%E5%8F%8A%E7%AB%A3%E5%B7%A5%E7%A1%AE%E8%AE%A4%E5%87%BD.pdf", "");
            System.out.println(message);
        }



}
