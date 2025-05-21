package cn.uncleyumo.chapter10.unit02.annotation;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName MyAnno
 * @createDate 5/21/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description Custom Annotation01
 */

public @interface CustomAnnotation01 {
    String aaa();
    boolean bbb() default true;
    String[] ccc();
}
