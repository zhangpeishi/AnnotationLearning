/**
 *@author zhangpeishi 2020.12.29
 * 注解的本质是一个接口，该接口默认继承Annotation接口
 * public interface MyAnno extends java.lang.annotation
 *
 * 包含的属性,即接口中的抽象方法（本质是方法）
 * 要求：
     *  基本类型
     *  String
     *  枚举
     *  注解
     *  以上类型的数组
 * 常见的JDK中预定义的一些注解：
     *  @override :检测被该注解标注的方法是否是继承自父类（接口）的
     *  @Deprecated 该注解标注的内容，表示已经过时
     *  @SuppressWarnings:压制警告
     *      一般传递参数all @SuppressWarnings("all")
 * 自定义注解：
     * 格式：public @interface 注解名称{}

     *元注解：注解的注解  以override为例
         @Target(ElementType.METHOD)   //注释作用的目标是什么
         @Retention(RetentionPolicy.SOURCE)
         //注释该注解可以保留到什么时候
         //java代码有三个阶段 分别是 source class runtime
         public @interface Override {}

        另外还需掌握的元注解
        @documented 描述注解是否被抽取到api文档中
        @inherited 描述注解是否被子类继承
 *
 *
 */
public @interface MyAnno {
    int age() default 12;//默认属性值
    String name();
    Person p();
}
