### 跨域

#### cors

CORS是一个W3C标准，全称是"跨域资源共享"（Cross-origin resource sharing）。 
它允许浏览器向跨源服务器，发出XMLHttpRequest请求，
从而克服AJAX只能同源使用的限制。 

简单请求：
浏览器在跨源AJAX请求的头信息之中，自动在添加一个Origin字段（本次请求来自哪个源 ）。
服务器根据这个值，在许可范围内，则在头信息包含 Access-Control-Allow-Origin 。

复杂请求：
会在正式通信之前，增加一次HTTP查询请求，称为"预检"请求OPTIONS 

#### jsonp

#### nginx

