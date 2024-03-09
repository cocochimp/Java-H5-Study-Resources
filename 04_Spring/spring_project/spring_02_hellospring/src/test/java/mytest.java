import com.koko.util.Hello;
import com.koko.util.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mytest {
    @Test
    public void test01(){
        //获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //我们的对象现在都在spring中管理，我们要使用，直接去里面取出来
        User user = (User) context.getBean("user2");

        System.out.println(user.getName());
    }
}
