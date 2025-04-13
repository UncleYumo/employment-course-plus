package cn.uncleyumo.chapter01.unit02;

/**
 * @author uncle_yumo
 * @fileName Singleton
 * @createDate 2025/4/11 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@SuppressWarnings("InstantiationOfUtilityClass")
public class SingletonCaseAft {
    private static SingletonCaseAft INSTANCE = null;

    private SingletonCaseAft() {
    }

    public static synchronized SingletonCaseAft getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonCaseAft();
        }
        return INSTANCE;
    }
}