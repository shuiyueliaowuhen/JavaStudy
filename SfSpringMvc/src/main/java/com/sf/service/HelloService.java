package com.sf.service;

import com.sf.annotation.SfService;

public interface HelloService {

    String query(String name, String age);

    String insert(String param);

    String update(String param);


}

