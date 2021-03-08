package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo
 * author：xuyy
 * date：2021/3/8  10:21 上午
 */
@Configuration
public class AutoConfigTwo {

    public AutoConfigTwo(){
        System.out.println(this.getClass()+"AutoConfigTwo");
    }

    @Bean
    public void init2() {
        System.out.println(this.getClass() + "加载了");
    }
}
