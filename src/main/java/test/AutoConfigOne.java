package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo
 * author：xuyy
 * date：2021/3/8  10:21 上午
 */
@Configuration
public class AutoConfigOne {

    public AutoConfigOne() {
        System.out.println(this.getClass()+"AutoConfigOne");
    }

    @Bean
    public void init1() {
        System.out.println(this.getClass() + "加载了");
    }
}
