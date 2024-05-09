package com.uni.demo;

import com.sf.ClassLoaderInterface;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Classloader {

    public static void main(String[] args)throws Exception {

//        System.out.println(123);

        String path = "/Users/songfei/Downloads/InterfaceDemo-1.0-SNAPSHOT.jar";
        File file = new File(path);
        URLClassLoader loader = new URLClassLoader(new URL[] { file.toURI().toURL() });
        Class clazz = loader.loadClass("com.sf.TestSon");
        ClassLoaderInterface driver = (ClassLoaderInterface) clazz.newInstance();
        System.out.println( driver.getId());



//        String path1 = "/Users/songfei/Downloads/InterfaceDemo-1.0-SNAPSHOT1.jar";
//        File file1 = new File(path1);
//        URLClassLoader loader1= new URLClassLoader(new URL[] { file1.toURI().toURL() });
//        Class clazz1 = loader1.loadClass("com.sf.TestSon");
//        ClassLoaderInterface driver1 = (ClassLoaderInterface) clazz1.newInstance();
//        System.out.println( driver1.getId());
//
//
//
//        ClassLoaderInterface driver2 = (ClassLoaderInterface) clazz.newInstance();
//        System.out.println( driver2.getId());






    }
}
