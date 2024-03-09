package com.koko.config;
import com.koko.service.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration,这个也会被Spring容器托管，注册到容器中，因为打开注解，它本身就被定义为组件了@Component
//@Configuration该注解代表了这是一个配置类，与applicationContext.xml一样
@Configuration
@ComponentScan("com.koko.service")
@Import(kokoConfig2.class)
public class kokoConfig {

    //注册一个Bean，就相当于我们之前写的一个bean标签
    //方法名字 == bean标签的id
    //方法的返回值 == bean标签中的class属性

    @Bean
    public User getUser () {
        return new User();//就是返回要注入到bean的对象
    }
}
