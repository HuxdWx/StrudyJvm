package org.huxd.jvm.hotspot.src.share.vm.classfile;

import cn.hutool.core.io.FileUtil;
import lombok.Data;
import org.huxd.jvm.hotspot.src.share.oops.InstanceKlass;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: StudyJvm
 * @ClassName BootClassLoader
 * @description: 根类加载器
 * @author: huxd
 * @create: 2021-05-14 22:52
 * @Version 1.0
 **/
@Data
public class BootClassLoader {

    private static final String SUFFIX = ".class";

    /**
     * 类加载器加载路径
     *
     */
    private static String searchPaht = "E:\\jvm\\ziya-jvm-teach-chat-1\\target\\classes\\";

    /**
     * 用于存储该类加载器加载的所有类
     */
    private static Map<String,InstanceKlass> classLoaderData = new HashMap<>();


    private static InstanceKlass mainKlass = null;

    private static InstanceKlass loadKlass(String name){
        return loadKlass(name,true);
    }

    private static InstanceKlass loadKlass(String name, Boolean resolve){
        InstanceKlass klass = findLoadedKlass(name);
        if(null != klass){
            return klass;
        }

        klass = readAndParse(name);

        if(resolve){
            resolveKlass();
        }
        return klass;
    }

    private static InstanceKlass readAndParse(String name){
        String tmpName = name.replace(".","/");
        String filePath = searchPaht + tmpName + SUFFIX;
        // 读取字节码文件
        byte[] content = FileUtil.readBytes(FileUtil.newFile(filePath));
        // 解析字节码文件
        InstanceKlass klass = ClassFileParser.parseClassFile(content);
        // 存入数据
        classLoaderData.put(name,klass);
        return klass;
    }

    private static InstanceKlass findLoadedKlass(String name) {
        return classLoaderData.get(name);
    }

    /**
     * 加载所在的类，并做校验
     */
    public static InstanceKlass loadMainKlass(String name){
        if(null != mainKlass){
            return mainKlass;
        }
        return loadKlass(name);
    }

    private static void resolveKlass(){}
}