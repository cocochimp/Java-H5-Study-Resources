import com.koko.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mytest {
    @Test
    public void test01(){
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //动态代理的代理对象是接口
        UserService userService = classPathXmlApplicationContext.getBean("userService", UserService.class);
        userService.add();
    }
}
