package demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Method;

/**
 * @author zhangpeishi
 *
 * 简单的测试框架
 * 当主方法执行后，会自动执行加了Check注解的方法，判断方法是否有异常，记录到文件中
 */
public class CheckTest {
    public static void main(String[] args) throws IOException {
        //1.创建计算器对象
        Calculator c = new Calculator();
        //2.获取字节码文件对象
        Class cls = c.getClass();
        //3.获取所有方法
        Method [] methods = cls.getMethods();



        int number = 0;//出现异常的次数
        BufferedWriter bw  = new BufferedWriter(new FileWriter("bug.txt"));
        //4.判断方法上是否有Check注解
        for(Method method : methods){
            if(method.isAnnotationPresent(Check.class)){
                try {
                    //5.有，执行
                    method.invoke(c);
                } catch (Exception e) {
                    e.printStackTrace();
                    //6.捕获异常
                    number++;
                    //记录到文件中
                    bw.write(method.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试一共出现"+number+"次异常");
        bw.flush();
        bw.close();
    }
}
