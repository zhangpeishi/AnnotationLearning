import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 测试一下这四个元注解
     @Target(ElementType.METHOD)   //注释作用的目标是什么
     @Retention(RetentionPolicy.SOURCE)
     @documented 描述注解是否被抽取到api文档中
     @inherited 描述注解是否被子类继承
 */
@Target(value = ElementType.TYPE)
//ElementType是枚举类型
//阅读源码发现Target的属性value是枚举类型的数组 所以给Target传默认属性值TYPE意思是只能作用在类上
@Retention(RetentionPolicy.RUNTIME)//规定MyAnno2这个注解描述的类在运行时识别 一般自定义的注解都用runtime
public @interface MyAnno2 {

    int age();
}
