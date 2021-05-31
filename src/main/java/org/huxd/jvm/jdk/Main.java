package org.huxd.jvm.jdk;

import org.huxd.jvm.hotspot.src.share.oops.InstanceKlass;
import org.huxd.jvm.hotspot.src.share.oops.MethodInfo;
import org.huxd.jvm.hotspot.src.share.vm.classfile.BootClassLoader;

/**
 * @program: StudyJvm
 * @ClassName Main
 * @description:
 * @author: huxd
 * @create: 2021-05-14 22:23
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
       startJvm();
    }

    /**
     * 静态启动JVM类
     */
    private static void startJvm() {
        // 通过AppClassLoader加载main函数所在的类
        InstanceKlass mainKlass = BootClassLoader.loadMainKlass("org.huxd.jvm.example.HelloWorld");

        // 找到Main方法
        MethodInfo mainMethod = JavaNativeInterface.getMethodId(mainKlass,"main","([Ljava/lang/String;)V");
        


    }
}