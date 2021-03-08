package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * todo
 * author：xuyy
 * date：2021/3/8  10:58 上午
 */
@Import({MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class ImportDemoTest {

    @Bean
    private AutoConfigTwo init3() {
        return new AutoConfigTwo();
    }
}
