package cn.uncleyumo.chapter01.unit02;

/**
 * @author uncle_yumo
 * @fileName Singleton
 * @createDate 2025/4/11 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class SingletonCasePre {
    private static final SingletonCasePre INSTANCE = new SingletonCasePre();

    private SingletonCasePre() {
    }

    public static SingletonCasePre getInstance() {
        return INSTANCE;
    }
}