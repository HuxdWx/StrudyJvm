package org.huxd.jvm.hotspot.src.share.oops;

import lombok.Data;

/**
 * @program: StudyJvm
 * @ClassName InstanceKlass
 * @description: 通过AppClassLoader加载main函数所在的类
 * @author: huxd
 * @create: 2021-05-14 22:36
 * @Version 1.0
 **/
@Data
public class InstanceKlass extends Klass{

    private byte[] magic = new byte[4];
    private byte[] minorVersion = new byte[2];
    private byte[] majorVersion = new byte[2];


}