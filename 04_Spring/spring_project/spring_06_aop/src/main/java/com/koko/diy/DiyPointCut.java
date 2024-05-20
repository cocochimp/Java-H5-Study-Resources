package com.koko.diy;

public class DiyPointCut {
    public void beforeMethod () {
        System.out.println("方法执行之前");
    }

    public void afterMethod(){
        System.out.println("方法执行之后");
    }
}
