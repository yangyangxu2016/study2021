package test;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * todo
 * author：xuyy
 * date：2021/3/8  11:08 上午
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //指定bean的定义信息
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(AutoConfigTwo.class);
        //指定一个名字
        registry.registerBeanDefinition("AutoConfigTwo444", rootBeanDefinition);

    }
}
