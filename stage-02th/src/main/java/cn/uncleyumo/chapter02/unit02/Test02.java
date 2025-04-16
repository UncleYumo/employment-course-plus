package cn.uncleyumo.chapter02.unit02;

/**
 * @author uncle_yumo
 * @fileName Test02
 * @createDate 2025/4/16 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test02 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(
                "Available processors(可用处理器数量): " +
                        runtime.availableProcessors()
        );
        System.out.println(
                "Total memory(总内存): " +
                        runtime.totalMemory() / 1024 / 1024 + "MB"
        );
        System.out.println(
                "Free memory(可用内存): " +
                        runtime.freeMemory() / 1024 / 1024 + "MB"
        );
        System.out.println(
                "Max memory(最大内存): " +
                        runtime.maxMemory() / 1024 / 1024 + "MB"
        );
        System.out.println(
                "OS name(操作系统名称): " +
                        System.getProperty("os.name")
        );
        System.out.println(
                "OS version(操作系统版本): " +
                        System.getProperty("os.version")
        );
        System.out.println(
                "OS architecture(操作系统架构): " +
                        System.getProperty("os.arch")
        );
        System.out.println(
                "Java version(Java版本): " +
                        System.getProperty("java.version")
        );
        System.out.println(
                "Java vendor(Java厂商): " +
                        System.getProperty("java.vendor")
        );
        System.out.println(
                "Java home(Java安装路径): " +
                        System.getProperty("java.home")
        );
        System.out.println(
                "Java class path(Java类路径): " +
                        System.getProperty("java.class.path")
        );
        System.out.println(
                "Java library path(Java库路径): " +
                        System.getProperty("java.library.path")
        );
        System.out.println(
                "Java vendor url(Java厂商网址): " +
                        System.getProperty("java.vendor.url")
        );
        System.out.println(
                "Java specification version(Java规范版本): " +
                        System.getProperty("java.specification.version")
        );
        System.out.println(
                "Java specification vendor(Java规范厂商): " +
                        System.getProperty("java.specification.vendor")
                );
        System.out.println(
                "Java VM name(Java虚拟机名称): " +
                        System.getProperty("java.vm.name")
        );
        System.out.println(
                "Java VM vendor(Java虚拟机厂商): " +
                        System.getProperty("java.vm.vendor")
        );
        System.out.println(
                "Java VM version(Java虚拟机版本): " +
                        System.getProperty("java.vm.version")
        );
        System.out.println(
                "Java VM specification version(Java虚拟机规范版本): " +
                        System.getProperty("java.vm.specification.version")
        );
        System.out.println(
                "Java VM specification vendor(Java虚拟机规范厂商): " +
                        System.getProperty("java.vm.specification.vendor")
        );
        System.out.println(
                "Java VM specification name(Java虚拟机规范名称): " +
                        System.getProperty("java.vm.specification.name")
        );
        System.out.println(
                "Java runtime name(Java运行时名称): " +
                        System.getProperty("java.runtime.name")
        );
        System.out.println(
                "Java runtime version(Java运行时版本): " +
                        System.getProperty("java.runtime.version")
        );
        System.out.println(
                "Java compiler name(Java编译器名称): " +
                        System.getProperty("java.compiler")
        );
        System.out.println(
                "Java compiler version(Java编译器版本): " +
                        System.getProperty("java.compiler.version")
        );
        System.out.println(
                "Java ext. dirs(Java扩展目录): " +
                        System.getProperty("java.ext.dirs")
        );
        System.out.println(
                "File separator(文件分隔符): " +
                        System.getProperty("file.separator")
        );
        System.out.println(
                "Path separator(路径分隔符): " +
                        System.getProperty("path.separator")
        );
        System.out.println(
                "Line separator(行分隔符): " +
                        System.getProperty("line.separator")
        );
        System.out.println(
                "User name(用户名): " +
                        System.getProperty("user.name")
        );
        System.out.println(
                "User home(用户主目录): " +
                        System.getProperty("user.home")
        );
        System.out.println(
                "User dir(用户当前目录): " +
                        System.getProperty("user.dir")
        );
    }
}
