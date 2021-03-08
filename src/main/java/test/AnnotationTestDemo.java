package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * todo
 * author：xuyy
 * date：2021/3/8  11:01 上午
 */
public class AnnotationTestDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportDemoTest.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(
                s -> {
                    System.out.println(s);
                }
        );

    }
}
