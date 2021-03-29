package com.sf;

import org.openjdk.jol.info.ClassLayout;

public class SyncTest {

    public static void main(String[] args) {
        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());


    }
}
